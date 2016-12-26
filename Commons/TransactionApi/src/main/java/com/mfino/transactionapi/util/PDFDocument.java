package com.mfino.transactionapi.util;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.html.WebColors;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPCellEvent;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.mfino.constants.ServiceAndTransactionConstants;
import com.mfino.domain.Pocket;
import com.mfino.domain.Subscriber;
import com.mfino.domain.SubscriberMdn;
import com.mfino.fix.CmFinoFIX;
import com.mfino.transactionapi.vo.TransactionDetails;
import com.mfino.util.MfinoUtil;

/**
 * 
 * @author Amar
 *
 */
public class PDFDocument {

	private static Logger log = LoggerFactory.getLogger(PDFDocument.class);
	Document document;
	PdfWriter pdfwriter;
	PdfPTable table;
	PdfPTable transactionTable;
	PdfPCell cell;
	//PDFReportEvents events;
	File filePath;
	int numColumns;
	int numRows;
	int colIndex;
	int rowIndex = 7;
	int rowCount = 0;
	final int PADDING_LENGTH=50;
	Integer language = new Integer(0); 
	
	public PDFDocument(File filePath, String encryptionKey)
	{
		try{
			this.filePath = filePath;
			this.document = new Document(PageSize.A4);
			this.pdfwriter = PdfWriter.getInstance(this.document,
					new FileOutputStream(filePath));

			pdfwriter.setEncryption(encryptionKey.getBytes(), null, PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128);
			//this.events = new PDFReportEvents();
			//this.pdfwriter.setBoxSize("art", PageSize.A4);
			//this.pdfwriter.setPageEvent(this.events);
			
			this.document.setMargins(0, 0, 5, 5);
			InputStream is = this.getClass().getResourceAsStream("/Footer-PDF-Simaspay.jpg");
//			InputStream is = new FileInputStream("C:/Users/Gopal/Desktop/Wars/Footer-PDF-Simaspay.jpg");
			byte[] bytes = IOUtils.toByteArray(is);
			Image logo = Image.getInstance(bytes);
			logo.scalePercent(45);
			logo.setAlignment(Element.ALIGN_LEFT);
			Chunk chunk = new Chunk(logo, 0,0 );
//			HeaderFooter headerFooter = new HeaderFooter(new Phrase(ConfigurationUtil.getPdfHistoryFooter()), false);
			HeaderFooter headerFooter = new HeaderFooter(new Phrase(chunk), false);
			headerFooter.setAlignment(Element.ALIGN_CENTER);
			headerFooter.setBorder(0);
			this.document.setFooter(headerFooter);
			
			this.document.open();

		}catch(Exception e){
			log.error("PDFReport: Failed to create pdf report",e);
		}

	}

