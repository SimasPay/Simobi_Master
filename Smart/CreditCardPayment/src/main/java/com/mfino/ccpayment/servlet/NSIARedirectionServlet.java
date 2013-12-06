package com.mfino.ccpayment.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mfino.dao.CreditCardTransactionDAO;
import com.mfino.dao.DAOFactory;
import com.mfino.domain.CreditCardTransaction;
import com.mfino.fix.CmFinoFIX;
import com.mfino.hibernate.session.HibernateSessionHolder;
import com.mfino.util.ConfigurationUtil;

/**
 * Servlet implementation class NSIARedirectionServlet
 */
public class NSIARedirectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(NSIARedirectionServlet.class);
	
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
	public NSIARedirectionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/paymentResponse.jsp");
		String responseString = "Invalid Transaction,Try Again";
		boolean amountGreaterLimit = true;
		Long cctransactionid = null;
		String amount = null;
		String statusCode = null;
		String sessionID = null;
		log.info("In NSIA Redirection Servlet Request");

//		if (!IPFilterting.validip(request.getRemoteAddr())) {
//			log.info("IP check failed sending stop request to the NSIA. Request came from="	+ request.getRemoteAddr());
//			request.setAttribute("resultMsg", responseString);
//			dispatcher.forward(request, response);		
//			return;
//		}
		try {
			cctransactionid = Long.parseLong(request.getParameter("TRANSIDMERCHANT"));
			amount = request.getParameter("AMOUNT");
			statusCode = request.getParameter("STATUSCODE");
			sessionID = request.getParameter("SESSIONID");
			log.info("cctransactionid=" + cctransactionid + " amount=" + amount + " statusCode=" + statusCode + " sessionID=" + sessionID);
		} catch (Exception e) {
			log.info("Exception occured while parsing the input parameters");
			responseString = "There is some problem with your transaction, Please contact administrator.";
			request.setAttribute("resultMsg", responseString);
			dispatcher.forward(request, response);
			return;
		}

		Session session = sessionFactory.openSession();
		hibernateSessionHolder.setSession(session);		
		DAOFactory.getInstance().setHibernateSessionHolder(hibernateSessionHolder);
		try{
			processRequest(request, response, dispatcher, amountGreaterLimit,
					cctransactionid, amount, sessionID);
		}
		finally
		{
			if(session!=null)
			{
				session.close();
			}
		}
		dispatcher.forward(request, response);
	}

	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response, RequestDispatcher dispatcher,
			boolean amountGreaterLimit, Long cctransactionid, String amount,
			String sessionID) throws ServletException, IOException {
		String responseString;
		CreditCardTransactionDAO dao = DAOFactory.getInstance().getCreditCardTransactionDAO();
		CreditCardTransaction record = dao.getById(cctransactionid);
		if (record == null) {
			log.info("Invalid ccTransactionid=" + cctransactionid);
			responseString = "Invalid Transaction ID";
			request.setAttribute("resultMsg", responseString);
			return;
		}
		String ccamount = record.getAmount().toString() + ".00";
		if (!ccamount.equals(amount)) {
			log.info("Invalid Amount=" + amount	+ " specfied for the cctransctionid=" + cctransactionid);
			responseString = "Invalid Amount,Try Again";
			request.setAttribute("resultMsg", responseString);
			return;
		}
		if (!sessionID.equals(record.getSessionID())) {
			log.info("Invalid sessionid=" + sessionID + "specfied for the cctransctionid=" + cctransactionid);
			responseString = "Invalid Session ID please try again";
			request.setAttribute("resultMsg", responseString);
			return;
		}
		String messageToSend = null;
		if ("Success".equalsIgnoreCase(record.getBankResMsg()) && (CmFinoFIX.TransStatus_Notified.equals(record.getTransStatus())||CmFinoFIX.TransStatus_NSIA_EDU_Pending.equals(record.getTransStatus()))) {
			if (record.getAmount().compareTo(new BigDecimal(ConfigurationUtil.getCreditcardMaximumAmountLimit())) > 0) {
				amountGreaterLimit = false;
				messageToSend = ConfigurationUtil.getCreditcardMaximumAmountAlertMessage();
				messageToSend = StringUtils.replace(messageToSend, "${Amount}",	record.getAmount().toString());
				messageToSend = StringUtils.replace(messageToSend, "${CCTransactionID}",record.getID().toString());				
			}
			if (!amountGreaterLimit) {
				responseString = messageToSend;
				request.setAttribute("resultMsg", responseString);
				return;
			}
			responseString = ConfigurationUtil.getCCTransactionCompletionMessage();
			responseString = StringUtils.replace(responseString, "${Amount}",	record.getAmount().toString());			
			responseString = StringUtils.replace(responseString, "${CCTransactionID}",record.getID().toString());			
			request.setAttribute("resultMsg", responseString);
		}else{
			responseString = "Your Transaction Failed.";
			log.info("Transaction failed because of the TransStatus= " + record.getTransStatus() + "and Bank response message" +record.getBankResMsg() + "for the record id" + cctransactionid);
			request.setAttribute("resultMsg", responseString);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
//	public static void main(String[] args) {
//		String messageToSend = ConfigurationUtil.getCreditcardMaximumAmountAlertMessage();
//		messageToSend = StringUtils.replace(messageToSend, "$(Amount)",	"1000");
//		messageToSend = StringUtils.replace(messageToSend, "${CCTransactionID}","123");
//		System.out.println(messageToSend);
//	}

}
