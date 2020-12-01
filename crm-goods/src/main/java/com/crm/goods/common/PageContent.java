package com.crm.goods.common;

import java.util.List;

/**
 * 分页查询定义
 */
public interface PageContent<T> {

    void setTotal(Integer total);

    void setList(List<T> list);

    List<T> getList();

    Integer getTotal();
}
