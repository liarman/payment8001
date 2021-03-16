package com.qfant.springcloud.service;

import com.qfant.springcloud.entities.CommonResult;
import com.qfant.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: chenghui
 * @Date: 2021/3/16 10:48
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
