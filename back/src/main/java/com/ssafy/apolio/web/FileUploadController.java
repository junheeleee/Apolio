package com.ssafy.apolio.web;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class FileUploadController {
    @GetMapping(
            value = "/img/{fileName}",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public byte[] getImageWithMediaType(@PathVariable String fileName) throws IOException {
        File file = new File("C:\\Users\\User\\Documents\\UPLOAD_FILES\\"+fileName);
        InputStream in = new FileInputStream(file);
        return IOUtils.toByteArray(in);
    }
}