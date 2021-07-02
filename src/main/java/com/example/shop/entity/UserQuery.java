package com.example.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserQuery {
    private String email;
    private String isAdmin;
    private int page;
    private int limit;
}
