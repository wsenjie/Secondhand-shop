package com.example.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 种类查询实体类
 * @author sen
 */
@Getter
@Setter
@ToString
public class CategoryQuery {
    //种类的名称
    private String name;
    //当前页面
    private int page;
    //一页查询多少条数据
    private int limit;
}
