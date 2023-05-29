package com.zsy.service;

import com.zsy.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zsy
 */
@FeignClient(value = "seata-storage-micro-service")
public interface StorageService {

    //扣减库存
    @PostMapping("/storage/reduce")
    public Result reduce(@RequestParam("productId") Long productId,@RequestParam("nums") Integer nums);
}
