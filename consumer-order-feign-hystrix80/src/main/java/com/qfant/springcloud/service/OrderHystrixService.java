package com.qfant.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: chenghui
 * @Date: 2021/3/18 15:05
 */
@Component
@FeignClient(value ="CLOUD-PAYMENT-HYSTRIX-SERVICE" ,fallback = OrderHystrixServiceFallback.class)
public interface OrderHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfoOk(@PathVariable("id")Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfoTimeout(@PathVariable("id")Integer id);
}
