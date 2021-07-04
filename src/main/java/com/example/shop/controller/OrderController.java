package com.example.shop.controller;

import com.example.shop.dao.GoodDao;
import com.example.shop.dao.OrderDao;
import com.example.shop.dao.UserDao;
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
 * 订单管理控制器类
 */
@Slf4j
@RestController
@RequestMapping("/order/")
public class OrderController {
    @Resource
    private HttpServletResponse response;
    @Resource
    private HttpServletRequest request;

    @Resource
    private GoodDao goodDao;
    @Resource
    private OrderDao orderDao;
    @Resource
    private UserDao userDao;

    /**
     * 订单页面，获取所有订单信息
     * @param orderQuery
     * @return
     */
    @GetMapping("")
    public ModelAndView order(OrderQuery orderQuery){
        ModelAndView mv = new ModelAndView();
        User user = userDao.getById(Function.getUserId(request));
        user = user == null ? new User() : user;
        orderQuery.setUserId(Function.getUserId(request));
        List<OrderDetails> orderDetailsList = orderDao.getByUserId(orderQuery);
        mv.addObject(user);
        mv.addObject(orderDetailsList);
        mv.setViewName("order");
        return mv;
    }

    /**
     * 点击立即购买，获取商品信息
     * @param goodId
     * @return
     */
    @GetMapping("buy")
    public ModelAndView buy(int goodId){
        ModelAndView mv = new ModelAndView();
        Good good = goodDao.getById(goodId);
        mv.addObject(good);
        mv.setViewName("buy");
        return mv;
    }
    /**
     * 购买商品
     * @param order
     * @throws IOException
     */
    @PostMapping("save")
    public void save(Order order) throws IOException {
        order.setUserId(Function.getUserId(request));
        //保存订单记录
        orderDao.save(order);
        //更新商品状态为0：已售出
        goodDao.buy(order.getGoodId());
        response.sendRedirect("/order/");
    }

    /**
     * 支付订单
     * @param orderId
     * @throws IOException
     */
    @GetMapping("pay")
    public void pay(int orderId) throws IOException {
        //更新订单状态为2：待发货
        orderDao.pay(orderId);
        response.sendRedirect("/order/");
    }

    /**
     * 取消订单
     * @param orderId
     * @throws IOException
     */
    @GetMapping("cancel")
    public void cancel(int orderId) throws IOException {
        //更新商品状态为1：未售出
        goodDao.cancel(orderId);
        // 删除订单信息
        orderDao.del(orderId);
        response.sendRedirect("/order/");
        return ;
    }

    /**
     * 确认发货
     * @param orderId
     * @param expressName
     * @param expressNumber
     * @throws IOException
     */
    @PostMapping("ship")
    public void ship(int orderId,String expressName,String expressNumber) throws IOException {
        //更新订单状态为3：待收货
        orderDao.ship(orderId,expressName,expressNumber);
        response.sendRedirect("/order/");
    }

    /**
     * 确认收货
     * @param orderId
     * @throws IOException
     */
    @GetMapping("receipt")
    public void receipt(int orderId) throws IOException {
        //更新订单状态为4：已完成
        orderDao.receipt(orderId);
        response.sendRedirect("/order/");
    }

    /**
     * 后台分页查询
     * @param query
     * @return
     */
    @GetMapping("query")
    public TableData query(OrderQueryAdmin query){
        query.setPage((query.getPage() - 1) * query.getLimit());
        TableData tableData = new TableData();
        tableData.setData(orderDao.query(query));
        tableData.setCount(orderDao.queryCount(query));
        return tableData;
    }

    /**
     * 后台删除
     * @param idList
     * @return
     */
    @GetMapping("delList")
    public boolean delList(@RequestParam(name = "idList") List<Integer> idList){
        orderDao.delList(idList);
        return true;
    }

    /**
     * 后台查询
     */
    @GetMapping("getById")
    public Order getById(int id){
        return orderDao.getById(id);
    }

    /**
     * 后台更新
     * @param order
     * @return
     */
    @PostMapping("update")
    public boolean userUpdate(Order order){
        orderDao.update(order);
        return true;
    }
}
