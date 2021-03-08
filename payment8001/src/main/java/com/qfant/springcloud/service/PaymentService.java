package com.qfant.springcloud.service;

import com.qfant.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: chenghui
 * @Date: 2021/3/8 17:53
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Integer id);
}
