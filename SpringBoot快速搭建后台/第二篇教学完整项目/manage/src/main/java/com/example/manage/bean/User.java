package com.example.manage.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Date;


/**
 * FileName:    User
 * Author:      Yuan-Programmer
 * Date:        2021/12/10 21:42
 * Description:
 */
@Entity(name = "t_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String nickname;
    private String password;

    private Date createdTime; // 对应数据库表中的 created_time 字段
    private Date validUntil; // 对应数据库表中的 valid_until 字段
    private boolean isWhiteList; // 对应数据库表中的 is_white_list 字段
}
