package com.example.usermanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.usermanager.bean.User;
import com.example.usermanager.vo.QueryParam;
import com.example.usermanager.vo.R;

import java.util.List;

/**
 * FileName:    UserService
 * Author:      小袁
 * Date:        2022/5/6 13:27
 * Description:
 */
public interface UserService extends IService<User> {

    /**
     * 添加用户
     * @param user
     * @return
     */
    R insertUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    R deleteUserById(Integer id);

    /**
     * 一次删除多个
     * @param ids
     * @return
     */
    R deleteUserMore(List<String> ids);

    /**
     * 编辑用户信息
     * @param user
     * @return
     */
    R updateUserById(User user);

    /**
     * 用户列表查询
     * @param index
     * @param size
     * @param queryParam
     * @return
     */
    R listUserPage(int index, int size, QueryParam queryParam);

    /**
     * 查询信息
     * @param id
     * @return
     */
    R getUserInfo(String id);
}
