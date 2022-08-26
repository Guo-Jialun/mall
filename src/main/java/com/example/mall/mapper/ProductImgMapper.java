package com.example.mall.mapper;

import com.example.mall.entity.ProductImg;
import com.example.mall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImgMapper extends GeneralDAO<ProductImg> {
    List<ProductImg> selectProductImgByProductId(int productId);
}
