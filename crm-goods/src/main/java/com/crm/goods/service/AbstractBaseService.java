package com.crm.goods.service;

import org.jooq.DSLContext;

import javax.annotation.Resource;

/**
 * 基础业务类
 */
public class AbstractBaseService {

    @Resource
    protected DSLContext dslContext;
}
