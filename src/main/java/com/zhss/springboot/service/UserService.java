package com.zhss.springboot.service;

import com.zhss.springboot.domain.User;

import java.util.List;

/**
 * 用户管理模块的service组件接口
 */
public interface UserService {

    List<User> listUsers();

    User getUserById(Long userId);

    long saveUser(User user);

    long updateUser(User user);

    long removeUser(Long userId);

}