	public void addLogo() {
		try{
			
			PdfPTable logoTable = new PdfPTable(2);
			Phrase phrase = new Phrase();
			phrase.add(new Chunk("MUTASI REKENING", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, new Color(0, 0, 0))));
			phrase.add(new Chunk("\nAccount Statement",  FontFactory.getFont(FontFactory.HELVETICA, 10, Font.ITALIC, new Color(0, 0, 0))));
			PdfPCell cell1 = new PdfPCell(phrase);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell1.setBorder(0);
			logoTable.addCell(cell1);
			InputStream is = this.getClass().getResourceAsStream("/simaspay_logo_for_PDF.png");
//			InputStream is = new FileInputStream("C:/Users/Gopal/Desktop/Wars/simaspay_logo_for_PDF.png");
			byte[] bytes = IOUtils.toByteArray(is);
			Image image = Image.getInstance(bytes);
			image.scaleAbsolute(100, 0);
			image.scalePercent(5);
			image.setBorder(0);
			PdfPCell cell = new PdfPCell(image);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setBorder(0);
			
			logoTable.addCell(cell);
			logoTable.setLockedWidth(true);
			logoTable.setTotalWidth(this.document.getPageSize().getWidth()-PADDING_LENGTH);
			this.document.add(logoTable);
		}catch(Exception e){
			log.error("PDFReport: Failed to load Logo",e);
		}

	}
	
	public void addSubscriberDetails(TransactionDetails txnDetails, SubscriberMdn subscriberMDN, Pocket pocket)throws IOException, DocumentException 
	{
		this.table = new PdfPTable(2);
		
		int[] widths = {3,2};
		this.table.setWidths(widths);
		this.table.setHorizontalAlignment(Element.ALIGN_LEFT);
		Integer Language = (int)subscriberMDN.getSubscriber().getLanguage();
		
		String title;
		String name;
		String cardName;
		String currentBalance;
		String mdn;
		String date;
		String period;
		String transactionDetails;
		String cardNo;
		if(Language.equals(CmFinoFIX.Language_Bahasa))
		{
			title = "Transaksi Uangku";
			name = "Nama          : ";
			cardName = "Nama Kartu  : ";
			currentBalance = "Saldo Saat ini  : ";
			mdn = "Nomor Ponsel  : ";
			date = "Tangal Cetak    : ";
			period = "Periode       : ";
			transactionDetails = "Rincian Transaksi" ;	
			cardNo = "Nomor Kartu : ";
		}
		else
		{
			title = "Uanku E-Statement";
			name = "Name           : ";
			cardName = "Card Name  : ";
			currentBalance = "Current Balance : ";
			mdn = "Mobile No     : ";
			date = "Print Date      : ";
			period = "Period          : ";
			transactionDetails = "Transaction Details" ;
			cardNo = "Card Number : ";
		}
		
		
		Phrase phrase = new Phrase(18, new Chunk(title, FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new Color(0, 0, 0))));
		PdfPCell headerCell = new PdfPCell(phrase);
		headerCell.setBackgroundColor(Color.LIGHT_GRAY);
		headerCell.setBorder(0);
		headerCell.setPaddingTop(10.0f);
		headerCell.setPaddingBottom(10.0f);
		headerCell.setColspan(2);
		this.table.addCell(headerCell);
		
		String emptyString = "";
		PdfPCell emptyCell = new PdfPCell(new Phrase(emptyString));
