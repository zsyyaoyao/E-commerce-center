package com.zsy.service.impl;

import com.zsy.dao.OrderDao;
import com.zsy.entity.Order;
import com.zsy.service.AccountService;
import com.zsy.service.OrderService;
import com.zsy.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zsy
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;

    @Override
    /*
        1.@GlobalTransactional:分布式全局事务控制
        2.rollbackFor = Exception.class 指定发生什么异常就回滚,这里指定的是Exception.class(只要发生异常就回滚)
     */
    @GlobalTransactional(name = "hspedu-save-order",rollbackFor = Exception.class)
    public void save(Order order) {

        log.info("=========开始新建订单 start ==========");
        orderDao.save(order);
        log.info("=========减库存 start ==========");
        storageService.reduce(order.getProductId(), order.getNums());
        log.info("=========减库存 end ==========");
        log.info("=========减账户金额 start ==========");
        accountService.result(order.getUserId(), order.getMoney());
        log.info("=========减账户金额 end ==========");
        log.info("=========修改订单状态 start ==========");
        orderDao.update(order.getUserId(), 0);
        log.info("=========修改订单状态 end ==========");
        log.info("=========开始新建订单 end ==========");

    }
}
