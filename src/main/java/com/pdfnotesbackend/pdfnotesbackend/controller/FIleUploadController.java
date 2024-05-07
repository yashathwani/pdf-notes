package com.pdfnotesbackend.pdfnotesbackend.controller;

import com.pdfnotesbackend.pdfnotesbackend.helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FIleUploadController {
    @Autowired
    private FileUploadHelper fileUploadHelper;
    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file)
    {

       if(file.isEmpty())
       {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please select a file to upload");
       }
//       if(!file.getOriginalFilename().endsWith(".pdf")) {
//           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please upload a pdf file");
//       }
       // file upload code
        try {
           boolean f= fileUploadHelper.UploadFile(file);
              if(f){
                return ResponseEntity.ok("File uploaded successfully");
              }

        }
        catch(Exception e){
            e.printStackTrace();

    }

          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong! Try again");
    }
}
