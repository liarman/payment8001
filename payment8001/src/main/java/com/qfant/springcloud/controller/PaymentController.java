package com.qfant.springcloud.controller;

import cn.hutool.core.util.RuntimeUtil;
import com.qfant.springcloud.entities.CommonResult;
import com.qfant.springcloud.entities.Payment;
import com.qfant.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: chenghui
 * @Date: 2021/3/8 17:57
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果:" + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功，端口：" + serverPort, result);
        } else {
            return new CommonResult(500, "插入失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id) {
        Payment result = paymentService.getPaymentById(id);
        return new CommonResult(200, "查询成功，端口：" + serverPort, result);
    }

    @GetMapping(value = "/payment/discoveryClient")
    public Object discoveryClient() {
        List<String> services = discoveryClient.getServices();
        for (String s : services) {
            System.out.println("*******"+s);
        }
        for (ServiceInstance instance : discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE")) {
            log.info("实例信息："+instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLb() {
        return serverPort;
    }
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){

          try {
              TimeUnit.SECONDS.sleep(3);
          }catch (InterruptedException e){
              e.printStackTrace();
          }
        return serverPort;
    }
}
