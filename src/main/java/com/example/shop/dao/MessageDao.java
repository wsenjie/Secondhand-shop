package com.example.shop.dao;

import com.example.shop.entity.Message;
import com.example.shop.entity.MessageQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageDao {
    void save(Message message);

    List<Message> getListByGoodId(@Param(value = "goodId")int id);

    List query(MessageQuery query);

    int queryCount(MessageQuery query);

    void delList(List<Integer> idList);

    Message getById(@Param(value = "id")int id);

    void update(Message message);
}
