package com.example.shop.dao;

import com.example.shop.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {
    int save(Order order);

    List<OrderDetails> getByUserId(OrderQuery orderQuery);

    void pay(@Param(value = "orderId")int orderId);

    void del(@Param(value = "orderId")int orderId);

    void ship(@Param(value = "orderId")int orderId,@Param(value = "expressName") String expressName,@Param(value = "expressNumber") String expressNumber);

    void receipt(@Param(value = "orderId")int orderId);

    List query(OrderQueryAdmin query);

    int queryCount(OrderQueryAdmin query);

    void delList(List<Integer> idList);

    Order getById(@Param(value = "id")int id);

    void update(Order order);
}
