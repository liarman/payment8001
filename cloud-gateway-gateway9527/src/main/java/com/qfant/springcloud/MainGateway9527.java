package com.qfant.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: chenghui
 * @Date: 2021/3/24 18:34
 */
@SpringBootApplication
@EnableEurekaClient
public class MainGateway9527 {
    public static void main(String[] args) {
        SpringApplication.run(MainGateway9527.class,args);
    }
}
