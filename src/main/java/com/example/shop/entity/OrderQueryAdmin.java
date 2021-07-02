package com.example.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OrderQueryAdmin {
    private String takeName;
    private String state;
    private String userId;
    private String goodId;
    private int page;
    private int limit;
}
