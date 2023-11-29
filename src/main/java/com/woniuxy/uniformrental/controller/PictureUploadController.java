package com.woniuxy.uniformrental.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/picture")
public class PictureUploadController {

    //上传到指定的服务器地址
    @Value("${upload.path}")
    private String uploadPath;

    /**
     * 上传文件: 需要生成一个新的文件名
     * @return 返回上传后生成的新的文件名
     */
    @PostMapping("/upload")
    public ResponseEntity<String> upload(MultipartFile picture) throws
            IOException {
        //1.获取原来的名字
        String originalFilename = picture.getOriginalFilename();
        //2.将文件名改名
        //2.1 得到原来的文件名后缀，如：.jpg
        String suffix =
                originalFilename.substring(originalFilename.lastIndexOf("."));
        //2.2 生成主文件名：9a3374db-8cc8-11ee-b40d-9c2dcd7a053a
        String main = UUID.randomUUID().toString();
        //2.3 将主文件名+后缀名=得到新的文件名
        String newPictureName = main + suffix;
        //3.上传文件
        String picturePath = uploadPath + newPictureName;
        picture.transferTo(new File(picturePath));
        //4.返回新的文件名
        return ResponseEntity.ok(newPictureName);
    }

}
