package aj.csi.pim.lead;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;



import com.aj.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Lead implements Serializable {

	private static final long serialVersionUID = -3294798255539377142L;

	
	private String id;
	
	
	
	private String firstName;
	
	
	
	private String lastName;
	
	
	
	private String phoneNumber;
	
	
	
	private String emailId;
	
	
	private String address="NA";
	
	
	
	private String alternateNumber="NA";
	

	
	private String sourceCampaignId="NA";
	
	
	private String ipAddress="NA";
	
	
	
	private String userFedLocation="NA";

	
	private String ipLocation="NA";
	
	
	
	private Boolean isSmsVerified=false;
	
	
	private String verificationCode="NA";
	
	
	private String sourceFormId="NA";
	
	
	private String sourceAccountId="NA";
	
	
	private String campaignName="NA";
	
	
	private String salesCopyName="NA";
	
	
	
	private Integer sessionTime=0;
	
	
	
	private Date dueDate=DateUtil.getNowDate();
	
	
	
	private Date createdDate=DateUtil.getNowDate();
	
	
	
	
	private Date modifiedDate=DateUtil.getNowDate();
	
	
	
	private String junoBusinessAlias;
	
	
	
	private String junoBusinessId;
	
	
	
	private String junoAccountId;
	
	
	
	private String junoAccountAlias;
	
	
	
	private String ownerUserId;
	
	
	private String tenantId;
	
	
	
	private String campaignType;
	
	
	
	private String platformType;
	
	
	
	private OrganizationInfo orgInfo=new OrganizationInfo();
	
	private DeviceInfo deviceInfo=new DeviceInfo();
	
	private Map<String, LeadAsset> assetMap = new HashMap<String, LeadAsset>();
	
	private List<TagLineItem> tagCloud = new ArrayList<TagLineItem>();
	
	private Map<String, FollowupLineItem> followupMap = new HashMap<String, FollowupLineItem>();
	
	
	private Map<String, Question> lapQuestionMap = new LinkedHashMap<String, Question>();
	
	
	private List<NotificationLineItem> notificationList = new ArrayList<NotificationLineItem>();
	
	
	private String smsVerificationText="NA";
	
	
	private Boolean isTestLead=false;
	
	
	private String userPic="NA";

	
	private String userSub="NA";
	
	
	
	private String subscriptionStatus="NA";
	
	
	private CatalogueItem pricingDetail;
	
	
	private String password;
	
	
	private CountryMaster countryMaster = CountryMaster.defaultCountryCode();
	
	
	private String ownerId;

	
	private String authorityId;

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}

	public Lead() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAlternateNumber() {
		return alternateNumber;
	}

	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
	}

	

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

	public String getSourceCampaignId() {
		return sourceCampaignId;
	}

	public void setSourceCampaignId(String sourceCampaignId) {
		this.sourceCampaignId = sourceCampaignId;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getUserFedLocation() {
		return userFedLocation;
	}

	public void setUserFedLocation(String userFedLocation) {
		this.userFedLocation = userFedLocation;
	}

	public String getIpLocation() {
		return ipLocation;
	}

	public void setIpLocation(String ipLocation) {
		this.ipLocation = ipLocation;
	}

	public Boolean getIsSmsVerified() {
		return isSmsVerified;
	}

	public void setIsSmsVerified(Boolean isSmsVerified) {
		this.isSmsVerified = isSmsVerified;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public Map<String, LeadAsset> getAssetMap() {
		return assetMap;
	}

	public void setAssetMap(Map<String, LeadAsset> assetMap) {
		this.assetMap = assetMap;
	}

	public List<TagLineItem> getTagCloud() {
		return tagCloud;
	}

	public void setTagCloud(List<TagLineItem> tagCloud) {
		this.tagCloud = tagCloud;
	}

	public Map<String, FollowupLineItem> getFollowupMap() {
		return followupMap;
	}

	public void setFollowupMap(Map<String, FollowupLineItem> followupMap) {
		this.followupMap = followupMap;
	}

	public String getSourceFormId() {
		return sourceFormId;
	}

	public void setSourceFormId(String sourceFormId) {
		this.sourceFormId = sourceFormId;
	}

	public String getSourceAccountId() {
		return sourceAccountId;
	}

	public void setSourceAccountId(String sourceAccountId) {
		this.sourceAccountId = sourceAccountId;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public String getSalesCopyName() {
		return salesCopyName;
	}

	public void setSalesCopyName(String salesCopyName) {
		this.salesCopyName = salesCopyName;
	}

	public Integer getSessionTime() {
		return sessionTime;
	}

	public void setSessionTime(Integer sessionTime) {
		this.sessionTime = sessionTime;
	}

	public OrganizationInfo getOrgInfo() {
		return orgInfo;
	}

	public void setOrgInfo(OrganizationInfo orgInfo) {
		this.orgInfo = orgInfo;
	}

	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getSmsVerificationText() {
		return smsVerificationText;
	}

	public void setSmsVerificationText(String smsVerificationText) {
		this.smsVerificationText = smsVerificationText;
	}

	public Boolean getIsTestLead() {
		return isTestLead;
	}

	public void setIsTestLead(Boolean isTestLead) {
		this.isTestLead = isTestLead;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	public String getUserSub() {
		return userSub;
	}

	public void setUserSub(String userSub) {
		this.userSub = userSub;
	}

	

	

	public Map<String, Question> getLapQuestionMap() {
		return lapQuestionMap;
	}

	public void setLapQuestionMap(Map<String, Question> lapQuestionMap) {
		this.lapQuestionMap = lapQuestionMap;
	}

	public void addQuestionAnswer( String questionId, Question questionAndAnswer) {
		this.lapQuestionMap.put(questionId, questionAndAnswer);
	}

	public List<NotificationLineItem> getNotificationList() {
		return notificationList;
	}

	public void setNotificationList(List<NotificationLineItem> notificationList) {
		this.notificationList = notificationList;
	}

	public void addNotification(String message, Set<String> channels) {
		NotificationLineItem n = new NotificationLineItem();
		n.setTargetEmail(this.emailId);
		n.setTargetNumber(this.phoneNumber);
		n.setMessage(message);
		n.setChannelList(channels);
		n.setSentDate(DateUtil.getNowDate());
		this.notificationList.add(n);
	}

	public void addFollowupLineItem(String id, FollowupLineItem fli)
	{
		if(fli!=null && id!=null)
			this.followupMap.put(id, fli);
	}
	
	public String getJunoBusinessAlias()
	{
		return junoBusinessAlias;
	}

	public void setJunoBusinessAlias(String businessAlias)
	{
		this.junoBusinessAlias = businessAlias;
	}

	public String getJunoBusinessId()
	{
		return junoBusinessId;
	}

	public void setJunoBusinessId(String businessId)
	{
		if(businessId!=null) {
			this.junoBusinessId = businessId;
		}
		
	}

	public String getJunoAccountId()
	{
		return junoAccountId;
	}

	public void setJunoAccountId(String junoAccountId)
	{
		if(junoAccountId!=null) {
			this.junoAccountId = junoAccountId;			
		}
	}

	public String getJunoAccountAlias()
	{
		return junoAccountAlias;
	}

	public void setJunoAccountAlias(String junoAccountAlias)
	{
		this.junoAccountAlias = junoAccountAlias;
	}

	public String getOwnerUserId()
	{
		return ownerUserId;
	}

	public void setOwnerUserId(String ownerUserId)
	{
		this.ownerUserId = ownerUserId;
	}

	public String getTenantId()
	{
		return tenantId;
	}

	public void setTenantId(String tenantId)
	{
		this.tenantId = tenantId;
	}

	public String getSubscriptionStatus() {
		return subscriptionStatus;
	}

	public void setSubscriptionStatus(String subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}

	public CatalogueItem getPricingDetail() {
		return pricingDetail;
	}

	public void setPricingDetail(CatalogueItem pricingDetail) {
		this.pricingDetail = pricingDetail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CountryMaster getCountryMaster()
	{
		return countryMaster;
	}

	public void setCountryMaster(CountryMaster countryMaster)
	{
		this.countryMaster = countryMaster;
	}

	public String getCampaignType()
	{
		return campaignType;
	}

	public void setCampaignType(String campaignType)
	{
		this.campaignType = campaignType;
	}

	public String getPlatformType()
	{
		return platformType;
	}

	public void setPlatformType(String platformType)
	{
		this.platformType = platformType;
	}
	
	
	
	
}
