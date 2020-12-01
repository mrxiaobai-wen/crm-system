package com.crm.goods.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页查询结果默认实现
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageContentContainer<T> implements PageContent<T> {

    protected Integer total;
    protected List<T> list;
}
