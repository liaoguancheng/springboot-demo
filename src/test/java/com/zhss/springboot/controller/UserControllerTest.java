package com.zhss.springboot.controller;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhss.springboot.domain.User;
import com.zhss.springboot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;



//@SpringBootTest(classes = {Application.class})
@WebMvcTest(UserController.class)
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @Test
    public void testListUsers(){
        List<User> users = new ArrayList<User>();
        User user = new User();
        user.setId(1L);
        user.setAge(11);
        user.setName("liao");
        users.add(user);
        when(userService.listUsers()).thenReturn(users);
        try {
            mockMvc.perform(get("/user/"))
                    .andExpect(content().json(JSONArray.toJSONString(users)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testgetUserById(){

        long userId = 1L;
        User user = new User();
        user.setId(1L);
        user.setAge(11);
        user.setName("liao");
        when(userService.getUserById(userId)).thenReturn(user);
        try {
            mockMvc.perform(get("/user/{id}",userId))
                    .andExpect(content().json(JSONArray.toJSONString(user)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testSaveUser(){

        User user = new User();
        user.setAge(11);
        user.setName("liao");
        when(userService.saveUser(user)).thenReturn(1L);
        try {
            mockMvc.perform(post("/user/").contentType("application/json").content(JSONObject.toJSONString(user)))
                    .andExpect(content().string("success"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateUser() {

        User user = new User();
        user.setId(1L);
        user.setAge(11);
        user.setName("liao");
        when(userService.updateUser(user)).thenReturn(2L);
        try {
            mockMvc.perform(put("/user/").contentType("application/json").content(JSONObject.toJSONString(user)))
                    .andExpect(content().string("2"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRemoveUser() {

        Long userId = 1L;
        when(userService.removeUser(userId)).thenReturn(1L);
        try {
            mockMvc.perform(delete("/user/{id}",userId))
                    .andExpect(content().string("1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
