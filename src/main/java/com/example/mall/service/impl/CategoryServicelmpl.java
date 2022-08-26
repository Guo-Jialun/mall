package com.example.mall.service.impl;

import com.example.mall.entity.CategoryVO;
import com.example.mall.mapper.CategoryMapper;
import com.example.mall.service.CategoryService;
import com.example.mall.vo.ResStatus;
import com.example.mall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServicelmpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询分类列表（包含三个级别的分类）
     * @return
     */
    @Override
    public ResultVO listCategories() {
        List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories();
        ResultVO resultVO = new ResultVO(ResStatus.OK, "success", categoryVOS);
        return resultVO;
    }

    /**
     * 查询所有一级分类，同时查询当前一级分类下销量最高的6个商品
     * @return
     */
    @Override
    public ResultVO listFirstLevelCategories() {
        List<CategoryVO> categoryVOS = categoryMapper.selectFirstLevelCategories();
        ResultVO resultVO = new ResultVO(ResStatus.OK, "success", categoryVOS);
        return resultVO;
    }

}
