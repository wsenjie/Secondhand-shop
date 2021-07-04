package com.example.shop.dao;

import com.example.shop.entity.CategoryQuery;
import com.example.shop.entity.Category;
import com.example.shop.entity.Good;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 分类mapper接口
 */
public interface CategoryDao {
    //查询种类信息
    List<Category> getList();
    //分页查询
    List query(CategoryQuery query);
    //查询总数
    int queryCount(CategoryQuery query);
    //后台删除
    void delList(List<Integer> list);
    //后台查询（id）
    Category getById(@Param(value = "id")int id);
    //后台更新
    void update(Category good);
}
