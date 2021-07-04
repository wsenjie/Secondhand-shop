package com.example.shop.dao;

import com.example.shop.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单mapper接口
 */
public interface OrderDao {
    //插入
    int save(Order order);
    //订单页面，获取所有订单信息 (注意点*)
    List<OrderDetails> getByUserId(OrderQuery orderQuery);
    //更新订单状态为2：待发货
    void pay(@Param(value = "orderId")int orderId);
    // 删除订单信息
    void del(@Param(value = "orderId")int orderId);
    //更新订单状态为3：待收货
    void ship(@Param(value = "orderId")int orderId,@Param(value = "expressName") String expressName,@Param(value = "expressNumber") String expressNumber);
    //更新订单状态为4：已完成
    void receipt(@Param(value = "orderId")int orderId);
    //后台分页查询
    List query(OrderQueryAdmin query);
    //数据总数查询
    int queryCount(OrderQueryAdmin query);
    //后台（批量|单个）删除
    void delList(List<Integer> idList);
    //查询订单信息（订单id）
    Order getById(@Param(value = "id")int id);
    //后台更新
    void update(Order order);
}
