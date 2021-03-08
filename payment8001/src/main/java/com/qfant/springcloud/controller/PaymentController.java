package com.qfant.springcloud.controller;

import com.qfant.springcloud.entities.CommonResult;
import com.qfant.springcloud.entities.Payment;
import com.qfant.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: chenghui
 * @Date: 2021/3/8 17:57
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result= paymentService.create(payment);
        log.info("插入结果"+result);
        if(result>0){
            return new CommonResult(200,"插入成功",result);
        }else {
            return new CommonResult(500,"插入失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Integer id){
        Payment result= paymentService.getPaymentById(id);
        return new CommonResult(200,"查询成功",result);
    }
}
