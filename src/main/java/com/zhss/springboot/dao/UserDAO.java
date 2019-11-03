package com.zhss.springboot.dao;

import com.zhss.springboot.domain.User;

import java.util.List;



public interface UserDAO {
    List<User> listUsers();
    
    User getUserById(Long userId);

    long saveUser(User user);
    
    long updateUser(User user);
    
    long removeUser(Long userId);
    
}
