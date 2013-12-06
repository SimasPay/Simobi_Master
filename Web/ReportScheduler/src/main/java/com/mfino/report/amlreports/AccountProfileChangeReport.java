package com.mfino.report.amlreports;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mfino.dao.DAOFactory;
import com.mfino.dao.SubscriberDAO;
import com.mfino.domain.Subscriber;
import com.mfino.domain.SubscriberMDN;
import com.mfino.report.base.ReportBaseData;
import com.mfino.report.base.OfflineReportBase;
import com.mfino.report.xlsreport.XLSReport;
import com.mfino.util.ReportUtil;

public class AccountProfileChangeReport extends OfflineReportBase {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	private static final int NUM_COLUMNS = 8;
	private String HEADER_ROW = "# , Date, SubscriberMdn , LastName, FirstName, CurrentAccounttype, LastTransactionTime , LasttransactionId";
	private File report;
	private String reportName;
	
	
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	protected File run(Date start, Date end, ReportBaseData data) {
		report =ReportUtil.getReportFilePath(reportName,end,ReportUtil.EXCEL_EXTENTION);
		String formatStr = getFormatString(NUM_COLUMNS); 
		DateFormat df = getDateFormat();
		String startTime = df.format(new Date());
		log.info("Processing "+reportName+" startTime:"+startTime);
		try{
			XLSReport xlsReport = new XLSReport(reportName, end);
			//adding logo
			try{
				xlsReport.addLogo();
			}catch (Exception e) {
				log.error("Failed to load logo",e);
			}
		xlsReport.addMergedRegion();
			
		xlsReport.addReportTitle("AccountProfileChangeReport");
		xlsReport.addHeaderRow(HEADER_ROW);

		SubscriberDAO subDao = DAOFactory.getInstance().getSubscriberDAO();
		List<Subscriber> subscribers = subDao.getProfileChangedSubscribers(start,end); 
		int seq = 1;
		for(Subscriber sub:subscribers){

			SubscriberMDN mdn = sub.getSubscriberMDNFromSubscriberID().iterator().next();
			String rowContent = String.format(formatStr, seq,df.format(sub.getApproveOrRejectTime()),
				                                mdn.getMDN(), sub.getLastName(), sub.getFirstName(),
				                                sub.getKYCLevelByKYCLevel().getKYCLevelName(), mdn.getLastTransactionTime()!=null?df.format(mdn.getLastTransactionTime()):df.format(mdn.getCreateTime()),
				                                mdn.getLastTransactionID()!=null?mdn.getLastTransactionID():"");
			xlsReport.addRowContent(rowContent);  
			seq++;
				     	
		}
		
		xlsReport.writeToFileStream(report, HEADER_ROW, reportName);
		
		}catch (Exception e) {
			log.error("Error in "+reportName+"::",e);
		}
		log.info("Processing "+reportName+" startTime:"+startTime+" EndTime:"+df.format(new Date()));
		return report;		
	}
	
	

	@Override
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	protected List<File> runAndGetMutlipleReports(Date start, Date end,
			ReportBaseData data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setReportName(String reportName) {
		this.reportName =reportName;
	}


	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return report.getName();
	}
	
}
