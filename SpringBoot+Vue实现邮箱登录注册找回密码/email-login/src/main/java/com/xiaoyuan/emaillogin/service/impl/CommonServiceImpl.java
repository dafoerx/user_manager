package com.xiaoyuan.emaillogin.service.impl;

import com.alibaba.fastjson.JSON;
import com.xiaoyuan.emaillogin.constant.HttpStatusEnum;
import com.xiaoyuan.emaillogin.constant.RedisConstant;
import com.xiaoyuan.emaillogin.service.CommonService;
import com.xiaoyuan.emaillogin.service.ThreadService;
import com.xiaoyuan.emaillogin.utils.StringUtil;
import com.xiaoyuan.emaillogin.vo.R;
import com.xiaoyuan.emaillogin.vo.param.LoginParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * FileName:    CommonServiceImpl
 * Author:      小袁教程
 * Date:        2022/5/26 16:06
 * Description:
 */
@Component
public class CommonServiceImpl implements CommonService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private ThreadService threadService;

    @Override
    public R getRequestPermissionCode(String emailJson) {
        // 非空校验
        if (StringUtils.isBlank(emailJson)) return R.error(HttpStatusEnum.PARAM_ILLEGAL);

        // JSON转换，提取email的值
        String email = JSON.parseObject(emailJson).getString("email").trim();
        // 邮箱校验
        if (!StringUtil.checkEmail(email)) {
            return R.error(HttpStatusEnum.EMAIL_ERROR);
        }

        // 随机生成权限码
        String permissionCode = UUID.randomUUID().toString();

        // 存入redis，缓存10s
        redisTemplate.opsForValue().set(RedisConstant.EMAIL_REQUEST_VERIFY + email, permissionCode, RedisConstant.EXPIRE_ONE_MINUTE, TimeUnit.SECONDS);
        return R.ok().data("permissionCode", permissionCode);
    }

    @Override
    public R sendEmailCode(LoginParam loginParam) {
        if (loginParam == null) return R.error(HttpStatusEnum.PARAM_ILLEGAL);

        // 获取权限码和邮箱
        String email = loginParam.getEmail();
        String permissionCode = loginParam.getCode();
        // 参数校验
        if (StringUtils.isAnyBlank(email, permissionCode)) {
            return R.error(HttpStatusEnum.PARAM_ILLEGAL);
        }else if (!StringUtil.checkEmail(email)) {
            // 邮箱校验
            return R.error(HttpStatusEnum.EMAIL_ERROR);
        }else {
            // 权限码比对
            String rightCode = redisTemplate.opsForValue().get(RedisConstant.EMAIL_REQUEST_VERIFY + email);
            if (!permissionCode.equals(rightCode)) {
                // 不通过
                return R.error(HttpStatusEnum.ILLEGAL_OPERATION);
            }
        }

        // 全部通过

        // 随机生成6位数字验证码
        String code = StringUtil.randomSixCode();

        // 正文内容
        String content = "亲爱的用户：\n" +
                "您此次的验证码为：\n\n" +
                code + "\n\n" +
                "此验证码5分钟内有效，请立即进行下一步操作。 如非你本人操作，请忽略此邮件。\n" +
                "感谢您的使用！";

        // 发送验证码
        threadService.sendSimpleMail(email, "您此次的验证码为：" + code, content);
        // 丢入缓存，设置5分钟过期
        redisTemplate.opsForValue().set(RedisConstant.EMAIL + email, code, RedisConstant.EXPIRE_FIVE_MINUTE, TimeUnit.SECONDS);
        return R.ok();
    }
}
