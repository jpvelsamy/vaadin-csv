package aj.csi.pim.lead;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import aj.DateUtil;




public class OrganizationInfo {


	private String id;

	private String orgName;

	private String orgSize;

	private String orgLocation;

	private String orgAddress;

	private String latLong;

	private String mapPinLocation;

	private String orgType;

	private String createdDate=DateUtil.formatDateTimeWithSeconds(DateUtil.getNowDate());

	
	private Date orgCreatedDate;
	
	
	private Map<String, SiteInfo> digitalProfileMap = new HashMap<String, SiteInfo>(); 
	
	public OrganizationInfo() {
		UUID uid = UUID.randomUUID();
		this.id=uid.toString();
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgSize() {
		return orgSize;
	}
	public void setOrgSize(String orgSize) {
		this.orgSize = orgSize;
	}
	public String getOrgLocation() {
		return orgLocation;
	}
	public void setOrgLocation(String orgLocation) {
		this.orgLocation = orgLocation;
	}
	public String getOrgAddress() {
		return orgAddress;
	}
	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}
	public String getLatLong() {
		return latLong;
	}
	public void setLatLong(String longitude) {
		this.latLong = longitude;
	}
	public String getMapPinLocation() {
		return mapPinLocation;
	}
	public void setMapPinLocation(String latitude) {
		this.mapPinLocation = latitude;
	}
	public String getOrgType() {
		return orgType;
	}
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public Date getOrgCreatedDate() {
		return orgCreatedDate;
	}
	public void setOrgCreatedDate(Date orgCreatedDate) {
		this.orgCreatedDate = orgCreatedDate;
	}
	
	public Map<String, SiteInfo> getDigitalProfileMap() {
		return digitalProfileMap;
	}
	public void setDigitalProfileMap(Map<String, SiteInfo> digitalProfileMap) {
		this.digitalProfileMap = digitalProfileMap;
	}
	public void addProfile(String siteName, SiteInfo profile) {
		if(siteName!=null && profile!=null)
		this.digitalProfileMap.put(siteName, profile);
	}
	
}
