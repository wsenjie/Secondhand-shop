package com.example.shop.controller;

import com.example.shop.dao.MessageDao;
import com.example.shop.entity.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 留言控制器类
 * @author sen
 */
@RestController
@RequestMapping("/message/")
public class MessageController {
    @Resource
    private MessageDao messageDao;

    /**
     * 分页查询
     * @param query
     * @return
     */
    @GetMapping("query")
    public TableData query(MessageQuery query){
        query.setPage((query.getPage() - 1) * query.getLimit());
        TableData tableData = new TableData();
        tableData.setData(messageDao.query(query));
        tableData.setCount(messageDao.queryCount(query));
        return tableData;
    }

    /**
     * 后台批量删除
     * @param idList
     * @return
     */
    @GetMapping("delList")
    public boolean delList(@RequestParam(name = "idList[]") List<Integer> idList){
        messageDao.delList(idList);
        return true;
    }

    /**
     * 查询留言信息（留言id）
     * @param id
     * @return
     */
    @GetMapping("getById")
    public Message getById(int id){
        return messageDao.getById(id);
    }

    /**
     * 后台更新
     * @param message
     * @return
     */
    @PostMapping("update")
    public boolean userUpdate(Message message){
        messageDao.update(message);
        return true;
    }
}
