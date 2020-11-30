package com.crm.member.service.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 会员出参
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {

    private Integer id;
    private String name;
    private String mobile;
    private String remark;
}
