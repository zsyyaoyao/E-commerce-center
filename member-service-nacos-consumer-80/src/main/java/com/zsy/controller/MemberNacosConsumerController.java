package com.zsy.controller;

import com.zsy.entity.Member;
import com.zsy.entity.Result;
import com.zsy.service.MemberOpenFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zsy
 */
@RestController
@Slf4j
public class MemberNacosConsumerController {

    public static final String MEMBER_SERVICE_NACOS_PROVIDER_URL = "http://member-service-nacos-provider";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private MemberOpenFeignService memberOpenFeignService;


    //编写方法通过openfegin实现远程调用
    @GetMapping("/member/openfeign/consumer/get/{id}")
    public Result<Member> getMemberOpenfeignById(@PathVariable("id") Long id) {
        //使用openfeign接口调用
        log.info("调用方式 openfeign... ");
        return memberOpenFeignService.getMemberById(id);
    }

    @PostMapping("/member/nacos/consumer/save")
    public Result<Member> save(Member member) {
        return restTemplate.postForObject(MEMBER_SERVICE_NACOS_PROVIDER_URL + "/member/save", member, Result.class);
    }

    @GetMapping("/member/nacos/consumer/get/{id}")
    public Result<Member> getMemberById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(MEMBER_SERVICE_NACOS_PROVIDER_URL + "/member/get/" + id, Result.class);
    }
}
