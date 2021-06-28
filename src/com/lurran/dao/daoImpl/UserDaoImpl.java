package com.lurran.dao.daoImpl;

import com.lurran.dao.UserDao;
import com.lurran.pojos.User;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/6/18 6:55 下午
 */
public class UserDaoImpl extends BaseDao implements UserDao{
    @Override
    public User queryUserByUsername(String username) {
        String sql="select userId,username,password from v_user where username=?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public int saveUser(User user) {
        String sql="insert into v_user(username, password) VALUES (?,?)";
        return update(sql,user.getUsername(),user.getPassword());
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql="select userId ,username,password from v_user where username=? and password=?";
        return queryForOne(User.class, sql, username,password);
    }

    @Override
    public int updateUser(User user) {

        String sql="update v_user set username=? password=? where userId=?";
        return update(sql,user.getUsername(),user.getPassword());
    }
}
