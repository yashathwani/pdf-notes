package com.pdfnotesbackend.pdfnotesbackend.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@Component
public class FileUploadHelper {
    public  boolean UploadFile(MultipartFile file) {
        boolean f = false;
        try {
            Files.copy(file.getInputStream(), Paths.get("C:\\Users\\yasha\\Desktop\\pdf-notes-backend\\src\\main\\resources\\static\\images"+ File.separator+ file.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
