package com.zsy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zsy
 */
@SpringBootApplication
//引入的是nacos发现注解
@EnableDiscoveryClient
public class MemberNacosProviderApplication10004 {
    public static void main(String[] args) {
        SpringApplication.run(MemberNacosProviderApplication10004.class, args);
    }
}
