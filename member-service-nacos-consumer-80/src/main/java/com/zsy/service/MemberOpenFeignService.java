package com.zsy.service;

import com.zsy.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zsy
 */
@FeignClient(value = "member-service-nacos-provider",fallback = MemberFeignFallbackService.class)
public interface MemberOpenFeignService {

    /*
        * 1. 远程调用的方式为 get
        * 2. 远程调用的 url 为 http://member-service-provider/member/get/{id}
        * 3. member-service-provider 是 注册中心服务
        * member-service-provider:10004/10006
        * 4. 会根据 OpenFeign 的均衡算法来决定是调用 10004 还是 10006
     */
    @GetMapping(value = "/member/get/{id}")
    public Result getMemberById(@PathVariable("id") Long id);

}
