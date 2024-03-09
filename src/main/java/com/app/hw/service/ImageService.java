package com.app.hw.service;

import com.app.hw.entity.Item;
import com.app.hw.repository.FileDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class ImageService {
    private FileDataRepository fileDataRepository;

    private final String FOLDER_PATH = "C:/Users/user/OneDrive/Desktop/box/";

    @Autowired
    public ImageService(FileDataRepository fileDataRepository) {
        this.fileDataRepository = fileDataRepository;
    }

    public String uploadImageToFileSystem(MultipartFile file) throws IOException {

        String filePath = FOLDER_PATH + file.getOriginalFilename();

        Item fileData = fileDataRepository.save(Item.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .path(filePath).build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "File Upploaded Successfully - " + filePath;
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<Item> fileData = fileDataRepository.findByName(fileName);
        String filePath = fileData.get().getPath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }


}
