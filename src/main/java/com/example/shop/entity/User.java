package com.example.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class User {
    private int id;
    private String email;
    private String password;
    private String name;
    private String sex;
    private String img;
    private int isAdmin;

    private MultipartFile file;
}
