package com.xiaoyuan.emaillogin.controller;

import com.xiaoyuan.emaillogin.service.UserService;
import com.xiaoyuan.emaillogin.vo.R;
import com.xiaoyuan.emaillogin.vo.param.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * FileName:    UserController
 * Author:      小袁教程
 * Date:        2022/5/26 18:17
 * Description:
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    // 登录
    @PostMapping("login")
    public R login(@RequestBody LoginParam loginParam) {
        return userService.login(loginParam);
    }

    // 注册
    @PostMapping("register")
    public R register(@RequestBody LoginParam loginParam) {
        return userService.register(loginParam);
    }

    // 找回密码
    @PostMapping("findPassword")
    public R findPassword(@RequestBody LoginParam loginParam) {
        return userService.findPassword(loginParam);
    }
}
