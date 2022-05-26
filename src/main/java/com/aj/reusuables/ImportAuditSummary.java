package com.aj.reusuables;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import com.aj.DalUtil;
import com.aj.DateUtil;

public class ImportAuditSummary {

	private final String id;
	private final String assetType;
	private final Integer batchCount;
	private final Integer rawLeadCount;
	private final Integer goodLeadCount;
	private final Integer badLeadCount;
	private final Integer uglyLeadCount;
	private final Date batchDate;
	private final String junoBusinessId;
	private final String junoAccountId;
	private final String junoBusinessAlias;
	private final String junoAccountAlias;
	private final String userId;

	private final Map<String, ImportAuditLineItem> itemMap = new LinkedHashMap<String, ImportAuditLineItem>();

	public ImportAuditSummary(Integer fileCount, Integer rawLeadCount, Integer goodLeadCount, Integer badLeadCount,
			Integer uglyLeadCount, String assetType, String junoBusinessId, String junoAccountId,
			String junoBusinessAlias, String junoAccountAlias, String userId) {
		super();
		this.batchCount = fileCount;
		this.rawLeadCount = rawLeadCount;
		this.goodLeadCount = goodLeadCount;
		this.badLeadCount = badLeadCount;
		this.uglyLeadCount = uglyLeadCount;
		this.batchDate = DateUtil.getToday();
		this.id = DalUtil.createLongId();
		this.assetType = assetType;
		this.junoAccountId = junoAccountId;
		this.junoBusinessId = junoBusinessId;
		this.junoAccountAlias = junoAccountAlias;
		this.junoBusinessAlias = junoBusinessAlias;
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public String getAssetType() {
		return assetType;
	}

	public Map<String, ImportAuditLineItem> getItemMap() {
		return itemMap;
	}

	public Date getBatchDate() {
		return batchDate;
	}

	public Integer getFileCount() {
		return batchCount;
	}

	public Integer getRawLeadCount() {
		return rawLeadCount;
	}

	public Integer getGoodLeadCount() {
		return goodLeadCount;
	}

	public Integer getBadLeadCount() {
		return badLeadCount;
	}

	public Integer getUglyLeadCount() {
		return uglyLeadCount;
	}

	public void addItem(ImportAuditLineItem fileItemSummary) {
		this.itemMap.put(fileItemSummary.getId(), fileItemSummary);
	}

	public void removeItem(ImportAuditLineItem fileItemSummary) {
		this.itemMap.remove(fileItemSummary.getId());
	}

	public void getItem(String id) {
		this.itemMap.get(id);
	}

	public String getJunoBusinessId() {
		return junoBusinessId;
	}

	public String getJunoAccountId() {
		return junoAccountId;
	}

	public String getJunoBusinessAlias() {
		return junoBusinessAlias;
	}

	public String getJunoAccountAlias() {
		return junoAccountAlias;
	}

	public Integer getBatchCount() {
		return batchCount;
	}

	public String getUserId() {
		return userId;
	}
	
	

}
