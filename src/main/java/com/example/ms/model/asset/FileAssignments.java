package com.example.ms.model.asset;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class FileAssignments {
	private Links _links;

	private String key;

	private String fileId;

	public Links get_links() {
		return _links;
	}

	@JsonDeserialize(as = Links.class)
	public void set_links(Links _links) {
		this._links = _links;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	@Override
	public String toString() {
		return "ClassPojo [_links = " + _links + ", key = " + key + ", fileId = " + fileId + "]";
	}
}
