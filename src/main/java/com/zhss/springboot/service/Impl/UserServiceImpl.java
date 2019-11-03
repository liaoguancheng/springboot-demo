package com.zhss.springboot.service.Impl;

import com.zhss.springboot.dao.UserDAO;
import com.zhss.springboot.domain.User;
import com.zhss.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    @Override
    public User getUserById(Long userId) {

        return userDAO.getUserById(userId);
    }

    @Override
    public long saveUser(User user) {

       return  userDAO.saveUser(user);
    }

    @Override
    public long updateUser(User user) {

        return userDAO.updateUser(user);
    }

    @Override
    public long removeUser(Long userId) {

        return userDAO.removeUser(userId);
    }
}
