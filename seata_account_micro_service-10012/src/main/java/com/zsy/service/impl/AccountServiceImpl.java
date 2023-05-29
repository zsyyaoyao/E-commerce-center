package com.zsy.service.impl;

import com.zsy.dao.AccountDao;
import com.zsy.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zsy
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void reduce(Long userId, Integer money) {
        log.info("========seata_account_micro_service-10012 扣减账户余额 start ======");
        accountDao.reduce(userId, money);
        log.info("========seata_account_micro_service-10012 扣减账户余额 end ======");
    }
}
