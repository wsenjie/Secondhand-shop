package com.example.shop.dao;

import com.example.shop.entity.Car;
import com.example.shop.entity.Good;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarDao {
    void save(Car car);

    List<Good> getByUserId(@Param(value = "userId")int userId,@Param(value = "categoryId") int categoryId,@Param(value = "search") String search);

    int isInCar(@Param(value = "goodId")int goodId,@Param(value = "userId") int userId);

    void del(@Param(value = "goodId")int goodId,@Param(value = "userId") int userId);
}
