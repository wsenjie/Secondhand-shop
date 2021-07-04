package com.example.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户查询实体类
 * @author sen
 */
@Getter
@Setter
@ToString
public class UserQuery {
    //用户邮箱
    private String email;
    //是否是管理员 1：是  0：不是
    private int isAdmin;
    //当前页面
    private int page;
    //一页查询多少条数据
    private int limit;
}
