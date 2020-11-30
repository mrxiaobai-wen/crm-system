package com.crm.member.service;


import com.crm.member.dao.MemberDao;
import com.crm.member.service.pojo.MemberVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 会员业务实现类
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberDao memberDao;

    public MemberVO getById(Integer memberId) {
        return memberDao.getById(memberId);
    }
}
