package com.example.ms.model.asset;

public class Location {
	
	private String country;

	private String streetAddress;

	private String postalCode;

	private String latitude;

	private String locality;

	private String region;

	private String longitude;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "ClassPojo [country = " + country + ", streetAddress = " + streetAddress + ", postalCode = " + postalCode
				+ ", latitude = " + latitude + ", locality = " + locality + ", region = " + region + ", longitude = "
				+ longitude + "]";
	}
}
