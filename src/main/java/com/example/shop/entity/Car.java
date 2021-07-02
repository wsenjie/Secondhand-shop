package com.example.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 购物车实体类
 * @author sen
 */
@Getter
@Setter
@ToString
public class Car {
    //购物车的id
    private int id;
    //用户id
    private int userId;
    //商品id
    private int goodId;
}
