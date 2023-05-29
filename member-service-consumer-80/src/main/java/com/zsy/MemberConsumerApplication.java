package com.zsy;

import com.zsy.config.RibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author zsy
 */
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient //启用服务发现
//指定Ribbon的负载均衡算法
@RibbonClient(name = "MEMBER_SERVICE_PROVIDER_URL", configuration = RibbonRule.class)
public class MemberConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberConsumerApplication.class, args);
    }
}
