package com.qfant.springcloud;

import com.qfant.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author: chenghui
 * @Date: 2021/3/10 9:29
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(value = "CLOUD-PAYMENT-SERVICE",configuration = MyRule.class)
public class ConsumerOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrder80.class,args);
    }
}
