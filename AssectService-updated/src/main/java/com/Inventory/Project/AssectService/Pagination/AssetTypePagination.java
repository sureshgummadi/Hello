package com.Inventory.Project.AssectService.Pagination;

public class AssetTypePagination {
	private Integer assetId;
	private String assetType;
	private boolean assetStatus;
	private String lastmodefiedDate;
	private String createdBy;
	private String updatedBy;
	private String createdOn;
	private String updatedOn;
	
	public AssetTypePagination() {
		super();
	}

	public Integer getAssetId() {
		return assetId;
	}

	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public boolean isAssetStatus() {
		return assetStatus;
	}

	public void setAssetStatus(boolean assetStatus) {
		this.assetStatus = assetStatus;
	}

	public String getLastmodefiedDate() {
		return lastmodefiedDate;
	}

	public void setLastmodefiedDate(String lastmodefiedDate) {
		this.lastmodefiedDate = lastmodefiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}
}
