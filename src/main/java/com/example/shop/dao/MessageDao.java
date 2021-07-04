package com.example.shop.dao;

import com.example.shop.entity.Message;
import com.example.shop.entity.MessageQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 留言mapper接口
 */
public interface MessageDao {
    //插入
    void save(Message message);
    //获取留言列表信息
    List<Message> getListByGoodId(@Param(value = "goodId")int id);
    //分页查询
    List query(MessageQuery query);
    //数据总数查询
    int queryCount(MessageQuery query);
    //后台（批量|单个）删除
    void delList(List<Integer> idList);
    //查询留言信息（留言id）
    Message getById(@Param(value = "id")int id);
    //后台更新
    void update(Message message);
}
