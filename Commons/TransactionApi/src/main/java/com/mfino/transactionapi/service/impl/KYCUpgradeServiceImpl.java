/**
 *
 */
package com.mfino.transactionapi.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mfino.constants.GeneralConstants;
import com.mfino.constants.SystemParameterKeys;
import com.mfino.domain.ChannelCode;
import com.mfino.exceptions.InvalidDataException;
import com.mfino.fix.CmFinoFIX;
import com.mfino.result.XMLResult;
import com.mfino.service.ChannelCodeService;
import com.mfino.service.SubscriberService;
import com.mfino.service.SystemParametersService;
import com.mfino.transactionapi.constants.ApiConstants;
import com.mfino.transactionapi.handlers.account.impl.KYCUpgradeHandlerImpl;
import com.mfino.transactionapi.service.KYCUpgradeService;
import com.mfino.transactionapi.vo.TransactionDetails;
import com.mfino.util.DateUtil;

/**
 * @author Bala Sunku
 *
 */
@Service("KYCUpgradeServiceImpl")
public class KYCUpgradeServiceImpl implements KYCUpgradeService {

	private Logger log = LoggerFactory.getLogger(KYCUpgradeServiceImpl.class);
	private String filedSeperator = ",";
	
	@Autowired
	@Qualifier("ChannelCodeServiceImpl")
	private ChannelCodeService channelCodeService;
	
	@Autowired
	@Qualifier("KYCUpgradeHandlerImpl")
	private KYCUpgradeHandlerImpl kycUpgradeHandlerImpl;
	
	@Autowired
	@Qualifier("SubscriberServiceImpl")
	private SubscriberService subscriberService;
	
	@Autowired
	@Qualifier("SystemParametersServiceImpl")
	private SystemParametersService systemParametersService ;	

	/**
	 * Process the Kyc upgrade file at the given path
	 * @param filePath
	 * @return
	 */
	@Override
	public boolean processKYCUpgradeFile(String filePath) {
		log.info("Begin::Processing the KYCUpgrade file at " + filePath);
		
		BufferedReader br = null;
		String outputFilePath = null;
		PrintStream out = null;
		String line = null;
		boolean processStatus = false;
		try {
			br = new BufferedReader(new FileReader(filePath));
			ChannelCode channelCode = channelCodeService.getChannelCodebySourceApplication(CmFinoFIX.SourceApplication_BackEnd);
			outputFilePath = generateFilePath(filePath, "_output");
			out = new PrintStream(new FileOutputStream(outputFilePath));
			
			for (int i=0; (line=br.readLine()) != null; i++) {
				log.info("Processing the record at line: " + i + " data: " + line);
				out.println(processKYCUpgradeRecord(line, channelCode));
			}
			processStatus = true;

		} catch (FileNotFoundException e) {
			log.error("Error: File not found exception while processing the file at: " + filePath, e);
		} catch (IOException e) {
			log.error("Error: IOException while processing the file at: " + filePath, e);
		} catch (Exception e) {
			log.error("Error: Exception while processing the file at: " + filePath, e);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (Exception e) {
				log.error("Error while closing the file descriptors.", e);
			}
			
		}
		log.info("End::Processing the KYCUpgrade file at: " + filePath);
		return processStatus; 
	}
	
