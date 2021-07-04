package com.example.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

/**
 * 用户实体类
 * @author sen
 */
@Getter
@Setter
@ToString
public class User {
    //用户id
    private int id;
    //用户邮箱
    private String email;
    //用户密码
    private String password;
    //用户名称
    private String name;
    //用户性别
    private String sex;
    //用户头像
    private String img;
    //是否是管理员 1：是  0：不是
    private int isAdmin;
    //头像图片文件
    private MultipartFile file;
}
