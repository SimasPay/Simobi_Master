package com.mfino.ccpayment.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mfino.ccpayment.util.IPFilterting;
import com.mfino.ccpayment.util.MessageDigestEncoder;
import com.mfino.dao.CreditCardTransactionDAO;
import com.mfino.dao.DAOFactory;
import com.mfino.domain.Address;
import com.mfino.domain.CardInfo;
import com.mfino.domain.CreditCardTransaction;
import com.mfino.fix.CmFinoFIX;
import com.mfino.hibernate.session.HibernateSessionHolder;
import com.mfino.util.ConfigurationUtil;

/**
 * Servlet implementation class GetDataServlet
 */
public class GetDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(GetDataServlet.class); 

	protected static SessionFactory sessionFactory = null;

	protected static HibernateSessionHolder hibernateSessionHolder = null;

	static {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("..\\spring-datasource-beans.xml");
		sessionFactory = appContext.getBean(SessionFactory.class);
		hibernateSessionHolder = appContext.getBean(HibernateSessionHolder.class);
	}
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetDataServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		log.info("In Get Data Servlet..");
		ServletOutputStream out = response.getOutputStream();		
		if(!IPFilterting.validip(request.getRemoteAddr())){
			out.println("Stop");
			log.info("IP Check Failed sending stop request to the NSIA. Request came from=" +request.getRemoteAddr());
			return;
		}
		Session session = sessionFactory.openSession();
		hibernateSessionHolder.setSession(session);		
		DAOFactory.getInstance().setHibernateSessionHolder(hibernateSessionHolder);
		try {
			processRequest(request, out);
		}catch(Exception e){
			log.info("Exception occured in Get Data Servlet.." + e);
		}
		finally
		{
			if(session!=null)
			{
				session.close();
			}
		}
	}

	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	private void processRequest(HttpServletRequest request,
			ServletOutputStream out) throws IOException,
			UnsupportedEncodingException, FactoryConfigurationError,
			XMLStreamException {
		String invoiceNo = request.getParameter("invoiceNo");
		String amountStr = request.getParameter("amount");
		String refNum = request.getParameter("ref");
		log.info("InvoiceNo="+ invoiceNo +" amount="+amountStr+" refNum"+refNum);

		CreditCardTransactionDAO dao = DAOFactory.getInstance().getCreditCardTransactionDAO();

		CreditCardTransaction cct = dao.getById(Long.parseLong(invoiceNo));
		if(cct == null) {
			log.info("Invoice number is not found in our DB");
			log.info("Sending stop to NSIA");
			out.println("Stop");
			return;
		}
		if(!CmFinoFIX.TransStatus_NSIA_EDU_Pending.equals(cct.getTransStatus())) {
			log.info("Invalid Status" + cct.getTransStatus());
			log.info("Sending stop response to NSIA");
			out.println("Stop");
			return;
		}
		BigDecimal amount = BigDecimal.ZERO;
		try {
			amount = new BigDecimal(amountStr);
		} catch(NumberFormatException ex) { 
			log.info("NumberFormatException" + ex.getMessage());
			log.info("Sending stop response to NSIA");
			out.println("Stop");
			return;
		}

		if(!amount.equals(cct.getAmount())) {
			log.info("Invalid Amount" + amount);
			log.info("Sending stop response to NSIA");
			out.println("Stop");
			return;
		}
		String merchantId = ConfigurationUtil.getCreditcardMerchantid();
		String sharedKey = ConfigurationUtil.getCreditcardTransactionPassword();

		String signature = merchantId + sharedKey + invoiceNo;
		try {
			signature = MessageDigestEncoder.SHA1(signature);
		} catch (NoSuchAlgorithmException e) {
			log.info("could not get signature", e);
			log.info("Sending stop response to NSIA");
			out.println("Stop");
			return;
		}
		if(!signature.equals(refNum)) {
			log.info("Invalid Signature " + signature);
			log.info("Sending stop response to NSIA");
			out.println("Stop");
			return;
		}
		XMLOutputFactory factory = XMLOutputFactory.newInstance();
		XMLStreamWriter writer = factory.createXMLStreamWriter(out);

		String fullname = cct.getSubscriber().getFirstName() + cct.getSubscriber().getLastName();
		Set<CardInfo> cardInfos = cct.getSubscriber().getCardInfoFromSubscriberID();
		CardInfo cardinfo1 = null;
		for(CardInfo cardinfo : cardInfos) {
			if(CmFinoFIX.UserStatus_Active.equals(cardinfo.getCardStatus())) {
				cardinfo1 = cardinfo;
				break;
			}
		}
		String cardName = "";
		Address address = null;
		String addressStr = " ";
		Address billingAddress = null;
		String billingAddressStr = " ";
		String line2 = "";
		String zipcode = "";
		if(cardinfo1 != null) {
			cardName = cardinfo1.getNameOnCard();
			address = cardinfo1.getAddress();
			if(address != null) {
				if(address.getLine2() != null) {
					line2 = address.getLine2();
				}
				if(address.getZipCode()!=null){
					zipcode=address.getZipCode();
				}
				addressStr = address.getLine1() +" "+ line2 +" " + address.getCity() +" " + address.getState() +" "+ address.getCountry();
			}
			line2 = "";
			billingAddress = cardinfo1.getAddressByBillingAddressID();
			if(billingAddress != null) {
				if(billingAddress.getLine2() != null) {
					line2 = billingAddress.getLine2();
				}
				billingAddressStr = billingAddress.getLine1() +" "+ line2 +" " +billingAddress.getCity() +" " + billingAddress.getState() +" "+ billingAddress.getCountry();
			}
		}
		String birthDate = "";
		if(cct.getSubscriber().getUserBySubscriberUserID().getDateOfBirth() != null) {
			SimpleDateFormat date = new SimpleDateFormat("yyyy MMMMM dd");
			birthDate = date.format(cct.getSubscriber().getUserBySubscriberUserID().getDateOfBirth());
		}
		writer.writeStartDocument("1.0");

		writer.writeStartElement("information");
		writer.writeStartElement("personal");

		writer.writeStartElement("full_name");
		writer.writeCharacters(fullname);
		writer.writeEndElement();

		writer.writeStartElement("address");
		writer.writeCharacters(addressStr);
		writer.writeEndElement();

		writer.writeStartElement("zip_code");
		writer.writeCharacters(zipcode);
		writer.writeEndElement();

		writer.writeStartElement("home_phone");
		writer.writeCharacters(cct.getSubscriber().getUserBySubscriberUserID().getHomePhone());
		writer.writeEndElement();

		writer.writeStartElement("work_phone");
		writer.writeCharacters(cct.getSubscriber().getUserBySubscriberUserID().getWorkPhone());
		writer.writeEndElement();

		writer.writeStartElement("mobile_phone");
		writer.writeCharacters(cct.getSubscriber().getUserBySubscriberUserID().getUsername());
		writer.writeEndElement();

		writer.writeStartElement("contactable_phone");
		writer.writeCharacters(cct.getSubscriber().getUserBySubscriberUserID().getUsername());
		writer.writeEndElement();

		writer.writeStartElement("email");
		writer.writeCharacters(cct.getSubscriber().getUserBySubscriberUserID().getEmail());
		writer.writeEndElement();

		writer.writeStartElement("birth_date");
		writer.writeCharacters(birthDate);
		writer.writeEndElement();

		writer.writeStartElement("billing_address");
		writer.writeCharacters(billingAddressStr);
		writer.writeEndElement();

		writer.writeStartElement("name_on_card");
		writer.writeCharacters(cardName);
		writer.writeEndElement();

		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeEndDocument();
		writer.flush();
		writer.close();
		log.info("Updating the status of the transaction to NSIA_EDU_DATA_SENT to cctrxid"+ cct.getID());
		cct.setTransStatus(CmFinoFIX.TransStatus_NSIA_EDU_Data_Sent);
		cct.setPaymentGatewayEDU(Boolean.TRUE);
		dao.save(cct);
	}
}