//		emptyCell.setBackgroundColor(Color.LIGHT_GRAY);
//		emptyCell.setBorder(0);
//		this.table.addCell(emptyCell);
		
		
		name = name + (subscriberMDN.getSubscriber().getNickname() != null ? subscriberMDN.getSubscriber().getNickname() : "");
		PdfPCell nameCell = new PdfPCell(new Phrase(name));
		nameCell.setBorder(0);
		this.table.addCell(nameCell);
		
		currentBalance = currentBalance + pocket.getCurrentbalance();
		PdfPCell currentBalanceCell = new PdfPCell(new Phrase(currentBalance));
		currentBalanceCell.setBorder(0);
		this.table.addCell(currentBalanceCell);
		
		mdn = mdn + txnDetails.getSourceMDN();
		PdfPCell mdnCell = new PdfPCell(new Phrase(mdn));
		mdnCell.setBorder(0);
		this.table.addCell(mdnCell);
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		date = date + dateFormat.format(new Date());
		PdfPCell dateCell = new PdfPCell(new Phrase(date));
		dateCell.setBorder(0);
		this.table.addCell(dateCell);
		
		period = period + dateFormat.format(txnDetails.getFromDate()) + "-" + dateFormat.format(txnDetails.getToDate());
		PdfPCell periodCell = new PdfPCell(new Phrase(period));
		periodCell.setBorder(0);
		this.table.addCell(periodCell);
		
		emptyCell.setBackgroundColor(Color.WHITE);
		this.table.addCell(emptyCell);
		
		this.table.addCell(emptyCell);
		this.table.addCell(emptyCell);
		this.table.addCell(emptyCell);
		this.table.addCell(emptyCell);
		
		PdfPCell transactionDetailsCell = new PdfPCell(new Phrase(transactionDetails));
		transactionDetailsCell.setBorder(0);
		transactionDetailsCell.setPaddingBottom(10.0f);
		this.table.addCell(transactionDetailsCell);		
		this.table.addCell(emptyCell);		
		this.document.add(this.table);
	}

	
	private void addSubscriberDetailsHeader(TransactionDetails txnDetails, SubscriberMdn subscriberMDN, Pocket pocket)throws IOException, DocumentException
	{
	        
		this.table = new PdfPTable(4); 
		this.table.setLockedWidth(true);
		this.table.setTotalWidth(this.document.getPageSize().getWidth()-20);
		int[] widths = {1,2,1,1};
     	this.table.setWidths(widths);
		language = (int)subscriberMDN.getSubscriber().getLanguage();
				
		addEmptyCellToSubscriberDetailsTable(this.table, 4, 0.1f);
		
		Phrase phrase = new Phrase(18, new Chunk(getTitle(txnDetails), FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new Color(0, 0, 0))));
		PdfPCell headerCell = new PdfPCell(phrase);
		headerCell.setBackgroundColor(Color.LIGHT_GRAY);
		headerCell.setBorder(0);
		headerCell.setPaddingTop(10.0f);
		headerCell.setPaddingBottom(10.0f);
		headerCell.setPaddingLeft(20.0f);
		headerCell.setColspan(4);
		this.table.addCell(headerCell);
		
	}
	
	private void addSubscriberDetailsSpecificToNFCTxnHistory(TransactionDetails txnDetails, Pocket pocket)
	{
		String cardName = "Card Name";
		String currentBalance = "Current Balance";
		String cardNo = "Card Number";
		
		String cardNameVal = pocket.getCardalias() != null ? pocket.getCardalias() : "";
		String cardPANVal = pocket.getCardpan();
		
		addCellToSubscriberDetailsTable(this.table, LanguageTranslator.translate(language, cardName), cardNameVal);
		String currentBalanceVal;
		if(txnDetails.getAmount() != null)
		{
			currentBalanceVal = "Rp. " + MfinoUtil.getNumberFormat().format(txnDetails.getAmount());
		}
		else
		{
			currentBalanceVal =  LanguageTranslator.translate(language, "Not Available");
		}
		addCellToSubscriberDetailsTable(this.table, LanguageTranslator.translate(language, currentBalance), currentBalanceVal);
		addCellToSubscriberDetailsTable(this.table, LanguageTranslator.translate(language, cardNo), cardPANVal);
	}
	
	private void addSubscriberDetailsSpecificToEmoneyTxnHistory(TransactionDetails txnDetails, SubscriberMdn subscriberMDN, Pocket pocket, BigDecimal openingBalance,BigDecimal endingBalance)
	{
		String currentBalance = "Saldo Akhir",currentBalance_english="Ending Balance";
		String 	name = "Nama Lengkap",name_english="Full Name";
		String mdn = "No Rekening",mdn_english="Account No";
		String accountType="Tipe Akun";
		String beginingBalance="Saldo Awal",beginingBalance_english="Begining Balance";
		String accountType_english="Account Type";
		String account_Type="";
		if(txnDetails.getSourcePocketCode()!=null){
			
				account_Type=txnDetails.getSourcePocketCode().equals("1")?"e-Money":txnDetails.getSourcePocketCode().equals("2")?"Bank":"LakuPandia";
			
		}
		Subscriber subscriber = subscriberMDN.getSubscriber();
		String nameVal = StringUtils.EMPTY;
		if (subscriber.getKycLevel().getKyclevel() != null && 
				CmFinoFIX.SubscriberKYCLevel_NoKyc.intValue() == (subscriber.getKycLevel().getKyclevel().intValue())) {
			nameVal = subscriber.getNickname();
		}
		else {
			String firstName = subscriber.getFirstname();
			String lastName = subscriber.getLastname();
			nameVal = (firstName != null ? firstName : "") + " " + (lastName != null ? lastName : "");
		}
		

		String currentBalanceVal = "Rp. ";
		currentBalanceVal += MfinoUtil.getNumberFormat().format(pocket.getCurrentbalance());
					
		
		addEmptyValueCellToSubscriberDetailsTable(this.table, name,name_english, nameVal);
		addEmptyValueCellToSubscriberDetailsTable(this.table, beginingBalance,beginingBalance_english, "Rp "+MfinoUtil.getNumberFormat().format(openingBalance));
		addEmptyValueCellToSubscriberDetailsTable(this.table,mdn, mdn_english, txnDetails.getSourceMDN());
		addEmptyValueCellToSubscriberDetailsTable(this.table,currentBalance, currentBalance_english, "Rp "+MfinoUtil.getNumberFormat().format(endingBalance));
		addEmptyValueCellToSubscriberDetailsTable(this.table,accountType, accountType_english, account_Type);
		
	}
	private void addOtherSubscriberDetails(TransactionDetails txnDetails, SubscriberMdn subscriberMDN, Pocket pocket,BigDecimal totalCrediAmount, BigDecimal totalDebitAmount,BigDecimal openingBalance,BigDecimal endingBalance)throws IOException, DocumentException
	{

		PdfPTable emptyTable = new PdfPTable(1);
		emptyTable.setLockedWidth(true);
		emptyTable.setTotalWidth(this.document.getPageSize().getWidth()-PADDING_LENGTH);
		PdfPCell emptyCell=new PdfPCell(new Phrase(" "));
		emptyCell.setBorder(0);
		emptyTable.addCell(emptyCell);
		this.document.add(emptyTable);
		
		this.table = new PdfPTable(4); 
		this.table.setLockedWidth(true);
		this.table.setTotalWidth(this.document.getPageSize().getWidth()-PADDING_LENGTH);
		int[] widths = {1,2,1,1};
     	this.table.setWidths(widths);

		String date,periode,transactionDetails,period_english,date_english;

		date = "Tanggal Cetak";
		date_english="Printed Date";
		periode = "Periode";
		period_english="Period";
		transactionDetails = "Transaction Details" ;

		String totalCredit="Total Kredit",totalCredit_english="Total Credit";
		String totalDetbilt="Total Debet",totalDetbilt_english="Total Debit";
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM ''yy");
		
		String dateVal = dateFormat.format(new Date());
		String periodVal = dateFormat.format(txnDetails.getFromDate()) + " - " + dateFormat.format(txnDetails.getToDate());
		
		if(txnDetails.getServiceName().equals(ServiceAndTransactionConstants.SERVICE_NFC))
		{
			addSubscriberDetailsSpecificToNFCTxnHistory(txnDetails, pocket);	
		}
		else
		{
			addSubscriberDetailsSpecificToEmoneyTxnHistory(txnDetails, subscriberMDN, pocket,openingBalance,endingBalance);	
		}
	
		addEmptyValueCellToSubscriberDetailsTable(this.table, totalCredit,totalCredit_english, "Rp " + MfinoUtil.getNumberFormat().format(totalCrediAmount));
		addEmptyValueCellToSubscriberDetailsTable(this.table,periode,period_english, periodVal);
		addEmptyValueCellToSubscriberDetailsTable(this.table,totalDetbilt, totalDetbilt_english, "Rp " + MfinoUtil.getNumberFormat().format(totalDebitAmount));
		addEmptyValueCellToSubscriberDetailsTable(this.table,date, date_english, dateVal);
		addEmptyCellToSubscriberDetailsTable(this.table, 2, 10.0f);
		addEmptyCellToSubscriberDetailsTable(this.table, 4, 10.0f);
		
		PdfPTable outerTable = new PdfPTable(1);
		outerTable.setLockedWidth(true);
		outerTable.setTotalWidth(this.document.getPageSize().getWidth()-PADDING_LENGTH);
		PdfPCell cell=new PdfPCell(this.table);
		cell.setCellEvent(new SpecialRoundedCell());
		cell.setPadding(5);
        cell.setBorder(0);
		outerTable.addCell(cell);
		this.document.add(outerTable);
		
		 emptyTable = new PdfPTable(1);
		emptyTable.setLockedWidth(true);
		emptyTable.setTotalWidth(this.document.getPageSize().getWidth()-PADDING_LENGTH);
		emptyCell=new PdfPCell(new Phrase(" "));
		emptyCell.setBorder(0);
		emptyTable.addCell(emptyCell);
		this.document.add(emptyTable);
	}
	
	private String getTitle(TransactionDetails txnDetails)
	{
		String title;
		if(txnDetails.getServiceName().equals(ServiceAndTransactionConstants.SERVICE_NFC))
		{
			title = "NFC Card Transactions";
		}
		else
		{
			title = "E-Statement";
		}
		return LanguageTranslator.translate(language, title);
	}
	
	public void addSubscriberDetailsTable(TransactionDetails txnDetails, SubscriberMdn subscriberMDN, Pocket pocket)throws IOException, DocumentException 
	{
		
		addOtherSubscriberDetails(txnDetails, subscriberMDN, pocket,new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0));

	}
	public void addSubscriberDetailsTable(TransactionDetails txnDetails, SubscriberMdn subscriberMDN, Pocket pocket,BigDecimal totalCreditAmount,BigDecimal totalDebitAmount,BigDecimal openingBalance,BigDecimal endingBalance)throws IOException, DocumentException 
	{
		language = (int)subscriberMDN.getSubscriber().getLanguage();
		
		addOtherSubscriberDetails(txnDetails, subscriberMDN, pocket,totalCreditAmount,totalDebitAmount,openingBalance,endingBalance);

	}
	
	public void addCellToSubscriberDetailsTable(PdfPTable subTable, String colName, String colValue){
		PdfPCell nameCell = new PdfPCell(new Phrase(colName,FontFactory.getFont(FontFactory.HELVETICA, 9, Font.NORMAL, new Color(0, 0, 0))));
		nameCell.setPaddingTop(5.0f);
		nameCell.setPaddingBottom(5.0f);
		nameCell.setBorder(0);
		nameCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		nameCell.setPaddingLeft(20.0f);
		subTable.addCell(nameCell);
		
		PdfPCell valueCell = new PdfPCell(new Phrase(": "+colValue,FontFactory.getFont(FontFactory.HELVETICA, 9, Font.NORMAL, new Color(0, 0, 0))));
		valueCell.setPaddingTop(5.0f);
		valueCell.setPaddingBottom(5.0f);
		valueCell.setBorder(0);
		valueCell.setPaddingLeft(20.0f);
		valueCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		
		subTable.addCell(valueCell);
	}
	
	public void addEmptyCellToSubscriberDetailsTable(PdfPTable subTable, int colSpan, float fixedHeight){
		PdfPCell emptyCell = new PdfPCell(new Phrase(""));
		emptyCell.setColspan(colSpan);
		emptyCell.setBorder(0);
		emptyCell.setFixedHeight(fixedHeight);
		subTable.addCell(emptyCell);
	}
	public void addEmptyValueCellToSubscriberDetailsTable(PdfPTable subTable, String colName,String colName1, String colValue){
		Phrase phrase = new Phrase();
		phrase.add(new Chunk(colName, FontFactory.getFont(FontFactory.HELVETICA, 9, Font.NORMAL, new Color(0, 0, 0))));
		phrase.add(new Chunk("\n"+colName1,  FontFactory.getFont(FontFactory.HELVETICA, 9, Font.ITALIC, new Color(0, 0, 0))));
		PdfPCell nameCell = new PdfPCell(phrase);
		nameCell.setPaddingTop(5.0f);
		nameCell.setPaddingBottom(5.0f);
		nameCell.setBorder(0);
		nameCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		nameCell.setPaddingLeft(20.0f);
		subTable.addCell(nameCell);
		
		PdfPCell valueCell = new PdfPCell(new Phrase(": "+colValue,FontFactory.getFont(FontFactory.HELVETICA, 9, Font.NORMAL, new Color(0, 0, 0))));
		valueCell.setPaddingTop(5.0f);
		valueCell.setPaddingBottom(5.0f);
		valueCell.setBorder(0);
		valueCell.setPaddingLeft(20.0f);
		valueCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		
		subTable.addCell(valueCell);
		
	}
	
	public void addHeaderRow(String headerRow,String headerRow_two) throws IOException, DocumentException {
		String[] headerRowArray = headerRow.split("\\|");
		String[] headerRow_twoArray = headerRow_two.split("\\|");
		
		this.numColumns = headerRowArray.length;
		if (this.numColumns != 0) {
			this.transactionTable = new PdfPTable(this.numColumns);
			this.transactionTable.setLockedWidth(true);
			this.transactionTable.setTotalWidth(this.document.getPageSize().getWidth()-PADDING_LENGTH-20);
			this.transactionTable.setHeaderRows(2);
			int[] widths = {1,2,1};
			this.transactionTable.setWidths(widths);
			
		}
		
		for(int i=0; i<headerRowArray.length-1; i++){
			this.cell = new PdfPCell( new Phrase(18, new Chunk(headerRowArray[i], FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, new Color(0, 0, 0)))));
			this.cell.setBorderWidth(0.0f);
			this.cell.setPaddingLeft(20.0f);
			this.cell.setPaddingTop(10.0f);
			this.cell.setPaddingBottom(10.0f);
			this.cell.setVerticalAlignment(Element.ALIGN_CENTER);
			this.cell.setBorderColor(Color.WHITE);
			this.cell.setBorderWidthBottom(2);
			this.transactionTable.addCell(this.cell);
		}
		this.cell = new PdfPCell( new Phrase(18, new Chunk(headerRowArray[headerRowArray.length-1], FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, new Color(0, 0, 0)))));
		this.cell.setVerticalAlignment(Element.ALIGN_CENTER);
		this.cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		this.cell.setBorderWidth(0.0f);
		this.cell.setPaddingTop(10.0f);
		this.cell.setPaddingBottom(10.0f);
		this.cell.setPaddingRight(20.0f);
		this.cell.setBorderColor(Color.WHITE);
		this.cell.setBorderWidthBottom(2);
		this.transactionTable.addCell(this.cell);
		for(int i=0; i<headerRow_twoArray.length-1; i++){
			this.cell = new PdfPCell( new Phrase(18, new Chunk(headerRow_twoArray[i], FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLDITALIC, new Color(0, 0, 0)))));
			this.cell.setBorderWidth(0.0f);
			this.cell.setPaddingLeft(20.0f);
			this.cell.setPaddingTop(-10.0f);
			this.cell.setPaddingBottom(10.0f);
			this.cell.setVerticalAlignment(Element.ALIGN_CENTER);
			this.cell.setBorderColor(Color.WHITE);
			this.cell.setBorderColorBottom(WebColors.getRGBColor("#ff0066"));
			this.cell.setBorderWidthBottom(2);
			this.transactionTable.addCell(this.cell);
		}
		this.cell = new PdfPCell( new Phrase(18, new Chunk(headerRow_twoArray[headerRow_twoArray.length-1], FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLDITALIC, new Color(0, 0, 0)))));
		this.cell.setVerticalAlignment(Element.ALIGN_CENTER);
		this.cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		this.cell.setBorderWidth(0.0f);
		this.cell.setPaddingTop(-10.0f);
		this.cell.setPaddingBottom(10.0f);
		this.cell.setPaddingRight(20.0f);
		this.cell.setBorderColor(Color.WHITE);
		this.cell.setBorderColorBottom(WebColors.getRGBColor("#ff0066"));
		this.cell.setBorderWidthBottom(2);
		this.transactionTable.addCell(this.cell);

	}
	public void addsingleHeaderRow(String headerRow) throws IOException, DocumentException {
		String[] headerRowArray = headerRow.split("\\|");
		
		
		this.numColumns = headerRowArray.length;
		if (this.numColumns != 0) {
			this.transactionTable = new PdfPTable(this.numColumns);
			this.transactionTable.setLockedWidth(true);
			this.transactionTable.setTotalWidth(this.document.getPageSize().getWidth()-PADDING_LENGTH-20);
			this.transactionTable.setHeaderRows(1);
			int[] widths = {1,2,1};
			this.transactionTable.setWidths(widths);
			
		}
		
		for(int i=0; i<headerRowArray.length-1; i++){
			this.cell = new PdfPCell( new Phrase(18, new Chunk(headerRowArray[i], FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, new Color(0, 0, 0)))));
			this.cell.setBorderWidth(0.0f);
			this.cell.setPaddingLeft(20.0f);
			this.cell.setPaddingTop(10.0f);
			this.cell.setPaddingBottom(10.0f);
			this.cell.setVerticalAlignment(Element.ALIGN_CENTER);
			this.cell.setBorderColor(Color.WHITE);
			this.cell.setBorderWidthBottom(2);
			this.transactionTable.addCell(this.cell);
		}
		this.cell = new PdfPCell( new Phrase(18, new Chunk(headerRowArray[headerRowArray.length-1], FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, new Color(0, 0, 0)))));
		this.cell.setVerticalAlignment(Element.ALIGN_CENTER);
		this.cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		this.cell.setBorderWidth(0.0f);
		this.cell.setPaddingTop(10.0f);
		this.cell.setPaddingBottom(10.0f);
		this.cell.setPaddingRight(20.0f);
		this.cell.setBorderColor(Color.WHITE);
		this.cell.setBorderWidthBottom(2);
		this.transactionTable.addCell(this.cell);
		

	}

	
	public void addRowContent(String rowContent,boolean isLastRow) {
		String[] rowcontentArray = rowContent.split("\\|");
		for(int i=0; i<rowcontentArray.length; i++){
			this.cell = new PdfPCell(new Phrase(rowcontentArray[i],FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, new Color(0, 0, 0))));
			if(i == (rowcontentArray.length-1)){
				this.cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				this.cell.setPaddingRight(20.0f);
			}else{
				this.cell.setPaddingLeft(20.0f);
			}
			if(rowCount%2==0){
				this.cell.setBackgroundColor(Color.PINK);	
			}
			this.cell.setVerticalAlignment(Element.ALIGN_CENTER);
			this.cell.setFixedHeight(20.0f);
			this.cell.setBorderWidth(0.0f);
			this.cell.setBorderColor(Color.WHITE);
			if(isLastRow){
				this.cell.setBorderColorBottom(WebColors.getRGBColor("#ff0066"));
				this.cell.setBorderWidthBottom(2);
			}
			this.transactionTable.addCell(this.cell);
			
		}
		rowCount++;
		if(this.numColumns>rowcontentArray.length){
			for (int i=rowcontentArray.length;i<this.numColumns;i++) {
				this.cell = new PdfPCell(new Phrase(" "));
				this.transactionTable.addCell(this.cell);
			}
		}
	}

	public void closePdfReport() {
		
		if(this.rowCount == 0){
			this.cell = new PdfPCell(new Phrase("No Records Found"));
			this.cell.setColspan(this.numColumns);
			this.transactionTable.addCell(this.cell);
		}
		try{
			 
			//this.document.add(this.table);
			//nested table
			PdfPTable outerTable = new PdfPTable(1);
			outerTable.setLockedWidth(true);
			outerTable.setTotalWidth(this.document.getPageSize().getWidth()-PADDING_LENGTH);
			PdfPCell cell=new PdfPCell(this.transactionTable);
			cell.setCellEvent(new SpecialRoundedCell());
			cell.setPadding(10);
	        cell.setBorder(PdfPCell.NO_BORDER);
			outerTable.addCell(cell);
			outerTable.setSplitLate(false);
			this.document.add(outerTable);
			this.document.close();
		}catch(Exception e){
			log.error("PDFReport: Failed to close pdf report",e);
		}

	}
	
	
	public static Date getDate(String dateStr) throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		dateFormat.setLenient(false);
		Date dateOfBirth;
		dateOfBirth = dateFormat.parse(dateStr);

		return dateOfBirth;
	}
	   public PdfPCell getCell(String content) {
	        PdfPCell cell = new PdfPCell(new Phrase(content));
	        cell.setCellEvent(new SpecialRoundedCell());
	        cell.setPadding(5);
	        cell.setBorder(PdfPCell.NO_BORDER);
	        return cell;
	    }
	   class SpecialRoundedCell implements PdfPCellEvent {
		   @Override 
		   public void cellLayout(PdfPCell cell, Rectangle position,
	            PdfContentByte[] canvases) {
	            
	            PdfContentByte cb = canvases[PdfPTable.BACKGROUNDCANVAS];
	            cb.setColorStroke(Color.GRAY);
	            cb.roundRectangle(
	            		position.getLeft() + 1.5f, 
	            		position.getBottom() + 1.5f, 
	            		position.getWidth() - 3,
	            		position.getHeight() - 3, 4
	            );
	            cb.stroke();
	            
	        }
	   }
			
			
	
}
