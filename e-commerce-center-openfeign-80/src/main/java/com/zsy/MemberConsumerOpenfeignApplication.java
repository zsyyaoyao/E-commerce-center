package com.zsy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zsy
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MemberConsumerOpenfeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberConsumerOpenfeignApplication.class, args);
    }
}
