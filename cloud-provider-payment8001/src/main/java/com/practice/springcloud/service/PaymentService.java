package com.practice.springcloud.service;

import com.practice.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;


public interface PaymentService {
    ////增删改查
    public int create(Payment payment);//写操作

    public Payment getPaymentById(@Param("id") Long id);//读操作
}
