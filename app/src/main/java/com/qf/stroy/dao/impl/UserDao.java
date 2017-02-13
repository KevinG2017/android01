package com.qf.stroy.dao.impl;

import com.qf.stroy.dao.IUserDao;
import com.qf.stroy.entity.User;
import com.qf.stroy.utils.HttpUtils;

/**
 * user接口的实现
 */
public class UserDao implements IUserDao {
    @Override
    public boolean login(String url, User user) {
        //具体的实现
        String result=HttpUtils.doGet();
        //返回来这个数据只有可能是两种结构  JSON  XML

        //解析数据....
        return true;
    }

    @Override
    public boolean register(String url, User user) {
        //具体的实现
        return false;
    }
}
