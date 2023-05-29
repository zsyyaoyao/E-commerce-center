package com.zsy.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zsy
 */
@Mapper
public interface AccountDao {
    void reduce(@Param("userId") Long userId, @Param("money") Integer money);
}
