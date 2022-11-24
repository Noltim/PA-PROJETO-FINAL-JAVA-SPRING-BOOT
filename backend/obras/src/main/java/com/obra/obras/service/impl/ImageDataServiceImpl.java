package com.obra.obras.service.impl;

import com.obra.obras.domain.entity.ImageData;
import com.obra.obras.domain.repository.ImageDataRepository;
import com.obra.obras.service.ImageDataService;
import com.obra.obras.util.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageDataServiceImpl implements ImageDataService {

    private final ImageDataRepository imageDataRepository;

    @Override
    @Transactional
    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = imageDataRepository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());

        if (imageData != null) {
            return "Arquivo carregado com sucesso : " + file.getOriginalFilename();
        }
        return null;
    }

    @Override
    @Transactional
    public byte[] downloadImage(String fileName) {
        Optional<ImageData> dbImageData = imageDataRepository.findByName(fileName);
        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }

}

