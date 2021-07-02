package com.example.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 商品种类实体类
 * @author sen
 */
@Getter
@Setter
@ToString
public class Category {
    //商品种类的id
    private int id;
    //商品种类的名称
    private String name;
}
