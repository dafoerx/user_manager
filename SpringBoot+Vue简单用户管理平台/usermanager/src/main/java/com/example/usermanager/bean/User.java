package com.example.usermanager.bean;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * FileName:    User
 * Author:      小袁
 * Date:        2022/5/6 13:23
 * Description: 用户表
 */
@Data
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    private String nickname;

    private String password;

    private String phone;

    private String sex;

    @TableField(value = "`describe`")
    private String describe;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}
