package com.example.ms.model.user;

import java.util.List;

public class UserModel {

	private String origin;
	private String verified;
	private String externalId;
	private List<Group> groups;
	private String active;
	private String userName;
	private List<Email> emails;
	private String lastLogonTime;
	private MetaData meta;
	private String[] approvals;
	private String previousLogonTime;
	private List<String> schemas;
	private Name name;
	private String zoneId;
	private String id;
	private String passwordLastModified;

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public String getLastLogonTime() {
		return lastLogonTime;
	}

	public void setLastLogonTime(String lastLogonTime) {
		this.lastLogonTime = lastLogonTime;
	}

	public MetaData getMeta() {
		return meta;
	}

	public void setMeta(MetaData meta) {
		this.meta = meta;
	}

	public String[] getApprovals() {
		return approvals;
	}

	public void setApprovals(String[] approvals) {
		this.approvals = approvals;
	}

	public String getPreviousLogonTime() {
		return previousLogonTime;
	}

	public void setPreviousLogonTime(String previousLogonTime) {
		this.previousLogonTime = previousLogonTime;
	}

	public List<String> getSchemas() {
		return schemas;
	}

	public void setSchemas(List<String> schemas) {
		this.schemas = schemas;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswordLastModified() {
		return passwordLastModified;
	}

	public void setPasswordLastModified(String passwordLastModified) {
		this.passwordLastModified = passwordLastModified;
	}

	@Override
	public String toString() {
		return "ClassPojo [origin = " + origin + ", verified = " + verified + ", externalId = " + externalId
				+ ", groups = " + groups + ", active = " + active + ", userName = " + userName + ", emails = " + emails
				+ ", lastLogonTime = " + lastLogonTime + ", meta = " + meta + ", approvals = " + approvals
				+ ", previousLogonTime = " + previousLogonTime + ", schemas = " + schemas + ", name = " + name
				+ ", zoneId = " + zoneId + ", id = " + id + ", passwordLastModified = " + passwordLastModified + "]";
	}
}
