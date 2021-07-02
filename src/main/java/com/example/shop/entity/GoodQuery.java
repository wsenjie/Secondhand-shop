package com.example.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 商品查询实体类
 * @author sen
 */
@Getter
@Setter
@ToString
public class GoodQuery {
    //商品名称
    private String title;
    //用户id
    private String userId;
    //商品id
    private String categoryId;
    //当前页面
    private int page;
    //一页查询多少条数据
    private int limit;
}
