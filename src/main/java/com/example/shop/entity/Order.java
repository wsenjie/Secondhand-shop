package com.example.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 订单实体类
 * @author sen
 */
@Getter
@Setter
@ToString
public class Order {
    //订单id
    private int id;
    //用户id
    private int userId;
    //商品id
    private int goodId;
    //收货人姓名
    private String takeName;
    //收货人地址
    private String takeAddress;
    //收货人电话
    private String takePhone;
    //快递公司
    private String expressName;
    //快递订单号
    private String expressNumber;
    //订单状态  1:待确认 2:待发货 3:待收货 4:已完成
    //后台查询
    private String state;
}
