package com.b127.mm.service.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.b127.mm.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	private String rootPath = System.getProperty("user.dir") + "/src/main/resources/static/images/";

	private String generateRandomName() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 18) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	@Override
	public String saveFile(MultipartFile file, String subPath) {
		String fileName = generateRandomName() + "." + (file.getContentType().split("/"))[1];
		String completePath = rootPath + subPath;
		Path path = Paths.get(completePath);

		System.out.println(fileName);
		System.out.println(completePath);
		try {
			Files.copy(file.getInputStream(), path.resolve(fileName));

		} catch (Exception exception) {
			System.out.println("error while uploading image catch:: " + exception.getMessage());

		}
		return fileName;

	}

	@Override
	public void deleteFile(String subPath) {
		String completePath = rootPath + subPath;

		Path path = Paths.get(completePath);
		try {
			Files.delete(path);

		} catch (Exception exception) {
			System.out.println("error while uploading image catch:: " + exception.getMessage());
		}

	}

}
