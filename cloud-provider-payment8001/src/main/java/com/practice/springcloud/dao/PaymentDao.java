package com.practice.springcloud.dao;

import com.practice.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    ////增删改查
    public int create(Payment payment);//写操作

    public Payment getPaymentById(@Param("id") Long id);//读操作
}
