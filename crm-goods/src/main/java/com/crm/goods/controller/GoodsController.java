package com.crm.goods.controller;

import com.crm.goods.common.Result;
import com.crm.goods.service.GoodsService;
import com.crm.goods.service.pojo.GoodsVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品控制层
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    /**
     * 查询指定ID会员信息
     */
    @GetMapping("/getById/{goodsId}")
    public Result<GoodsVO> getById(@PathVariable Integer goodsId) {
        return Result.ok(goodsService.getById(goodsId));
    }

}
