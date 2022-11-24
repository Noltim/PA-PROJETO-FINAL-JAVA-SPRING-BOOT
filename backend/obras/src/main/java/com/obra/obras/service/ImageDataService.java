package com.obra.obras.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageDataService {
    String uploadImage(@RequestParam MultipartFile file) throws IOException;


    byte[] downloadImage(String fileName);
}
