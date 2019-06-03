package com.example.ms.model.asset;

public class Locks {
	private String reason;

	private Links _links;

	private String service;

	private String reasonCode;

	private String id;

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Links get_links() {
		return _links;
	}

	//@JsonDeserialize(as = Links.class)
	public void set_links(Links _links) {
		this._links = _links;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ClassPojo [reason = " + reason + ", _links = " + _links + ", service = " + service + ", reasonCode = "
				+ reasonCode + ", id = " + id + "]";
	}
}
