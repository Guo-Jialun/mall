package com.example.mall.service;

import com.example.mall.vo.ResultVO;

import java.sql.Timestamp;

public interface IndexImgService {

    public ResultVO listIndexImgs();

    //删除轮播图
    //@Transactional
    ResultVO deleteIndexImg(String imgId);

    ResultVO addIndexPic(String imgUrl);

    ResultVO addIndexImg(String id, String imgUrl, String productId);

    ResultVO addIndexImg(String imgId, String imgUrl, String imgBgColor, String prodId, String categoryId, Integer indexType, Integer seq, Integer status, Timestamp createTime, Timestamp updateTime);
}
