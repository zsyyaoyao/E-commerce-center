//package com.zsy.config;
//
//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author zsy
// * 配置自己的负载均衡算法
// */
//@Configuration
//public class RibbonRule {
//
//    //配置注入自己的负载均衡算法
//    @Bean
//    public IRule myRibbonRule(){
//        return new RandomRule();
//    }
//}
