package com.lurran.service;

import com.lurran.pojos.User;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/6/18 6:54 下午
 */
public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登陆
     * @param user
     * @return 如果返回null说明失败，返回有值登陆成功
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return 返回true表示用户名已经存在，返回false表示用户名可用
     */
    public boolean existsUsername(String username);

    /**
     * 通过ID更新用户信息
     * @param user
     */
    void updateUser(User user);
}
