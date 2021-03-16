package com.qfant.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: chenghui
 * @Date: 2021/3/16 10:45
 */
@SpringBootApplication
@EnableFeignClients
public class OrderOpenFeign80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeign80.class,args);
    }
}
