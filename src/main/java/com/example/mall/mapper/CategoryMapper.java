package com.example.mall.mapper;

import com.example.mall.entity.Category;
import com.example.mall.entity.CategoryVO;
import com.example.mall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper extends GeneralDAO<Category> {

    //1.连接查询
    public List<CategoryVO> selectAllCategories();

    //2.子查询：根据parentId查询子分类
    public List<CategoryVO> selectAllCategories2(int parentId);

    //3.查询一级类别
    public List<CategoryVO> selectFirstLevelCategories();

    //4.增加类别
    void addCategory(CategoryVO categoryvo);
    //5.删除类别
    void deleteCategory(int categoryId);
}
