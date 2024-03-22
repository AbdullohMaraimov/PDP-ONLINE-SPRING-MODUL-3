package com.app.hw;

import com.app.hw.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class MainController {
    private ImageService imageService;

    @Autowired
    public MainController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/images")
    public ResponseEntity<?> uploadImageToFileSystem(@RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = imageService.uploadImageToFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/images/{fileName}")
    public ResponseEntity<?> downloadImageFromFileSyste(@PathVariable String fileName) throws IOException {
        byte[] imageData = imageService.downloadImageFromFileSystem(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }

}
