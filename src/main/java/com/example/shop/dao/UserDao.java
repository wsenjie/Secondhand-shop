package com.example.shop.dao;

import com.example.shop.entity.User;
import com.example.shop.entity.UserQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    User login(User user);

    void save(User user);

    int check(User user);

    void update(User user);

    User getById(@Param(value = "userId")int userId);

    List<User> query(UserQuery userQuery);

    int queryCount(UserQuery userQuery);

    void del(List<Integer> list);

    void userUpdate(User user);

}
