package com.xiaoyuan.emaillogin.controller;

import com.xiaoyuan.emaillogin.service.CommonService;
import com.xiaoyuan.emaillogin.vo.R;
import com.xiaoyuan.emaillogin.vo.param.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * FileName:    CommonController
 * Author:      小袁教程
 * Date:        2022/5/26 16:21
 * Description:
 */
@RestController
@RequestMapping("/common")
@CrossOrigin
public class CommonController {

    @Autowired
    private CommonService commonService;

    // 权限码请求接口
    @PostMapping("code/request")
    public R getRequestPermissionCode(@RequestBody String emailJson) {
        return commonService.getRequestPermissionCode(emailJson);
    }

    // 邮箱验证码接口
    @PostMapping("code/email")
    public R sendEmailCode(@RequestBody LoginParam loginParam) {
        return commonService.sendEmailCode(loginParam);
    }
}
