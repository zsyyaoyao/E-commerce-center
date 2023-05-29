//package com.zsy.config;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author zsy
// */
//@Configuration
//public class GateWayRoutesConfig {
//
//    @Bean
//    public RouteLocator myRouteLocator04(RouteLocatorBuilder routeLocatorBuilder) {
//        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//
//        //1. 下面的方法我们分别指定了id , uri 和path
//        //2. Function<PredicateSpec, Route.AsyncBuilder> fn
//        //(1) 是一个函数式接口
//        //(2) 接收的类型是 PredicateSpec ,返回的类型是 Route.AsyncBuilder
//        //(3) r -> r.path("/member/get/**")
//        //                .uri("http://localhost:10000") 就是lambda表达式
//        return routes.route("myRouteLocator04", r -> r.path("/member/get/**")
//                .uri("http://localhost:10000")).build();
//    }
//}
