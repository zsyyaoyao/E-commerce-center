package com.zsy.dao;

import com.zsy.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
    //crud 接口...
    Member queryMemberById(Long id);

    int save(Member member);
}
