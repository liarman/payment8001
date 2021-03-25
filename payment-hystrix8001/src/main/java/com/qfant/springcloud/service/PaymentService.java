package com.qfant.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: chenghui
 * @Date: 2021/3/17 16:28
 */
@Service
public class PaymentService {
    public String paymentInfoOk(Integer id) {
        return "支付ok。访问成功" + Thread.currentThread().getName() + id;
    }

//    @HystrixCommand(fallbackMethod = "paymentFallback", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")})
    public String paymentInfoTimeout(Integer id) {
        try {
//            int age=10/0;
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "支付超时。访问成功" + Thread.currentThread().getName() + id;
    }

    /**
     * fallbackMethod 的方法必须和原方法参数一致
     *
     * @param id
     * @return
     */
    public String paymentFallback(Integer id) {
        return "支付失败请稍后再试 8001系统繁忙" + id;
    }
}
