package com.example.shop.controller;

import com.example.shop.dao.*;
import com.example.shop.entity.*;
import com.example.shop.util.Function;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 商品控制器类
 * @author sen
 */
@Slf4j
@RestController
@RequestMapping("/good/")
public class GoodController {
    @Resource
    private GoodDao goodDao;
    @Resource
    private MessageDao messageDao;
    @Resource
    private CarDao carDao;
    @Resource
    private UserDao userDao;
    @Resource
    private CategoryDao categoryDao;

    @Resource
    private HttpServletRequest request;
    @Resource
    private HttpServletResponse response;

    /**
     * 获取商品信息列表和种类信息列表
     * @param categoryId
     * @param search
     * @return
     */
    @GetMapping("")
    public ModelAndView index(@RequestParam(required = false,defaultValue = "0") int categoryId,@RequestParam(required = false) String search){
        ModelAndView mv = new ModelAndView();
        User user = userDao.getById(Function.getUserId(request));
        user = user == null ? new User() : user;
        List<Good> goodList = goodDao.getList(categoryId,search);
        List<Category> categoryList = categoryDao.getList();
        mv.addObject(user);
        mv.addObject(goodList);
        mv.addObject(categoryList);
        mv.setViewName("good");
        return mv;
    }

    /**
     * 商品详情页面
     * @param id
     * @return
     */
    @GetMapping("details")
    public ModelAndView details(int id){
        ModelAndView mv = new ModelAndView();
        Good good = goodDao.getById(id);
        if (good.getUserId() != Function.getUserId(request)){
            good.setUserId(0);
        }
        //获取留言列表信息
        List<Message> messageList = messageDao.getListByGoodId(good.getId());
        //判断是否在购物车
        int isInCar = carDao.isInCar(id,Function.getUserId(request));
        mv.addObject("isInCar",isInCar);
        mv.addObject(good);
        mv.addObject(messageList);
        mv.setViewName("details");
        return mv;
    }

    /**
     * 商品留言
     * @param content
     * @param goodId
     * @throws IOException
     */
    @GetMapping("message")
    public void message(String content,int goodId) throws IOException {
        if(Function.getUserId(request) == 0){
            return;
        }
        Message message = new Message();
        message.setContent(content);
        message.setGoodId(goodId);
        message.setUserId(Function.getUserId(request));
        //保存留言信息
        messageDao.save(message);
        response.sendRedirect("/good/details?id="+goodId);
    }

    /**
     * 后台删除（商品id）
     * @param goodId
     * @throws IOException
     */
    @GetMapping("del")
    public void del(int goodId) throws IOException {
        goodDao.del(goodId);
        response.sendRedirect("/sale/");
    }

    /**
     * 分页查询
     * @param query
     * @return
     */
    @GetMapping("query")
    public TableData query(GoodQuery query){
        query.setPage((query.getPage() - 1) * query.getLimit());
        TableData tableData = new TableData();
        tableData.setData(goodDao.query(query));
        tableData.setCount(goodDao.queryCount(query));
        return tableData;
    }

    /**
     * 后台批量删除
     * @param idList
     * @return
     */
    @GetMapping("delList")
    public boolean delList(@RequestParam(name = "idList[]")List<Integer> idList){
        goodDao.delList(idList);
        return true;
    }

    /**
     * 查询商品信息（商品id）
     * @param id
     * @return
     */
    @GetMapping("getById")
    public Good getById(int id){
        return goodDao.getById(id);
    }

    /**
     * 后台更新
     * @param good
     * @return
     */
    @PostMapping("update")
    public boolean userUpdate(Good good){
        goodDao.update(good);
        return true;
    }
}
