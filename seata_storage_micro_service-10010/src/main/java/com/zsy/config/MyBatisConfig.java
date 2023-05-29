package com.zsy.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zsy
 * 常规配置 mybatis 和 dao
 */
@Configuration
@MapperScan({"com.zsy.dao"})
public class MyBatisConfig {
}
