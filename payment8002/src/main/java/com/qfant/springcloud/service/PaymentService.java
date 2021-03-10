package com.qfant.springcloud.service;

import com.qfant.springcloud.entities.Payment;

/**
 * @Author: chenghui
 * @Date: 2021/3/8 17:53
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Integer id);
}
