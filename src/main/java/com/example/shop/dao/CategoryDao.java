package com.example.shop.dao;

import com.example.shop.entity.CategoryQuery;
import com.example.shop.entity.Category;
import com.example.shop.entity.Good;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryDao {
    List<Category> getList();

    List query(CategoryQuery query);

    int queryCount(CategoryQuery query);

    void delList(List<Integer> list);

    Category getById(@Param(value = "id")int id);

    void update(Category good);
}
