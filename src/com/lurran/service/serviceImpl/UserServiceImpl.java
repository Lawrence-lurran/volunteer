package com.lurran.service.serviceImpl;

import com.lurran.dao.UserDao;
import com.lurran.dao.daoImpl.UserDaoImpl;
import com.lurran.pojos.User;
import com.lurran.service.UserService;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/6/18 6:55 下午
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username)!=null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
