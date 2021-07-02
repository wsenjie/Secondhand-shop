package com.example.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

/**
 * 商品实体类
 * @author sen
 */
@Getter
@Setter
@ToString
public class Good {
    //商品id
    private int id;
    //用户id
    private int userId;
    //商品种类id
    private int categoryId;
    //商品名称
    private String title;
    //商品描述
    private String describe;
    //商品价格
    private int price;
    //商品图片
    private String img;
    //商品状态  1为未售出  0为已出售
    private int state;
    //商品图片文件
    private MultipartFile file;
}
