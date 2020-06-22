package com.leyou.upload.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class UploadService {

    private static final List<String> CONTENT_TYPE = Arrays.asList("image/gif", "image/jpeg");

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadService.class);

    public String uploadImage(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        try {
            // 校验文件类型
            String contentType = file.getContentType();
            if (!CONTENT_TYPE.contains(contentType)) {
                LOGGER.warn("文件类型不合法: {}", originalFilename);
                return null;
            }

            // 校验文件内容
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            if (bufferedImage == null) {
                LOGGER.warn("文件内容不合法 {}", originalFilename);
                return null;
            }
            // 保存到服务器
            file.transferTo(new File("/home/fyk/image/" + originalFilename));

            // 返回url,进行回写
            return "http://image.leyou.com/" + originalFilename;
        }catch (IOException e) {
            LOGGER.error("服务器内部错误 {}", originalFilename);
            e.printStackTrace();
        }
        return null;
    }
}
