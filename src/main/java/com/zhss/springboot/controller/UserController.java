package com.zhss.springboot.controller;

import com.zhss.springboot.domain.User;
import com.zhss.springboot.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("/user")
public class UserController {

    private Log log = LogFactory.getLog(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> listUsers() {
        log.info("查询所有用户信息");
        return userService.listUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/")
    public String saveUser(
            @RequestBody@Validated(User.Save.class) User user,
            BindingResult result) {
        if(result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            FieldError error = (FieldError)errors.get(0);
            return error.getObjectName() + ","
                    + error.getField() + ","
                    + error.getDefaultMessage();
        }
        userService.saveUser(user);
        return "success";

    }

    @PutMapping("/")
    public long updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public long removeUser(@PathVariable long id) {
       return  userService.removeUser(id);
    }

}
