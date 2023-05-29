package com.zsy.controller;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlCleaner;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author zsy
 * 通过 UrlCleaner 接口来实现资源清洗
 */
@Component
public class CustomUrlCleaner implements UrlCleaner {
    @Override
    public String clean(String originUrl) {

        //isBlank方法就是判断 originUrl!=null && 有长度 && originUrl不是全部为空格
        if (StringUtils.isBlank(originUrl)){
            return originUrl;
        }
        if (originUrl.startsWith("/member/get")){ //如果得到url是以/member/get开头,进行处理
            //1. 如果请求的接口 是 /member/get 开头的, 比如 /member/get/1 , /member/get/10...
            //2. 给sentinel 放回资源名为 /member/get/*
            //3. 在sentinel 对 /member/get/* 添加流控规则即可
            return "/member/get/*";
        }
        return originUrl;
    }
}
