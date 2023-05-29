package com.zsy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zsy
 */
@EnableEurekaClient
@SpringBootApplication
public class GateWayApplication20000 {
    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication20000.class,args);
    }
}
