package com.example.shop.controller;

import com.example.shop.dao.UserDao;
import com.example.shop.entity.User;
import com.example.shop.util.Function;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 管理员控制器类
 */
@RestController
@RequestMapping("/admin/")
public class AdminController {
    @Resource
    private HttpServletRequest request;
    @Resource
    private UserDao userDao;

    /**
     * 用户管理
     * @return
     */
    @GetMapping("")
    public ModelAndView userManager(){
        ModelAndView mv = new ModelAndView();
        User user = userDao.getById(Function.getUserId(request));
        mv.addObject(user);
        mv.setViewName("admin/userManager");
        return mv;
    }

    /**
     * 商品管理
     * @return
     */
    @GetMapping("good")
    public ModelAndView goodManager(){
        ModelAndView mv = new ModelAndView();
        User user = userDao.getById(Function.getUserId(request));
        mv.addObject(user);
        mv.setViewName("admin/goodManager");
        return mv;
    }

    /**
     * 分类管理
     * @return
     */
    @GetMapping("category")
    public ModelAndView categoryManager(){
        ModelAndView mv = new ModelAndView();
        User user = userDao.getById(Function.getUserId(request));
        mv.addObject(user);
        mv.setViewName("admin/categoryManager");
        return mv;
    }

    /**
     * 订单管理
     * @return
     */
    @GetMapping("order")
    public ModelAndView orderManager(){
        ModelAndView mv = new ModelAndView();
        User user = userDao.getById(Function.getUserId(request));
        mv.addObject(user);
        mv.setViewName("admin/orderManager");
        return mv;
    }

    /**
     * 留言管理
     * @return
     */
    @GetMapping("message")
    public ModelAndView messageManager(){
        ModelAndView mv = new ModelAndView();
        User user = userDao.getById(Function.getUserId(request));
        mv.addObject(user);
        mv.setViewName("admin/messageManager");
        return mv;
    }
}
