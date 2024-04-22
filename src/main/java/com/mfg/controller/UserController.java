package com.mfg.controller;

import com.mfg.bean.Result;
import com.mfg.bean.User;
import com.mfg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册
     * @param user 参数封装
     * @return Result
     */
    @RequestMapping(value = "/regist")
    public String regist(User user){
        Result re=userService.regist(user);
        if (re.getDetail()!=null){
            return "register_success";
        }
        return "sue";
    }

    /**
     * 登录
     * @param user 参数封装
     * @return Result
     */
    @RequestMapping(value = "/login")
    public String login(User user){

        Result login = userService.login(user);
        if (login.getDetail()!=null){
            return "login_success";
        }
        return "shibai";
    }
}

