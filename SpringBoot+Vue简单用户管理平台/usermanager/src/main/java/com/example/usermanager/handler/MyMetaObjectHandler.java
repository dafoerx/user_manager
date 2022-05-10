package com.example.usermanager.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * FileName:    MyMataObjectHandler
 * Author:      小袁
 * Date:        2022/4/16 11:30
 * Description:
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 新增数据执行
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 配置初始创建时间
        this.setFieldValByName("createTime", new Date(), metaObject);
    }

    /**
     * 修改数据执行
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
    }
}
