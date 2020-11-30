/*
 * This file is generated by jOOQ.
 */
package com.crm.goods.db;


import com.crm.goods.db.tables.Goods;
import com.crm.goods.db.tables.records.GoodsRecord;

import org.jooq.Identity;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>crm-goods</code> schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<GoodsRecord, Integer> IDENTITY_GOODS = Identities0.IDENTITY_GOODS;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<GoodsRecord> KEY_GOODS_PRIMARY = UniqueKeys0.KEY_GOODS_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<GoodsRecord, Integer> IDENTITY_GOODS = Internal.createIdentity(Goods.GOODS, Goods.GOODS.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<GoodsRecord> KEY_GOODS_PRIMARY = Internal.createUniqueKey(Goods.GOODS, "KEY_goods_PRIMARY", new TableField[] { Goods.GOODS.ID }, true);
    }
}
