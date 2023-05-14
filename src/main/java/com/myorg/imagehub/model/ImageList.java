package com.myorg.imagehub.model;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ImageList {
	
	@NotNull
	@Size(min = 1)
	private List<Image> imageList;

	public List<Image> getImageList() {
		return imageList;
	}

	public void setImageList(List<Image> imageList) {
		this.imageList = imageList;
	}

}
