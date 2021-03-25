package com.qfant.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author: chenghui
 * @Date: 2021/3/18 18:14
 */
@Component
public class OrderHystrixServiceFallback implements OrderHystrixService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "----PaymentFallbackService fall back-paymentInfo_OK,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "----PaymentFallbackService fall back-paymentInfo_TimeOut,o(╥﹏╥)o";
    }
}
