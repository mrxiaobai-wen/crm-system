package com.crm.member.controller;

import com.crm.member.common.Result;
import com.crm.member.service.MemberService;
import com.crm.member.service.pojo.MemberVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 会员业务控制层
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource
    private MemberService memberService;

    /**
     * 查询指定ID会员信息
     */
    @GetMapping("/getById/{memberId}")
    public Result<MemberVO> getById(@PathVariable Integer memberId) {
        return Result.ok(memberService.getById(memberId));
    }
}
