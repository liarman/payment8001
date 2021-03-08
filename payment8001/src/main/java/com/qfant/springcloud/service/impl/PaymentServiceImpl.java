package com.qfant.springcloud.service.impl;

import com.qfant.springcloud.dao.PaymentDao;
import com.qfant.springcloud.entities.Payment;
import com.qfant.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @Author: chenghui
 * @Date: 2021/3/8 17:54
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return paymentDao.getPaymentById(id);
    }
}
