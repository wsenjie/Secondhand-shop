package com.example.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderQuery {
    private int userId;
    private int orderType;
    private int state;
}
