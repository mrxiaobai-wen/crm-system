package com.crm.member.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页查询参数
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageParam {
    protected Integer pageIndex;
    protected Integer pageSize;
}
