package com.example.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 留言查询实体类
 * @author sen
 */
@Getter
@Setter
@ToString
public class MessageQuery {
    //用户id
    private String userId;
    //商品id
    private String goodId;
    //留言内容
    private String content;
    //当前页面
    private int page;
    //一页查询多少条数据
    private int limit;
}
