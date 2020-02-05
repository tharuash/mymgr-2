package com.b127.mm.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	
	String saveFile(MultipartFile file, String subPath);
	
	void deleteFile(String subPath);
}
