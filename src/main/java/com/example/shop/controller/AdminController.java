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

@RestController
@RequestMapping("/admin/")
public class AdminController {
    @Resource
    private HttpServletRequest request;
    @Resource
    private UserDao userDao;

    @GetMapping("")
    public ModelAndView userManager(){
        ModelAndView mv = new ModelAndView();
        User user = userDao.getById(Function.getUserId(request));
        mv.addObject(user);
        mv.setViewName("admin/userManager");
        return mv;
    }
    @GetMapping("good")
    public ModelAndView goodManager(){
        ModelAndView mv = new ModelAndView();
        User user = userDao.getById(Function.getUserId(request));
        mv.addObject(user);
        mv.setViewName("admin/goodManager");
        return mv;
    }
    @GetMapping("category")
    public ModelAndView categoryManager(){
        ModelAndView mv = new ModelAndView();
        User user = userDao.getById(Function.getUserId(request));
        mv.addObject(user);
        mv.setViewName("admin/categoryManager");
        return mv;
    }
    @GetMapping("order")
    public ModelAndView orderManager(){
        ModelAndView mv = new ModelAndView();
        User user = userDao.getById(Function.getUserId(request));
        mv.addObject(user);
        mv.setViewName("admin/orderManager");
        return mv;
    }
    @GetMapping("message")
    public ModelAndView messageManager(){
        ModelAndView mv = new ModelAndView();
        User user = userDao.getById(Function.getUserId(request));
        mv.addObject(user);
        mv.setViewName("admin/messageManager");
        return mv;
    }
}
