package com.qfant.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qfant.springcloud.service.OrderHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: chenghui
 * @Date: 2021/3/18 15:08
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallbackHandler")
public class OrderHystrixController {
    @Resource
    private OrderHystrixService orderHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id")Integer id){
        return orderHystrixService.paymentInfoOk(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentFallbackHandler",
//            commandProperties = { @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")})
    @HystrixCommand
    public String paymentInfoTimeout(@PathVariable("id")Integer id){
        System.out.println("-----------------------------"+System.currentTimeMillis());
        String result=orderHystrixService.paymentInfoTimeout(id);
        log.info("feign返回结果："+result);
        System.out.println("-----------------------------"+System.currentTimeMillis());
        return result;
    }

    public String paymentFallbackHandler(@PathVariable("id") Integer id){
        return "我是消费者80端口，对方支付系统现在繁忙请稍后再试试O(∩_∩)O哈哈~";
    }



    public String paymentGlobalFallbackHandler(){
        return "我是全局连接超时配置全局O(∩_∩)O哈哈~";
    }
}
