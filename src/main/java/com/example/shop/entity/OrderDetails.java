package com.example.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDetails {
    private int id;
    private String takeName;
    private String takePhone;
    private String takeAddress;
    private String expressName;
    private String expressNumber;
    private int state;

    private int goodId;
    private String img;
    private String title;
    private int price;

    private int isSelf;
}
