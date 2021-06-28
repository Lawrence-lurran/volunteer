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
     * 根据用户名查询用户信息
     * @param username  用户名
     * @return 如果返回null，说明没有这个用户，反之亦然
     */
    public User queryUserByUsername(String username);

    /**
     * 保存用户信息
     * @param user 要保存的user对象
     * @return 如果返回-1说明执行失败，其他表示影响的行数
     */
    public int saveUser(User user);
    /**
     * 根据用户名和密码查询用户信息
     * @param username  用户名
     * @param password  密码
     * @return 如果返回null，说明没有这个用户，反之亦然
     */
    public User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 通过ID更新图书
     * @param user
     * @return
     */
    int updateUser(User user);
}
