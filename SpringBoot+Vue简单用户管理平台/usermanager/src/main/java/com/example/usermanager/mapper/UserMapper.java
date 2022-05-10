package com.example.usermanager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.usermanager.bean.User;
import com.example.usermanager.vo.QueryParam;
import org.springframework.stereotype.Repository;

/**
 * FileName:    UserMapper
 * Author:      小袁
 * Date:        2022/5/6 13:26
 * Description:
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    IPage<User> listUserPage(Page<User> page, QueryParam queryParam);
}
