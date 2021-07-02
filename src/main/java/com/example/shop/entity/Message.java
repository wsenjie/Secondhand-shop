package com.example.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 留言实体类
 * @author sen
 */
@Getter
@Setter
@ToString
public class Message {
    //留言id
    private int id;
    //用户id
    private int userId;
    //商品id
    private int goodId;
    //留言内容
    private String content;
    //用户名称
    private String username;
}
