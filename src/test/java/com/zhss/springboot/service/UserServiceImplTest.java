package com.zhss.springboot.service;


import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import com.zhss.springboot.Application;
import com.zhss.springboot.dao.UserDAO;
import com.zhss.springboot.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import sun.font.TrueTypeFont;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 用户管理模块的单元测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@Rollback(true)
@Transactional
public class UserServiceImplTest {

    @Autowired
    private UserService userService;
    @MockBean
    private UserDAO userDAO;


    @Test
    public void testListUsers() {
        List<User> users = new ArrayList<User>();
        User user = new User();
        user.setId(1L);
        user.setAge(11);
        user.setName("liao");
        users.add(user);
        when(userDAO.listUsers()).thenReturn(users);
        List<User> users2 = userService.listUsers();
        users2.stream().forEach(userInScop -> {
            System.out.println(userInScop.getAge());
            System.out.println(userInScop.getName());
            System.out.println(userInScop.getId());
        });
        assertEquals(users,users2);
    }

    @Test
    public void testGetUserById(){
        User user = new User();
        user.setId(1L);
        user.setAge(11);
        user.setName("测试用户");
        when(userDAO.getUserById(1L)).thenReturn(user);
        User userById = userService.getUserById(1L);
        List<User> users = Arrays.asList(userById);
        users.stream().forEach(user1 -> {
            System.out.println(user1.getId());
            System.out.println(user1.getAge());
            System.out.println(user1.getName());
        });
        assertEquals(userById,user);
    }

    @Test
    public void testSaveUser(){
        User user = new User();
        user.setId(1L);
        user.setAge(11);
        user.setName("测试用户");
        when(userDAO.saveUser(user)).thenReturn(1L);
        long userById = userService.saveUser(user);
        assertEquals(userById,1);
    }

    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(1L);
        user.setAge(11);
        user.setName("测试用户");
        when(userDAO.updateUser(user)).thenReturn(1L);
        long userById = userService.updateUser(user);
        assertEquals(userById,1);
    }

    @Test
    public void testDeleteUser(){
       Long userId = 1L;
        when(userDAO.removeUser(userId)).thenReturn(1L);
        long userById = userService.removeUser(userId);
        assertEquals(userById,1);
    }
}
