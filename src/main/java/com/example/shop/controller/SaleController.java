package com.example.shop.controller;

import com.example.shop.dao.CategoryDao;
import com.example.shop.dao.GoodDao;
import com.example.shop.dao.UserDao;
import com.example.shop.entity.Category;
import com.example.shop.entity.Good;
import com.example.shop.entity.User;
import com.example.shop.util.FileUpload;
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
 * 用户出售控制器类
 * @author sen
 */
@Slf4j
@RestController
@RequestMapping("/sale/")
public class SaleController {
    @Resource
    private FileUpload fileUpload;
    @Resource
    private HttpServletResponse response;
    @Resource
    private HttpServletRequest request;

    @Resource
    private GoodDao goodDao;
    @Resource
    private CategoryDao categoryDao;
    @Resource
    private UserDao userDao;

    /**
     * 获取商品信息列表和种类信息列表
     * @param categoryId
     * @param search
     * @return
     */
    @GetMapping("")
    public ModelAndView index(@RequestParam(required = false,defaultValue = "0") int categoryId, @RequestParam(required = false) String search){
        ModelAndView mv = new ModelAndView();
        User user = userDao.getById(Function.getUserId(request));
        user = user == null ? new User() : user;
        List<Good> goodList = goodDao.getListByUserId(Function.getUserId(request),categoryId,search);
        List<Category> categoryList = categoryDao.getList();
        mv.addObject(user);
        mv.addObject(goodList);
        mv.addObject(categoryList);
        mv.setViewName("sale");
        return mv;
    }

    /**
     * 发布商品
     * @param good
     * @throws IOException
     */
    @PostMapping("publish")
    public void publish(Good good) throws IOException {
        if (good.getFile() != null) {
            good.setImg(fileUpload.save(good.getFile()));
        }
        good.setUserId(Function.getUserId(request));
        //保存商品信息
        goodDao.save(good);
        response.sendRedirect("/sale/");
    }
}
