package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * BulkBankAccount generated by hbm2java
 */
@Entity
@Table(name = "BULK_BANK_ACCOUNT")
public class BulkBankAccount extends Base implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FieldName_UploadFileStatus = "uploadfilestatus";
	
	private String filename;
	private String filedata;
	private Long totallinecount;
	private Long errorlinecount;
	private long uploadfilestatus;
	private String uploadreport;
	private Long id;

	public BulkBankAccount() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "bulk_bank_account_ID_SEQ")
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "FILENAME", nullable = false, length = 1020)
	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Column(name = "FILEDATA", nullable = false)
	public String getFiledata() {
		return this.filedata;
	}

	public void setFiledata(String filedata) {
		this.filedata = filedata;
	}

	@Column(name = "TOTALLINECOUNT", precision = 10, scale = 0)
	public Long getTotallinecount() {
		return this.totallinecount;
	}

	public void setTotallinecount(Long totallinecount) {
		this.totallinecount = totallinecount;
	}

	@Column(name = "ERRORLINECOUNT", precision = 10, scale = 0)
	public Long getErrorlinecount() {
		return this.errorlinecount;
	}

	public void setErrorlinecount(Long errorlinecount) {
		this.errorlinecount = errorlinecount;
	}

	@Column(name = "UPLOADFILESTATUS", nullable = false, precision = 10, scale = 0)
	public long getUploadfilestatus() {
		return this.uploadfilestatus;
	}

	public void setUploadfilestatus(long uploadfilestatus) {
		this.uploadfilestatus = uploadfilestatus;
	}

	@Column(name = "UPLOADREPORT")
	public String getUploadreport() {
		return this.uploadreport;
	}

	public void setUploadreport(String uploadreport) {
		this.uploadreport = uploadreport;
	}

}
