package com.qf.controller;

import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @program: ySirWeb
 * @description: 用户相关控制器
 * @encoder: Roue
 * @create: 2020-06-25 17:39
 **/
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("loginUser")
    @ResponseBody
    public String loginUser(String email, String password, HttpSession session){
        User user = userService.loginUser(email,password);
        if (null != user) {
            session.setAttribute("userAccount",user);
            return "success";
        }
        return "failed";
    }

    @RequestMapping("loginOut")
    public String loginOut(HttpSession session){
        session.removeAttribute("userAccount");
        return "/before/index.jsp";
    }

    @RequestMapping("insertUser")
    public String insertUser(User user){
        return null;
    }
}
