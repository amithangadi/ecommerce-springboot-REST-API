package com.ecommerce.ecommerceproject.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

	String uploadImage(MultipartFile file);
}
