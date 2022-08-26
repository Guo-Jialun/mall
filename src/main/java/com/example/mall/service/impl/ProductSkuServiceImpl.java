package com.example.mall.service.impl;

import com.example.mall.entity.ProductSku;
import com.example.mall.mapper.ProductSkuMapper;
import com.example.mall.vo.ResStatus;
import com.example.mall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author:zyy
 * @date:2021/12/25
 */
public class ProductSkuServiceImpl {
    @Autowired
    ProductSkuMapper productSkuMapper;
    //根据产品ID获取库存信息
    public ResultVO selectSkusByProductId(String productId){
        List<ProductSku> list = productSkuMapper.selectSkusByProductId(productId);
        ResultVO resultVO = new ResultVO(ResStatus.OK, "success", list);
        return resultVO;
    }
}
