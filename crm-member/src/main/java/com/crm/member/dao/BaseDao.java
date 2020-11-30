package com.crm.member.dao;

import com.crm.member.common.PageContent;
import com.crm.member.common.PageContentContainer;
import com.crm.member.common.PageParam;
import org.jooq.DSLContext;
import org.jooq.Select;
import org.jooq.SelectLimitStep;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * 基础dao
 */
public class BaseDao {

    private static final Integer DEFAULT_PAGE_INDEX = 1;
    private static final Integer DEFAULT_PAGE_SIZE = 10;

    @Resource(name = "dslContext")
    protected DSLContext db;

    protected <T> PageContent<T> getPageResult(SelectLimitStep<?> query, PageParam param, Class<T> clz) {
        return getPageResult(query, param.getPageIndex(), param.getPageSize(), clz);
    }

    protected <T> PageContent<T> getPageResult(SelectLimitStep<?> query, PageParam param, Class<T> clz,
            PageContent<T> container) {
        return getPageResult(query, param.getPageIndex(), param.getPageSize(), clz, container);
    }

    protected <T> PageContent<T> getPageResult(SelectLimitStep<?> select, Integer currentPage,
            Integer pageRows, Class<T> clazz) {
        return getPageResult(select, currentPage, pageRows, clazz, null);
    }

    /**
     * 分页查询
     * @param select 查询语句
     * @param pageIndex 查询页码
     * @param pageSize 查询页大小
     * @param clazz 返回数据类型
     * @param container 查询结果容器
     */
    private <T> PageContent<T> getPageResult(SelectLimitStep<?> select, Integer pageIndex,
            Integer pageSize, Class<T> clazz, PageContent<T> container) {
        // 参数合法校验
        if (pageSize == null || pageSize <= 0) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        if (pageIndex == null || pageIndex < DEFAULT_PAGE_INDEX) {
            pageIndex = DEFAULT_PAGE_INDEX;
        }
        // 容器校验
        PageContent<T> result;
        if (null != container) {
            result = container;
        } else {
            result = new PageContentContainer<T>();
        }
        // 查询语句校验
        if (select == null) {
            result.setTotal(0);
            result.setList(Collections.<T>emptyList());
            return result;
        }
        
        int count = fetchCount(select);
        result.setTotal(count);
        if ((pageIndex - 1) * pageSize >= count) {
            result.setList(Collections.<T>emptyList());
            return result;
        }
        if (count > 0) {
            result.setList(select.limit((pageIndex - 1) * pageSize, (int) pageSize).fetchInto(clazz));
        }
        return result;
    }

    protected int fetchCount(Select<?> select) {
        return db.fetchCount(select);
    }
}
