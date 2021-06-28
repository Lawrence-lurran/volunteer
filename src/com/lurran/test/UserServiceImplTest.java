package com.lurran.test;

import com.lurran.pojos.User;
import com.lurran.service.UserService;
import com.lurran.service.serviceImpl.UserServiceImpl;
import com.lurran.util.JDBCUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/6/25 8:45 下午
 */
public class UserServiceImplTest {
    UserService userService=new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User("UserServiceImplTest","UserServiceImplTest"));
        JDBCUtils.commitAndClose();
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User("UserServiceImplTest", "UserServiceImplTest")));
        JDBCUtils.commitAndClose();
    }

    @Test
    public void existsUsername() {
        System.out.println(userService.existsUsername("UserServiceImplTest"));
        JDBCUtils.commitAndClose();
    }
}
