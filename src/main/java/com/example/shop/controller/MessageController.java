package com.example.shop.controller;

import com.example.shop.dao.MessageDao;
import com.example.shop.entity.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/message/")
public class MessageController {
    @Resource
    private MessageDao messageDao;

    @GetMapping("query")
    public TableData query(MessageQuery query){
        query.setPage((query.getPage() - 1) * query.getLimit());
        TableData tableData = new TableData();
        tableData.setData(messageDao.query(query));
        tableData.setCount(messageDao.queryCount(query));
        return tableData;
    }
    // 后台删除
    @GetMapping("delList")
    public boolean delList(@RequestParam(name = "idList[]") List<Integer> idList){
        messageDao.delList(idList);
        return true;
    }
    @GetMapping("getById")
    public Message getById(int id){
        return messageDao.getById(id);
    }
    @PostMapping("update")
    public boolean userUpdate(Message message){
        messageDao.update(message);
        return true;
    }
}
