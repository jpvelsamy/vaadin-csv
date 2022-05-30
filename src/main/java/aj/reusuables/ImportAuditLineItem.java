package aj.reusuables;

import java.util.Date;

import aj.DalUtil;

public class ImportAuditLineItem {

	private final String id;
	private final String businessObject;
	private final ResourceSummary sourceFile;
	private Integer inboundRowCount;
	private Integer errorRowCount;
	private Integer overrideRowCount;
	private Integer correctRowCount;
	private Date importedDate;

	public ImportAuditLineItem(String id, String businessObject, ResourceSummary sourceFile) {
		super();
		if (id != null)
			this.id = id;
		else
			this.id = DalUtil.createLongId();
		this.businessObject = businessObject;
		this.sourceFile = sourceFile;
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

	public ResourceSummary getSourceFile() {
		return sourceFile;
	}

}
