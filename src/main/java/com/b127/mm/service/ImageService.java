package com.b127.mm.service;

import org.springframework.web.multipart.MultipartFile;

import com.b127.mm.entity.Image;

public interface ImageService {
	
	Image addImage(MultipartFile file, String type);

}
