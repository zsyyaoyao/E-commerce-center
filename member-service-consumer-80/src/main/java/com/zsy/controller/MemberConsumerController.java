package com.zsy.controller;

import com.zsy.entity.Member;
import com.zsy.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zsy
 */
@Slf4j
@RestController
public class MemberConsumerController {

    //设定基础url地址
    /**
     * 老师说明:
     * 1. MEMBER-SERVICE-PROVIDER 就是服务提供方[集群], 注册到Eureka Server 的名称
     * 2. 也就是服务提供方[集群]对外暴露的名称为 MEMBER-SERVICE-PROVIDER
     * 3. MEMBER-SERVICE-PROVIDER 目前有 两个 Availability Zones member-service-provider:10000
     *    还有一个 member-service-provider:10002
     *    需要增加一个注解@LoadBalanced 赋予 RestTemplate 负载均衡的能力,也就是会根据你的负载均衡算法
     *    来选择某个服务去访问, 默认是轮询算法, 当然我们也可以自己配置负载均衡算法
     */
    public static final String MEMBER_SERVICE_PROVIDER_URL = "http://MEMBER-SERVICE-PROVIDER";

    @Resource
    private RestTemplate restTemplate;

    //装配DiscoveryClient
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/member/consumer/discovery")
    public Object discovery() {

        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("服务名={}", service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                log.info("id={},host={},port={},uri={}", instance.getServiceId(), instance.getHost(), instance.getPort(), instance.getUri());
            }
        }
        return discoveryClient;
    }

    @PostMapping("/member/consumer/save")
    public Result<Member> save(Member member) {
        //请求的完整的url :MEMBER_SERVICE_PROVIDER_URL + "/member/save" => http://localhost:10000/member/save
        //member : 就是通过restTemplate 发出的post请求携带数据(对象)
        //Result.class: 返回对象类型
        return restTemplate.postForObject(MEMBER_SERVICE_PROVIDER_URL + "/member/save", member, Result.class);
    }

    @GetMapping("/member/consumer/get/{id}")
    public Result<Member> getMemberById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(MEMBER_SERVICE_PROVIDER_URL + "/member/get/" + id, Result.class);
    }
}
