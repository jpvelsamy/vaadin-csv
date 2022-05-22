package com.aj.view;

import java.io.Serializable;

/**
 *  S.No, File Name, File size, Initial check, Action
 */
public class FileSummary implements Serializable 
{

	private static final long serialVersionUID = 6307344374667183708L;
	public static final String STATUS_NEW="new";
	public static final String STATUS_PROCESSED="processed";
	public static final String STATUS_FAILED="failed";
	
	private String fileName;
	private String fileSize;
	private Boolean initialCheck;
	private Integer columnCount;
	private Integer rowCount;
	private String status="new";//other 
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public Boolean getInitialCheck() {
		return initialCheck;
	}
	public void setInitialCheck(Boolean initialCheck) {
		this.initialCheck = initialCheck;
	}
	public int getColumnCount() {
		return columnCount;
	}
	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	
	public String getHealthStatus()
	{
		if(initialCheck)
			return "Healthy";
		else
			return "Noisy";
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
