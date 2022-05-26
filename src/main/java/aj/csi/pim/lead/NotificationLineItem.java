package aj.csi.pim.lead;

import java.util.HashSet;
import java.util.Set;



public class NotificationLineItem {


	private String message;
	
	private java.util.Date sentDate;
	
	
	private Set<String> channelList=new HashSet<String>();

	private String targetNumber;

	private String targetEmail;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public java.util.Date getSentDate() {
		return sentDate;
	}
	public void setSentDate(java.util.Date sentDate) {
		this.sentDate = sentDate;
	}
	public Set<String> getChannelList() {
		return channelList;
	}
	public void setChannelList(Set<String> channelList) {
		this.channelList = channelList;
	}
	public String getTargetNumber() {
		return targetNumber;
	}
	public void setTargetNumber(String targetNumber) {
		this.targetNumber = targetNumber;
	}
	public String getTargetEmail() {
		return targetEmail;
	}
	public void setTargetEmail(String targetEmail) {
		this.targetEmail = targetEmail;
	}
	
	
	
	
}
