package com.example.ms.model.user;

public class MetaData {
	
	private String created;
	private String lastModified;
	private String version;

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "ClassPojo [created = " + created + ", lastModified = " + lastModified + ", version = " + version + "]";
	}
}
