package com.zsy.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zsy.entity.Result;

/**
 * @author zsy
 * 1.CustomGlobalBlockHandler 全局限流处理类
 * 2.在CustomGlobalBlockHandler中,可以编写限流处理方法,但是要求方法是static
 */
public class CustomGlobalBlockHandler {

    public static Result handlerMethod1(BlockException blockException){
        return Result.error("400", "客户自定义异常/限流处理方法handlerMethod1() ");
    }
    public static Result handlerMethod2(BlockException blockException){
        return Result.error("400", "客户自定义异常/限流处理方法handlerMethod2() ");
    }
}
