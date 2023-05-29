package com.zsy.service;

import com.zsy.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zsy
 */
@FeignClient(value = "seata-account-micro-service")
public interface AccountService {

    @PostMapping("/account/reduce")
    Result result(@RequestParam("userId") Long userId, @RequestParam("money") Integer money);
}
