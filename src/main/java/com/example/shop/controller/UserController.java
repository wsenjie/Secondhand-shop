package com.example.shop.controller;

import com.example.shop.dao.UserDao;
import com.example.shop.entity.*;
import com.example.shop.util.FileUpload;
import com.example.shop.util.Function;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
    @Resource
    private FileUpload fileUpload;
    @Resource
    private HttpServletRequest request;
    @Resource
    private HttpServletResponse response;
    @Resource
    private UserDao userDao;

    @GetMapping("login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    // 登录
    @PostMapping("loginAction")
    public int loginAction(User user) {
        User user1 = userDao.login(user);
        if (user1 == null) {

            return 0;
        }
        request.getSession().setAttribute("userId", user1.getId());
        if (user1.getIsAdmin() == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    @GetMapping("register")
    public ModelAndView register() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register");
        return mv;
    }

    // 注册
    @PostMapping("registerAction")
    public int registerAction(User user) {
        //判断用户是否存在
        int n = userDao.check(user);
        if (n == 1) {
            return 0;
        }
        if (!"".equals(user.getEmail()) && !"".equals(user.getName()) &&
                !"".equals(user.getPassword()) && !"".equals(user.getSex())) {
            userDao.save(user);
            return 1;
        }else{
            return 2;
        }
    }

    // 注销
    @GetMapping("logout")
    public void logout() throws IOException {
        request.getSession().setAttribute("userId", null);
        response.sendRedirect("/login");
    }

    //通过保存的id查询用户信息传给前端
    @GetMapping("info")
    public ModelAndView info() {
        ModelAndView mv = new ModelAndView();
        User user = userDao.getById(Function.getUserId(request));
        mv.addObject(user);
        mv.setViewName("info");
        return mv;
    }

    // 更新用户信息
    @PostMapping("update")
    public boolean update(User user) {
        if (user.getFile() != null) {
            user.setImg(fileUpload.save(user.getFile()));
        }
        user.setId((Integer) request.getSession().getAttribute("userId"));
        userDao.update(user);
        return true;
    }

    @GetMapping("query")
    public TableData query(UserQuery query){
        query.setPage((query.getPage() - 1) * query.getLimit());
        TableData tableData = new TableData();
        tableData.setData(userDao.query(query));
        tableData.setCount(userDao.queryCount(query));
        return tableData;
    }

    // 删除
    @GetMapping("del")
    public boolean del(@RequestParam(name = "idList[]")List<Integer> idList){
        userDao.del(idList);
        return true;
    }

    //通过id查询用户信息
    @GetMapping("getById")
    public User getById(int id){
        return userDao.getById(id);
    }

    //通过id更新用户信息
    @PostMapping("user/update")
    public boolean userUpdate(User user){
        userDao.userUpdate(user);
        return true;
    }
}
