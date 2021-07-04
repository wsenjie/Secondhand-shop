package com.example.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 管理员订单查询实体类：用于接受前端数据
 * @author sen
 */
@Setter
@Getter
@ToString
public class OrderQueryAdmin {
    //收货人姓名
    private String takeName;
    //订单状态  1:待确认 2:待发货 3:待收货 4:已完成
    //后台查询
    private String state;
    //用户id
    private String userId;
    //商品id
    private String goodId;
    //当前页面
    private int page;
    //一页查询多少条数据
    private int limit;
}
