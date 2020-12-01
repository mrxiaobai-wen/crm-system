package com.crm.goods.service.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * 商品出参
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class GoodsVO {

    private Integer id;
    private String goodsNo;
    private String name;
    private BigDecimal amount;
    private Integer stock;
    private String description;
    private String imgurl;
}
