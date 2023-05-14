package com.myorg.imagehub.model;

import jakarta.validation.constraints.NotEmpty;

public class Image {

	
	private int imageId;
	
	@NotEmpty(message = "name is required")
	private String name;
	
	@NotEmpty(message = "name is required")
	private String base64Image;
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBase64Image() {
		return base64Image;
	}
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	
	
}
