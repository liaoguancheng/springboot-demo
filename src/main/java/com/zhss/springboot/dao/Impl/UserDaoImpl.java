package com.zhss.springboot.dao.Impl;

import com.zhss.springboot.dao.UserDAO;
import com.zhss.springboot.domain.User;
import com.zhss.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO {


    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUsers() {
        return userMapper.listUsers();
    }

    @Override
    public User getUserById(Long userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public long saveUser(User user) {

        return userMapper.saveUser(user);
    }

    @Override
    public long updateUser(User user) {

       return userMapper.updateUser(user);
    }

    @Override
    public long removeUser(Long userId) {

        return userMapper.removeUser(userId);
    }
}
