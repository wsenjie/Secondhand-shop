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
    @GetMapping("buy")
    public ModelAndView buy(int goodId){
        ModelAndView mv = new ModelAndView();
        Good good = goodDao.getById(goodId);
        mv.addObject(good);
        mv.setViewName("buy");
        return mv;
    }
    @PostMapping("save")
    public void save(Order order) throws IOException {
        order.setUserId(Function.getUserId(request));
        orderDao.save(order);
        goodDao.buy(order.getGoodId());
        response.sendRedirect("/order/");
    }
    // 支付订单
    @GetMapping("pay")
    public void pay(int orderId) throws IOException {
        orderDao.pay(orderId);
        response.sendRedirect("/order/");
    }
    // 取消订单
    @GetMapping("cancel")
    public void cancel(int orderId) throws IOException {
        goodDao.cancel(orderId);
        orderDao.del(orderId);
        response.sendRedirect("/order/");
        return ;
    }
    // 发货
    @PostMapping("ship")
    public void ship(int orderId,String expressName,String expressNumber) throws IOException {
        orderDao.ship(orderId,expressName,expressNumber);
        response.sendRedirect("/order/");
    }
    // 确认收货
    @GetMapping("receipt")
    public void receipt(int orderId) throws IOException {
        orderDao.receipt(orderId);
        response.sendRedirect("/order/");
    }


    @GetMapping("query")
    public TableData query(OrderQueryAdmin query){
        query.setPage((query.getPage() - 1) * query.getLimit());
        TableData tableData = new TableData();
        tableData.setData(orderDao.query(query));
        tableData.setCount(orderDao.queryCount(query));
        return tableData;
    }
    // 后台删除
    @GetMapping("delList")
    public boolean delList(@RequestParam(name = "idList[]") List<Integer> idList){
        orderDao.delList(idList);
        return true;
    }
    @GetMapping("getById")
    public Order getById(int id){
        return orderDao.getById(id);
    }
    @PostMapping("update")
    public boolean userUpdate(Order order){
        orderDao.update(order);
        return true;
    }
}
