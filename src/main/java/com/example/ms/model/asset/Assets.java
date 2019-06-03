package com.example.ms.model.asset;

import java.util.List;

public class Assets {

	private List<Variables> variables;

	private Links _links;

	private String timezone;

	private List<Aspect> aspects;

	private String externalId;

	private String subTenant;

	private String description;

	private List<Locks> locks;

	private String parentId;

	private String t2Tenant;

	private String twinType;

	private String deleted;

	private String assetId;

	private String tenantId;

	private String name;

	private String etag;

	private String typeId;

	private Location location;

	private List<FileAssignments> fileAssignments;

	public List<Variables> getVariables() {
		return variables;
	}

	//@JsonDeserialize(contentAs = Variables.class)
	public void setVariables(List<Variables> variables) {
		this.variables = variables;
	}

	public Links get_links() {
		return _links;
	}

	//@JsonDeserialize(as = Links.class)
	public void set_links(Links _links) {
		this._links = _links;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public List<Aspect> getAspects() {
		return aspects;
	}

	//@JsonDeserialize(contentAs = Aspect.class)
	public void setAspects(List<Aspect> aspects) {
		this.aspects = aspects;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getSubTenant() {
		return subTenant;
	}

	public void setSubTenant(String subTenant) {
		this.subTenant = subTenant;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Locks> getLocks() {
		return locks;
	}

	//@JsonDeserialize(contentAs = Locks.class)
	public void setLocks(List<Locks> locks) {
		this.locks = locks;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getT2Tenant() {
		return t2Tenant;
	}

	public void setT2Tenant(String t2Tenant) {
		this.t2Tenant = t2Tenant;
	}

	public String getTwinType() {
		return twinType;
	}

	public void setTwinType(String twinType) {
		this.twinType = twinType;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEtag() {
		return etag;
	}

	public void setEtag(String etag) {
		this.etag = etag;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public Location getLocation() {
		return location;
	}

	//@JsonDeserialize(as = Location.class)
	public void setLocation(Location location) {
		this.location = location;
	}

	public List<FileAssignments> getFileAssignments() {
		return fileAssignments;
	}

	//@JsonDeserialize(contentAs = FileAssignments.class)
	public void setFileAssignments(List<FileAssignments> fileAssignments) {
		this.fileAssignments = fileAssignments;
	}

	@Override
	public String toString() {
		return "ClassPojo [variables = " + variables + ", _links = " + _links + ", timezone = " + timezone
				+ ", aspects = " + aspects + ", externalId = " + externalId + ", subTenant = " + subTenant
				+ ", description = " + description + ", locks = " + locks + ", parentId = " + parentId + ", t2Tenant = "
				+ t2Tenant + ", twinType = " + twinType + ", deleted = " + deleted + ", assetId = " + assetId
				+ ", tenantId = " + tenantId + ", name = " + name + ", etag = " + etag + ", typeId = " + typeId
				+ ", location = " + location + ", fileAssignments = " + fileAssignments + "]";
	}
}
