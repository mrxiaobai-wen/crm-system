package com.crm.member.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.crm.member.common.Result;
import com.crm.member.service.MemberService;
import com.crm.member.service.pojo.MemberVO;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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

    /**
     * 查询指定ID的会员信息-执行流量监控
     */
    @SentinelResource(value = "MEMBER_SOURCE")
    @GetMapping("/getByIdAndControlFlow/{memberId}")
    public Result<MemberVO> getByIdAndControlFlow(@PathVariable Integer memberId) {
        // pom引入sentinel注解支持，注释掉硬编码
        /*Entry entry = null;
        try {
            entry = SphU.entry("MEMBER_SOURCE");
            return Result.ok(memberService.getById(memberId));
        } catch (BlockException e) {
            log.info("请求被限流");
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
        return null;*/

        return Result.ok(memberService.getById(memberId));
    }
}
