package com.example.usermanager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.usermanager.bean.User;
import com.example.usermanager.mapper.UserMapper;
import com.example.usermanager.service.UserService;
import com.example.usermanager.vo.QueryParam;
import com.example.usermanager.vo.R;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FileName:    UserServiceImpl
 * Author:      小袁
 * Date:        2022/5/6 13:27
 * Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public R insertUser(User user) {
        if (user == null) return R.error().message("参数错误");

        String username = user.getUsername();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("id");
        wrapper.eq("username", username);
        wrapper.last("limit 1");
        if (this.baseMapper.selectOne(wrapper) != null) return R.error().message("用户名已存在");

        return this.baseMapper.insert(user) == 0 ? R.error().message("添加失败") : R.ok();
    }

    @Override
    public R deleteUserById(Integer id) {
        if (id == null || id <= 0) return R.error().message("参数错误");
        return this.baseMapper.deleteById(id) == 0 ? R.error().message("删除失败") : R.ok();
    }

    @Override
    public R deleteUserMore(List<String> ids) {
        return this.baseMapper.deleteBatchIds(ids) == 0 ? R.error().message("删除失败") : R.ok();
    }

    @Override
    public R updateUserById(User user) {
        if (user == null || user.getId() == null || user.getId() <= 0) return R.error().message("参数错误");
        return this.baseMapper.updateById(user) == 0 ? R.error().message("修改失败" ) : R.ok();
    }

    @Override
    public R listUserPage(int index, int size, QueryParam queryParam) {
        if (index <= 0 || size <= 0 || size > 20) return R.error().message("参数错误");
        // 构建分页对象
        Page<User> page = new Page<>(index, size);
        // 查询
        IPage<User> iPage = this.baseMapper.listUserPage(page, queryParam);

        return R.ok().data("userList", iPage.getRecords()).data("total", iPage.getTotal());
    }

    @Override
    public R getUserInfo(String id) {
        return R.ok().data("user", this.baseMapper.selectById(id));
    }
}
