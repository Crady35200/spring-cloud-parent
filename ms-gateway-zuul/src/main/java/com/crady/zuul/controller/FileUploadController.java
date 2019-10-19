package com.crady.zuul.controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author :Crady
 * date :2019/10/19 15:16
 * desc :
 **/
@RestController
@RequestMapping("file")
public class FileUploadController {

    @PostMapping("upload")
    public String upload(@RequestParam(value = "file",required = true)MultipartFile file){
        try {
            File f = new File(file.getOriginalFilename());
            FileCopyUtils.copy(file.getBytes(),f);
            return f.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
