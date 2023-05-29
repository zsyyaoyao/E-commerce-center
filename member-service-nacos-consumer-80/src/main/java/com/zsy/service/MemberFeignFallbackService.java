package com.zsy.service;

import com.zsy.entity.Result;
import org.springframework.stereotype.Component;

/**
 * @author zsy
 */
@Component
public class MemberFeignFallbackService implements MemberOpenFeignService{
    @Override
    public Result getMemberById(Long id) {
        return Result.error("500","被调用服务异常,启用熔断降级,快速返回结果,防止线程堆积");
    }
}
