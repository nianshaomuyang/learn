package com.tangyi.learn.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class UploadCon {
    @ResponseBody
    @CrossOrigin
    @RequestMapping("/uploadPics")
    public String uploadPics(HttpServletRequest request,
                           @RequestParam("file") MultipartFile[] file) {
        if (file != null && file.length > 0) {
            for (MultipartFile temp : file) {
                //将文件先保存下来
                try{
                    String filename=temp.getOriginalFilename();
                    temp.transferTo(new File("D:\\FILM\\"+ temp.getOriginalFilename()));
                    System.out.println(filename);
                    //fileUrl = fileUrl + request.getContextPath() + "/img/" + fileName;
                    //http://localhost:9000/FILM/downloadfile.jpeg


                    String result="D:\\FILM\\"+filename;
                    return result;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }
}
