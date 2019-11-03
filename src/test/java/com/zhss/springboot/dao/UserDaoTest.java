package com.zhss.springboot.dao;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.Matchers.*;
import com.zhss.springboot.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.*;
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
@SpringBootTest
@Rollback(true)
@Transactional
public class UserDaoTest {

    @Autowired
    private UserDAO userDAO;


    @Test
    public void testListUsers() {
        User user = new User();
        user.setAge(11);
        user.setName("liao");
        userDAO.saveUser(user);
        List<User> users = new ArrayList<User>();
        users.add(user);
        List<User> users2 = userDAO.listUsers();
        users2.stream().forEach(userInScop -> {
            System.out.println(userInScop.getAge());
            System.out.println(userInScop.getName());
            System.out.println(userInScop.getId());
        });
        //assertEquals(users,users2);
    }

    @Test
    public void testGetUserById(){
        User user = new User();
        user.setAge(11);
        user.setName("测试用户");
        userDAO.saveUser(user);
        User userById = userDAO.getUserById(user.getId());
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
        long userById = userDAO.saveUser(user);
        assertEquals(userById,1);
    }

    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(1L);
        user.setAge(11);
        user.setName("测试用户");
        userDAO.saveUser(user);
        user.setName("liao2");
        long userById = userDAO.updateUser(user);
        assertThat(userById, is(greaterThan(0L)));
    }

    @Test
    public void testDeleteUser(){
        User user = new User();
        user.setId(1L);
        user.setAge(11);
        user.setName("测试用户");
        userDAO.saveUser(user);
        long userById = userDAO.removeUser(user.getId());
        assertEquals(userById,1L);
    }
}
