package com.zsy.controller;

import com.zsy.entity.Result;
import com.zsy.service.MemberFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zsy
 */
@RestController
public class MemberConsumerFeignController {

    @Resource
    private MemberFeignService memberFeignService;

    @GetMapping(value = "/member/consumer/openfeign/get/{id}")
    public Result getMemberById(@PathVariable("id") Long id) {
        return memberFeignService.getMemberById(id);
    }
}
