package com.example.mall.mapper;

import com.example.mall.entity.ProductSku;
import com.example.mall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSkuMapper extends GeneralDAO<ProductSku> {
    /**
     * 根据商品ID，查询当前商品所有套餐中价格最低的套餐
     * @param productId
     * @return
     */
    public List<ProductSku> selectLowerestPriceByProductId(String productId);
    public List<ProductSku> selectSkusByProductId(String productId);
}
