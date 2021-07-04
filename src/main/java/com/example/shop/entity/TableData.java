package com.example.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 后台分页查询实体类
 * @author sen
 */
@Getter
@Setter
@ToString
public class TableData {
    //状态码（给前端）
    private int code = 0;
    //消息（给前端）
    private String msg = "";
    //数据总数
    private int count = 0;
    //集合数据
    private List data = null;
}
