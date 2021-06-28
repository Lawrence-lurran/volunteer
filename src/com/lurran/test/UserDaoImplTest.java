package com.lurran.test;

import com.lurran.dao.UserDao;
import com.lurran.dao.daoImpl.UserDaoImpl;
import com.lurran.pojos.User;
import com.lurran.util.JDBCUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/6/25 8:46 下午
 */
public class UserDaoImplTest {
    UserDao userDao=new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        System.out.println(userDao.queryUserByUsername("lurran"));
        JDBCUtils.commitAndClose();
    }

    @Test
    public void saveUser() {
        int i = userDao.saveUser(new User("luran", "c1231230"));
        System.out.println(i);
        JDBCUtils.commitAndClose();
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        System.out.println(userDao.queryUserByUsernameAndPassword("test", "test"));
        System.out.println(userDao.queryUserByUsernameAndPassword("luran", "c1231230"));
        System.out.println(userDao.queryUserByUsernameAndPassword("luran", "c123123"));
    }
}
