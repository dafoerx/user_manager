package com.xiaoyuan.emaillogin.vo.param;

import lombok.Getter;

/**
 * FileName:    LoginParam
 * Author:      小袁教程
 * Date:        2022/5/26 12:45
 * Description:
 */
@Getter
public class LoginParam {

    private String email; // 邮箱

    private String password; // 密码

    private String passwordConfirm; // 确认密码

    private String code; // 验证码
}
