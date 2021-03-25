package com.qfant.springcloud.controller;

import com.qfant.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: chenghui
 * @Date: 2021/3/17 16:31
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id")Integer id){
        String result= paymentService.paymentInfoOk(id);
        log.info("result"+result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id")Integer id){
        System.out.println("-----------------------------"+System.currentTimeMillis());
        String result= paymentService.paymentInfoTimeout(id);
        System.out.println("-----------------------------"+System.currentTimeMillis());
        log.info("result"+result);
        return result;
    }
}
