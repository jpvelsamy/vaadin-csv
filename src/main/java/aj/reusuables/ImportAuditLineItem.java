package aj.reusuables;

import java.util.Date;

import aj.DalUtil;

public class ImportAuditLineItem {

	public static final String STATUS_NEW="new";
	public static final String STATUS_PROCESSED="processed";
	public static final String STATUS_FAILED="failed";
	
	private final String id;
	private final String businessObject;	
	private Integer inboundRowCount;
	private Integer errorRowCount;
	private Integer overrideRowCount;
	private Integer correctRowCount;
	private Date importedDate;
	
	
	private String fileName;
	private String fileSize;
	private Boolean initialCheck;
	private Integer columnCount=0;
	private Integer rowCount=0;
	private String status="new";//other
	private String cloudUrl;
	private String mimeType;

	public ImportAuditLineItem(String id, String businessObject) {
		super();
		if (id != null)
			this.id = id;
		else
			this.id = DalUtil.createLongId();
		this.businessObject = businessObject;
		
	}

	public String getId() {
		return this.id;
	}

	public Integer getInboundRowCount() {
		return inboundRowCount;
	}

	public void setInboundRowCount(Integer inboundRowCount) {
		this.inboundRowCount = inboundRowCount;
	}

	public Integer getErrorRowCount() {
		return errorRowCount;
	}

	public void setErrorRowCount(Integer errorRowCount) {
		this.errorRowCount = errorRowCount;
	}

	public Integer getOverrideRowCount() {
		return overrideRowCount;
	}

	public void setOverrideRowCount(Integer overrideRowCount) {
		this.overrideRowCount = overrideRowCount;
	}

	public Integer getCorrectRowCount() {
		return correctRowCount;
	}

	public void setCorrectRowCount(Integer correctRowCount) {
		this.correctRowCount = correctRowCount;
	}

	public Date getImportedDate() {
		return importedDate;
	}

	public void setImportedDate(Date onboardedDate) {
		this.importedDate = onboardedDate;
	}

	public String getBusinessObject() {
		return businessObject;
	}

	
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
