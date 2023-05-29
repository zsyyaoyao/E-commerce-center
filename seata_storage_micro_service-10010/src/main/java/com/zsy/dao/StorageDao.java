package com.zsy.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zsy
 */
@Mapper
public interface StorageDao {

    void reduce(@Param("productId") Long productId, @Param("nums") Integer nums);
}
