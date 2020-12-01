package com.crm.goods.service;

import com.crm.goods.service.pojo.GoodsVO;
import org.springframework.stereotype.Service;

import static com.crm.goods.db.tables.Goods.GOODS;

/**
 * 商品业务类
 */
@Service
public class GoodsService extends AbstractBaseService {

    /**
     * 查询指定ID的货品信息
     */
    public GoodsVO getById(Integer goodsId) {
        return dslContext
                .select(GOODS.ID,
                        GOODS.NAME,
                        GOODS.AMOUNT,
                        GOODS.STOCK,
                        GOODS.DESCRIPTION,
                        GOODS.IMGURL)
                .from(GOODS)
                .where(GOODS.ID.eq(goodsId))
                .fetchOneInto(GoodsVO.class);
    }
}
