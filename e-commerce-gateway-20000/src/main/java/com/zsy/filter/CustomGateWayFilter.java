//package com.zsy.filter;
//
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
///**
// * @author zsy
// */
//@Component
//public class CustomGateWayFilter implements GlobalFilter, Ordered {
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//
//        String user = exchange.getRequest().getQueryParams().getFirst("user");
//        String pwd = exchange.getRequest().getQueryParams().getFirst("pwd");
//        //不满足条件
//        if (!("hspedu".equals(user) && "123456".equals(pwd))){
//            System.out.println("--------非法用户--------");
//            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
//            return exchange.getResponse().setComplete();
//        }
//            return chain.filter(exchange);
//    }
//
//    //表示过滤器执行的顺序,数字越小,优先级越高
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}
