package com.zsy.service;

import com.zsy.entity.Member;

public interface MemberService {
    Member queryMemberById(Long id);

    int save(Member member);
}