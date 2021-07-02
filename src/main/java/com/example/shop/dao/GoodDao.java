package com.example.shop.dao;

import com.example.shop.entity.Good;
import com.example.shop.entity.GoodQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodDao {
    void save(Good good);

    List<Good> getListByUserId(@Param(value = "userId")int userId,@Param(value = "categoryId") int categoryId,@Param(value = "search") String search);

    List<Good> getList(@Param(value = "categoryId") int categoryId,@Param(value = "search") String search);

    Good getById(@Param(value = "id")int id);

    void buy(@Param(value = "goodId")int goodId);

    void del(@Param(value = "goodId")int goodId);

    void cancel(@Param(value = "orderId")int orderId);

    List<Good> getListForAdmin(GoodQuery goodQuery);

    List query(GoodQuery query);

    int queryCount(GoodQuery query);

    void delList(List<Integer> list);

    void update(Good good);
}
