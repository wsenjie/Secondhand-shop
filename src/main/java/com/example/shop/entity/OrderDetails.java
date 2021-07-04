package com.example.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 订单详情实体类：用于显示订单列表中各个订单的订单信息
 * @author sen
 */
@Getter
@Setter
@ToString
public class OrderDetails {
    //订单id
    private int id;
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
    private int state;

    //商品id
    private int goodId;
    //商品图片
    private String img;
    //商品名称
    private String title;
    //商品价格
    private int price;

    //订单出售状态 1：买  0：卖
    private int isSelf;
}
