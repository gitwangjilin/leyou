package com.leyou.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang3.StringUtils;

/**
 * Description:
 * 上传
 *
 * @author: WangJiLin
 * @Date: 2019-07-31 15:20
 */
@RestController
@RequestMapping("upload")
@Slf4j
public class UploadController {

    @Autowired
    private UploadService uploadService;

   /**
    * @Description: 上传图片功能
    * @params: file
    * @return:
    * @author: WangJiLin
    * @Date: 2019/8/2
    */
    @PostMapping("image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
       log.info("上传图片----------------------"+file);
        String url = this.uploadService.uploadImage(file);
        if (StringUtils.isBlank(url)) {
            // url为空，证明上传失败
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        // 返回200，并且携带url路径
        return ResponseEntity.ok(url);
    }
}