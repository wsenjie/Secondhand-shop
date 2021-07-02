package com.example.shop.util;

import javax.servlet.http.HttpServletRequest;

/**
 *  自定义功能方法类
 * @author sen
 */
public class Function {

    /**
     *  获取当前存储在Session的用户id
     * @param request
     * @return
     */
    public static int getUserId(HttpServletRequest request){
        Object userId = request.getSession().getAttribute("userId");
        //用来测试一个对象是否为一个类的实例
        if (userId instanceof Integer){
            return (Integer) userId;
        }
        return 0;
    }
}
