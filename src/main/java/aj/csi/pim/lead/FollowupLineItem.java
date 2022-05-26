package aj.csi.pim.lead;



import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class FollowupLineItem {

	public static final String NEW_STATUS="NEW";
	public static final String EXISTING_STATUS="EXISTING";
	//HOW TO Support this is the million dollar question
	public static final String DIRTIED_NEVERTHLESS="DIRTIED";
	
	private volatile String updateFlag=NEW_STATUS;//OTHER VALUE BEING existing
	
	
	private Date createdDate;
	
	private Date modifiedDate;
	
	private Date followupDate;
	

	private String followupNote;
	
	private TagLineItem tag;

	private String updatedBy;

	private String ownedBy;

	private String followupType;
	
	private Map<String, String> followupMetrics = new HashMap<String, String>();
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getFollowupNote() {
		return followupNote;
	}
	public void setFollowupNote(String followupNote) {
		this.followupNote = followupNote;
	}
	public TagLineItem getTag() {
		return tag;
	}
	public void setTag(TagLineItem tag) {
		this.tag = tag;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getOwnedBy() {
		return ownedBy;
	}
	public void setOwnedBy(String ownedBy) {
		this.ownedBy = ownedBy;
	}
	public String getFollowupType() {
		return followupType;
	}
	public void setFollowupType(String followupType) {
		this.followupType = followupType;
	}
	public Map<String, String> getFollowupMetrics() {
		return followupMetrics;
	}
	public void setFollowupMetrics(Map<String, String> followupMetrics) {
		this.followupMetrics = followupMetrics;
	}
	
	public void addMetrics(String key, String value) {
		this.followupMetrics.put(key, value);
	}
	public Date getFollowupDate() {
		return followupDate;
	}
	public void setFollowupDate(Date followupDate) {
		this.followupDate = followupDate;
	}
	public String getUpdateFlag() {
		return updateFlag;
	}
	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}
	
	
	
}
