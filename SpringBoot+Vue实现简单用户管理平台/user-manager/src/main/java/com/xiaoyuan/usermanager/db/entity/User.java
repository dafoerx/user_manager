package com.xiaoyuan.usermanager.db.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * FileName:    User
 * Author:      小袁教程
 * Date:        2022/5/12 23:18
 * Description:
 */
@Data
public class User {

    // 主键ID
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    // 用户名
    private String username;

    // 昵称
    private String nickname;

    // 密码
    private String password;

    // 号码
    private String phone;

    // 性别
    private Character sex;

    // 描述
    @TableField(value = "`describe`")
    private String describe;

    // 创建时间
    @TableField(fill = FieldFill.INSERT) // insert操作时自动注入时间
    private Date gmtCreate;
}
