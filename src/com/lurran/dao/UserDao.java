package com.lurran.dao;

import com.lurran.pojos.User;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/6/18 6:53 下午
 */
public interface UserDao {
    /**
     * 保存用户信息
     * @param user 用户对象
     */
    void saveUser(User user);

    
}
