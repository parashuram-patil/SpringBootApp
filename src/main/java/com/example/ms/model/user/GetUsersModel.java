package com.example.ms.model.user;

import java.util.List;

public class GetUsersModel {
	
	private String startIndex;
	private String totalResults;
	private String itemsPerPage;
	private List<String> schemas;
	private List<UserModel> resources;

	public String getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(String startIndex) {
		this.startIndex = startIndex;
	}

	public String getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(String totalResults) {
		this.totalResults = totalResults;
	}

	public String getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(String itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	public List<String> getSchemas() {
		return schemas;
	}

	public void setSchemas(List<String> schemas) {
		this.schemas = schemas;
	}

	public List<UserModel> getResources() {
		return resources;
	}

	public void setResources(List<UserModel> resources) {
		this.resources = resources;
	}

	@Override
	public String toString() {
		return "ClassPojo [startIndex = " + startIndex + ", totalResults = " + totalResults + ", itemsPerPage = "
				+ itemsPerPage + ", schemas = " + schemas + ", resources = " + resources + "]";
	}
}
