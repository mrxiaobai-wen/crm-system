package com.crm.member.service;

import com.crm.member.service.pojo.MemberVO;

/**
 * 会员业务接口
 */
public interface MemberService {

    /**
     * 查询指定ID的会员信息
     */
    MemberVO getById(Integer memberId);
}
