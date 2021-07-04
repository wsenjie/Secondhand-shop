package com.example.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 订单查询实体类
 * @author sen
 */
@Getter
@Setter
@ToString
public class OrderQuery {
    //用户id
    private int userId;
    //订单类型 1：买入订单 2：卖出订单
    //没有点击右侧订单类型，默认为：0
    private int orderType;
    //订单状态  1:待确认 2:待发货 3:待收货 4:已完成
    // 没有点击右侧订单状态，默认为：0
    private int state;
}
