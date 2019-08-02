package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description:
 * 上传启动项
 *
 * @author: WangJiLin
 * @Date: 2019-07-31 15:17
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LyUploadService {
    public static void main(String[] args) {
        SpringApplication.run(LyUploadService.class, args);
    }
}