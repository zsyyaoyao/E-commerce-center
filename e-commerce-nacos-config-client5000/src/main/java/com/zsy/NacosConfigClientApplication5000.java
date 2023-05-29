package com.zsy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zsy
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClientApplication5000 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientApplication5000.class,args);
    }
}
