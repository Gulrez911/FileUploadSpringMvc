package com.gul.entity;

public class PropertiesConfig {

	String fileLocation;
	String fileUrl;

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	@Override
	public String toString() {
		return "PropertiesConfig [fileLocation=" + fileLocation + ", fileUrl=" + fileUrl + "]";
	}
}
