package com.zsy.controller;

import com.zsy.entity.Order;
import com.zsy.entity.Result;
import com.zsy.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zsy
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;
    @GetMapping("/order/save")
    public Result save(Order order) {
        orderService.save(order);
        return Result.success("订单创建成功", null);
    }
}
