package com.ecommerce.ecommerceproject.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.ecommerceproject.service.FileUploadService;

@RestController
@RequestMapping("/api/uploads")
public class UploadController {

	private final FileUploadService service;
	
	
	public UploadController(FileUploadService service) {
		this.service = service;
	}
	
	
	@PostMapping(
			consumes = "multipart/form-data"
			)
	
	public String uploadImage(
			@RequestParam("file") MultipartFile file) {
		return service.uploadImage(file);
	}
}
