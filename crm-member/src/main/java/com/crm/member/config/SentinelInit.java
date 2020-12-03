package com.crm.member.config;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SentinelInit implements ApplicationListener<ContextRefreshedEvent> {


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initSentinelFlowRules();
    }

    /**
     * 初始化sentinel规则
     */
    private void initSentinelFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule memberRule = new FlowRule();
        memberRule.setResource("MEMBER_SOURCE");
        memberRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // qps限制为 1
        memberRule.setCount(1);
        rules.add(memberRule);
        FlowRuleManager.loadRules(rules);
    }
}
