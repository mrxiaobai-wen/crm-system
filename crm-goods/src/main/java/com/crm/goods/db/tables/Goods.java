/*
 * This file is generated by jOOQ.
 */
package com.crm.goods.db.tables;


import com.crm.goods.db.CrmGoods;
import com.crm.goods.db.Keys;
import com.crm.goods.db.tables.records.GoodsRecord;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row9;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Goods extends TableImpl<GoodsRecord> {

    private static final long serialVersionUID = 1497449762;

    /**
     * The reference instance of <code>crm-goods.goods</code>
     */
    public static final Goods GOODS = new Goods();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GoodsRecord> getRecordType() {
        return GoodsRecord.class;
    }

    /**
     * The column <code>crm-goods.goods.id</code>.
     */
    public final TableField<GoodsRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>crm-goods.goods.goods_no</code>. 商品编码
     */
    public final TableField<GoodsRecord, String> GOODS_NO = createField(DSL.name("goods_no"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "商品编码");

    /**
     * The column <code>crm-goods.goods.name</code>. 商品名
     */
    public final TableField<GoodsRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "商品名");

    /**
     * The column <code>crm-goods.goods.description</code>. 商品描述
     */
    public final TableField<GoodsRecord, String> DESCRIPTION = createField(DSL.name("description"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "商品描述");

    /**
     * The column <code>crm-goods.goods.amount</code>. 商品金额
     */
    public final TableField<GoodsRecord, BigDecimal> AMOUNT = createField(DSL.name("amount"), org.jooq.impl.SQLDataType.DECIMAL(19, 4).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.0000", org.jooq.impl.SQLDataType.DECIMAL)), this, "商品金额");

    /**
     * The column <code>crm-goods.goods.stock</code>. 库存
     */
    public final TableField<GoodsRecord, Integer> STOCK = createField(DSL.name("stock"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "库存");

    /**
     * The column <code>crm-goods.goods.imgurl</code>. 商品图片地址
     */
    public final TableField<GoodsRecord, String> IMGURL = createField(DSL.name("imgurl"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "商品图片地址");

    /**
     * The column <code>crm-goods.goods.created</code>. 创建时间
     */
    public final TableField<GoodsRecord, LocalDateTime> CREATED = createField(DSL.name("created"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "创建时间");

    /**
     * The column <code>crm-goods.goods.modified</code>. 修改时间
     */
    public final TableField<GoodsRecord, LocalDateTime> MODIFIED = createField(DSL.name("modified"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "修改时间");

    /**
     * Create a <code>crm-goods.goods</code> table reference
     */
    public Goods() {
        this(DSL.name("goods"), null);
    }

    /**
     * Create an aliased <code>crm-goods.goods</code> table reference
     */
    public Goods(String alias) {
        this(DSL.name(alias), GOODS);
    }

    /**
     * Create an aliased <code>crm-goods.goods</code> table reference
     */
    public Goods(Name alias) {
        this(alias, GOODS);
    }

    private Goods(Name alias, Table<GoodsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Goods(Name alias, Table<GoodsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Goods(Table<O> child, ForeignKey<O, GoodsRecord> key) {
        super(child, key, GOODS);
    }

    @Override
    public Schema getSchema() {
        return CrmGoods.CRM_GOODS;
    }

    @Override
    public Identity<GoodsRecord, Integer> getIdentity() {
        return Keys.IDENTITY_GOODS;
    }

    @Override
    public UniqueKey<GoodsRecord> getPrimaryKey() {
        return Keys.KEY_GOODS_PRIMARY;
    }

    @Override
    public List<UniqueKey<GoodsRecord>> getKeys() {
        return Arrays.<UniqueKey<GoodsRecord>>asList(Keys.KEY_GOODS_PRIMARY);
    }

    @Override
    public Goods as(String alias) {
        return new Goods(DSL.name(alias), this);
    }

    @Override
    public Goods as(Name alias) {
        return new Goods(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Goods rename(String name) {
        return new Goods(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Goods rename(Name name) {
        return new Goods(name, null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<Integer, String, String, String, BigDecimal, Integer, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row9) super.fieldsRow();
    }
}