	/**
	 * Process the KYCUpgrade request
	 * @param line
	 * @param channelCode
	 * @return
	 */
	private String processKYCUpgradeRecord(String line, ChannelCode channelCode) {
		String lineData[] = null;
		TransactionDetails transactionDetails = null;
		StringBuffer sb = null;

		try {
			lineData = line.split(filedSeperator);
			if (lineData.length < 11) {
				throw new InvalidDataException("Invalid Complete Record");
			}
			String sourceMDN = lineData[0];
			String firstName = lineData[1];
			String lastName = lineData[2];
			String dob = lineData[3];
			String addressLine1 = lineData[4];
			String city = lineData[5];
			String state = lineData[6];
			String zipCode = lineData[7];
			String idType = lineData[8];
			String idNumber = lineData[9];
			String kycType = lineData[10];
			if (StringUtils.isBlank(sourceMDN) || StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName) ||
					StringUtils.isBlank(dob) || StringUtils.isBlank(addressLine1) || StringUtils.isBlank(city) || 
					StringUtils.isBlank(zipCode) || StringUtils.isBlank(idType) || StringUtils.isBlank(idNumber) || 
					StringUtils.isBlank(kycType) || StringUtils.isBlank(state)) {
				throw new InvalidDataException("Invalid Data: Some of the fields are empty");
			}
			transactionDetails = new TransactionDetails();
			transactionDetails.setSourceMDN(subscriberService.normalizeMDN(sourceMDN));
			transactionDetails.setFirstName(firstName);
			transactionDetails.setLastName(lastName);
			transactionDetails.setDateOfBirth(getDate(dob));
			transactionDetails.setAddressLine1(addressLine1);
			transactionDetails.setCity(city);
			transactionDetails.setState(state);
			transactionDetails.setZipCode(zipCode);
			transactionDetails.setIdType(idType);
			transactionDetails.setIdNumber(idNumber);
			transactionDetails.setKycType(kycType);
			transactionDetails.setCc(channelCode);
			
			XMLResult result = (XMLResult)kycUpgradeHandlerImpl.handle(transactionDetails);
			sb = new StringBuffer(line);
			if (result != null) {
				sb.append(filedSeperator);
				sb.append(result.getSctlID()!=null ? result.getSctlID() : "");
				sb.append(filedSeperator);
				sb.append(result.getNotificationCode());
				sb.append(filedSeperator);
				if (GeneralConstants.RESPONSE_CODE_SUCCESS.equals(result.getResponseStatus())) {
					sb.append("Success");
				} 
				else {
					sb.append("Fail");
				}
			} 
			else {
				sb.append(",,,Fail");
			}
		} catch (InvalidDataException e) {
			log.error("Error: Invalid data while parsing the record: " + line);
			return line + ",,2000,Fail";
		} catch (Exception e) {
			log.error("Error: Exception while parsing the record: " + line);
			return line + ",,2000,Fail";
		}
		return sb.toString();
	}
	
	/**
	 * generates the new file path by appending the for the given file path
	 * @param filePath
	 * @param extraString
	 * @return
	 */
	public String generateFilePath(String filePath, String extraString) {
		int indexOfExt = filePath.lastIndexOf('.');
		if (indexOfExt > 0) {
			filePath = filePath.substring(0, indexOfExt) + extraString + filePath.substring(indexOfExt);
		} else {
			filePath = filePath + extraString + ".csv";
		}
		return filePath;
	}
	
	/**
	 * Converts the given date string object into Date object
	 * @param dateStr
	 * @return
	 * @throws InvalidDataException
	 */
	private Date getDate(String dateStr) throws InvalidDataException {
		Date dateOfBirth;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
			dateFormat.setLenient(false);
			dateOfBirth = dateFormat.parse(dateStr);
			int minAge = systemParametersService.getInteger(SystemParameterKeys.MIN_REGISTRATION_AGE);
			Date minAgeDate = DateUtil.addYears(new Date(), -(minAge));
			if(minAgeDate.before(dateOfBirth)){
				throw new InvalidDataException("Invalid Date of birth. Minimum age is: "+ minAge);
			}
			Date maxAgeDate = DateUtil.addYears(new Date(), -100);
			if(maxAgeDate.after(dateOfBirth)) {
				throw new InvalidDataException("Invalid Date of birth. Maximum age is: "+ minAge);
			}
		} catch (ParseException e) {
			log.error("Error: Exception in Registration, Invalid Date:" + dateStr, e);
			throw new InvalidDataException("Invalid Date format: " + dateStr);
		}		
		return dateOfBirth;
	}
}
