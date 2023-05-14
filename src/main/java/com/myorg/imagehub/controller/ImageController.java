package com.myorg.imagehub.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myorg.imagehub.model.DeleteImage;
import com.myorg.imagehub.model.GetImage;
import com.myorg.imagehub.model.ImageList;

import jakarta.validation.Valid;

@RestController
public class ImageController {

	@PostMapping("/upload-images")
	public ResponseEntity<?> uploadImages(@RequestBody @Valid ImageList request){
		
		return new ResponseEntity<>(HttpStatusCode.valueOf(201));
	}
	
	@PostMapping("/get-images")
	public ResponseEntity<?> getImages(@RequestBody @Valid GetImage request){
		
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("/get-all-images")
	public ResponseEntity<?> getAllImages(){
		
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("/delete-images")
	public ResponseEntity<?> deleteImages(@RequestBody @Valid DeleteImage request){
		
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
}
