package com.xiaoyuan.emaillogin.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * FileName:    User
 * Author:      小袁教程
 * Date:        2022/5/26 11:52
 * Description:
 */
@Data
@TableName("t_user")
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String email;

    private String password;

    private String salt;
}
