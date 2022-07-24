package com.example.aabbcc.services;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {
    String uploadFile (Long id, MultipartFile multipartFile);
}
