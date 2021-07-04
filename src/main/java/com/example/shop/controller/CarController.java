package com.example.shop.controller;

import com.example.shop.dao.CarDao;
import com.example.shop.dao.CategoryDao;
import com.example.shop.dao.UserDao;
import com.example.shop.entity.Car;
import com.example.shop.entity.Category;
import com.example.shop.entity.Good;
import com.example.shop.entity.User;
import com.example.shop.util.Function;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 购物车控制器类
 * @author sen
 */
@RestController
@RequestMapping("/car/")
public class CarController {
    @Resource
    private HttpServletRequest request;
    @Resource
    private HttpServletResponse response;

    @Resource
    private CarDao carDao;
    @Resource
    private UserDao userDao;
    @Resource
    private CategoryDao categoryDao;

    /**
     * 获取购物车信息及种类信息
     * @param categoryId
     * @param search
     * @return
     */
    @GetMapping("")
    public ModelAndView index(@RequestParam(required = false,defaultValue = "0") int categoryId, @RequestParam(required = false) String search){
        ModelAndView mv = new ModelAndView();
        User user = userDao.getById(Function.getUserId(request));
        user = user == null ? new User() : user;
        List<Good> goodList = carDao.getByUserId(Function.getUserId(request),categoryId,search);
        List<Category> categoryList = categoryDao.getList();
        mv.addObject(user);
        mv.addObject(goodList);
        mv.addObject(categoryList);
        mv.setViewName("car");
        return mv;
    }

    /**
     * 加入购物车
     * @param goodId
     * @throws IOException
     */
    @GetMapping("save")
    public void save(int goodId) throws IOException {
        if(Function.getUserId(request) == 0){
            return;
        }
        Car car = new Car();
        car.setGoodId(goodId);
        car.setUserId(Function.getUserId(request));
        carDao.save(car);
        response.sendRedirect("/good/details?id="+goodId);
    }

    /**
     * 从购物车移除
     * @param goodId
     * @throws IOException
     */
    @GetMapping("del")
    public void del(int goodId) throws IOException {
        carDao.del(goodId,Function.getUserId(request));
        response.sendRedirect("/good/details?id="+goodId);
    }
}
