package com.zsy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * Name: com.heima.TestApplication
 * Description:
 *
 * @version 1.0
 * @Author: zsy
 * Date: 2023/3/7 13:37
 */
//@EnableEurekaClient: 将该程序标识为 eureka-client
@EnableEurekaClient
@SpringBootApplication
public class MemberApplication10005 {
    public static void main(String[] args) {
        SpringApplication.run(MemberApplication10005.class, args);
    }
}
