package com.xiaoyuan.emaillogin.service;

import com.xiaoyuan.emaillogin.vo.R;
import com.xiaoyuan.emaillogin.vo.param.LoginParam;

/**
 * FileName:    CommonService
 * Author:      小袁教程
 * Date:        2022/5/26 15:38
 * Description:
 */
public interface CommonService {

    /**
     * 获取请求权限码
     * @param emailJson 邮箱
     * @return
     */
    R getRequestPermissionCode(String emailJson);

    /**
     * 发送邮箱验证码
     * @param loginParam （邮箱和权限码）
     * @return
     */
    R sendEmailCode(LoginParam loginParam);
}
