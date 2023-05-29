package com.zsy.controller;

import com.zsy.entity.Result;
import com.zsy.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zsy
 */
@RestController
public class AccountController {

    @Resource
    AccountService accountService;

    @PostMapping("/account/reduce")
    public Result result(@RequestParam("userId") Long userId, @RequestParam("money") Integer money) {
        //模拟异常, 超时
        // try {
        // TimeUnit.SECONDS.sleep(20);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        accountService.reduce(userId, money);
        return Result.success("200", "扣减账户余额 OK");
    }
}

