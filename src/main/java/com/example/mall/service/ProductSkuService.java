package com.example.mall.service;

import com.example.mall.vo.ResultVO;

public interface ProductSkuService {
    ResultVO selectSkusByProductId(String productId);//根据产品ID获取库存信息
}
