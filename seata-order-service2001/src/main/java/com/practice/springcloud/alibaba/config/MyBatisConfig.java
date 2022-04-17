package com.practice.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.practice.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
