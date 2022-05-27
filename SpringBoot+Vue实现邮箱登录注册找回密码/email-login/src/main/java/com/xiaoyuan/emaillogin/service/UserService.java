package com.xiaoyuan.emaillogin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoyuan.emaillogin.db.entity.User;
import com.xiaoyuan.emaillogin.vo.R;
import com.xiaoyuan.emaillogin.vo.param.LoginParam;

/**
 * FileName:    UserService
 * Author:      小袁教程
 * Date:        2022/5/26 16:58
 * Description:
 */
public interface UserService extends IService<User> {

    /**
     * 登录
     * @param loginParam (邮箱和密码)
     * @return
     */
    R login(LoginParam loginParam);

    /**
     * 注册
     * @param loginParam (邮箱、密码、确认密码、验证码)
     * @return
     */
    R register(LoginParam loginParam);

    /**
     * 找回密码
     * @param loginParam (邮箱、密码、验证码)
     * @return
     */
    R findPassword(LoginParam loginParam);
}
