package com.leyou.config;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Description:
 * 上传实现
 *
 * @author: WangJiLin
 * @Date: 2019-07-31 15:21
 */
@Service
@Slf4j
public class UploadService {
    private static final List<String> ALLOW_TYPES= Arrays.asList("image/jpeg","image/jpg","image/png","image/bmp");

    public String uploadImage(MultipartFile file) {
        try {
            System.out.println("22");
            //校验
            String contentType = file.getContentType();
            System.out.println(ALLOW_TYPES+"contentType");
            System.out.println(contentType+"contentype");
            if(!ALLOW_TYPES.contains(contentType)){
                System.out.println("1");
                throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);
            }
            //文件内容
            BufferedImage image = ImageIO.read(file.getInputStream());
            if(image == null){
                System.out.println("2");
                throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);
            }
            File dest = new File("C:\\\\Users\\\\Chinadaas\\\\Pictures\\\\Camera Roll",file.getOriginalFilename());
            file.transferTo(dest);
            return "http://image.leyou.com/"+file.getOriginalFilename();
        }catch (IOException e){
            log.error("上传失败",e);
            System.out.println("3");
            throw new LyException(ExceptionEnum.UPLOAD_FILE_ERROR);
        }
    }
}
/*
@Service
public class UploadService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UploadController.class);

    // 支持的文件类型
    private static final List<String> suffixes = Arrays.asList("image/png", "image/jpeg");

    public String upload(MultipartFile file) {
        try {
            // 1、图片信息校验
            // 1)校验文件类型
            String type = file.getContentType();
            if (!suffixes.contains(type)) {
                logger.info("上传失败，文件类型不匹配：{}"+ type);
                return null;
            }
            // 2)校验图片内容
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (image == null) {
                logger.info("上传失败，文件内容不符合要求");
                return null;
            }
            // 2、保存图片
            // 2.1、生成保存目录
            File dir = new File("C:\\\\Users\\\\Chinadaas\\\\Pictures\\\\Camera Roll");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            // 2.2、保存图片
            file.transferTo(new File(dir, file.getOriginalFilename()));

            // 2.3、拼接图片地址
            String url = "http://image.leyou.com/upload/" + file.getOriginalFilename();

            return url;
        } catch (Exception e) {
            return null;
        }
    }

}*/
/*
@Service
public class UploadService {

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    // 支持的文件类型
    private static final List<String> suffixes = Arrays.asList("image/png", "image/jpeg");

    @Autowired
    FastFileStorageClient storageClient;

    public String upload(MultipartFile file) {
        try {
            // 1、图片信息校验
            // 1)校验文件类型
            String type = file.getContentType();
            if (!suffixes.contains(type)) {
                logger.info("上传失败，文件类型不匹配：{}", type);
                return null;
            }
            // 2)校验图片内容
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (image == null) {
                logger.info("上传失败，文件内容不符合要求");
                return null;
            }

            // 2、将图片上传到FastDFS
            // 2.1、获取文件后缀名
            String extension = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
            // 2.2、上传
            StorePath storePath = this.storageClient.uploadFile(
                    file.getInputStream(), file.getSize(), extension, null);
            // 2.3、返回完整路径
            return "http://image.leyou.com/" + storePath.getFullPath();
        } catch (Exception e) {
            return null;
        }
    }
}
 */