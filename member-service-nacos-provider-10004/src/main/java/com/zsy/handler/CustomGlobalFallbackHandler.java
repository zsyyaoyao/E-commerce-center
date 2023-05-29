package com.zsy.handler;

import com.zsy.entity.Result;

/**
 * @author zsy
 * CustomGlobalFallbackHandler: 全局fallback处理类
 * 在CustomGlobalFallbackHandler类中,可以去编写处理java异常/业务异常方法-static
 */
public class CustomGlobalFallbackHandler {

    public static Result fallbackHandlerMethod1(Throwable e) {
        return Result.error("402","java异常 信息=" + e.getMessage());
    }

    public static Result fallbackHandlerMethod2(Throwable e) {
        return Result.error("403","java异常 信息=" + e.getMessage());
    }
}
