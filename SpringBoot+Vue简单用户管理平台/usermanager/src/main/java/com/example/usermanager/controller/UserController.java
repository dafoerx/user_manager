package com.example.usermanager.controller;

import com.example.usermanager.bean.User;
import com.example.usermanager.service.UserService;
import com.example.usermanager.vo.QueryParam;
import com.example.usermanager.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * FileName:    UserController
 * Author:      小袁
 * Date:        2022/5/6 13:47
 * Description:
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public R insertUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @DeleteMapping("{id}")
    public R deleteUser(@PathVariable(value = "id") Integer id) {
        return userService.deleteUserById(id);
    }

    @DeleteMapping("")
    public R deleteMoreUser(@RequestBody List<String> ids) {
        return userService.deleteUserMore(ids);
    }

    @PutMapping("")
    public R updateUser(@RequestBody User user) {
        return userService.updateUserById(user);
    }

    @PostMapping("{index}/{size}")
    public R findUserList(@PathVariable(value = "index") int index,
                        @PathVariable(value = "size") int size,
                        @RequestBody(required = false) QueryParam queryParam) {
        return userService.listUserPage(index, size, queryParam);
    }

    @GetMapping("{id}")
    public R getUserInfo(@PathVariable(value = "id") String id) {
        return userService.getUserInfo(id);
    }
}
