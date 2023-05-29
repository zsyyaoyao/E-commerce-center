package com.zsy.service.impl;

import com.zsy.dao.MemberDao;
import com.zsy.entity.Member;
import com.zsy.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class MemberServiceImpl implements MemberService {
    @Resource
    private MemberDao memberDao;

    @Override
    public Member queryMemberById(Long id) {
        return memberDao.queryMemberById(id);
    }

    @Override
    public int save(Member member) {
        return memberDao.save(member);
    }
}