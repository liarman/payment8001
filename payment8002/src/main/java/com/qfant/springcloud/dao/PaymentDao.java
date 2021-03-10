package com.qfant.springcloud.dao;

import com.qfant.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: chenghui
 * @Date: 2021/3/8 17:26
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Integer id);

    public List<Payment> paymentList();
}
