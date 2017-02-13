package com.qf.stroy.dao;

import com.qf.stroy.entity.User;

/**
 * Created by apple on 2017/1/16.
 * 这个你记住：所有跟用户有关的服务器的操作都放置在这个里面
 */
public interface IUserDao {
    /**
     * 登陆
     * @param url:服务器地址
     * @param user：用户对象
     * @return
     */
    public boolean login(String url, User user);

    /**
     * 注册
     * @param url:地址
     * @param user：用户
     * @return
     */
    public boolean register(String url,User user);
}
