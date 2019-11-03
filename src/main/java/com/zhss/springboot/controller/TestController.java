package com.zhss.springboot.controller;

import com.zhss.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RestTemplateBuilder templateBuilder;

    @RequestMapping("/hello/{name}")
    public String sayHello(@PathVariable("name") String name){
        return "hello,this is demo " + name;
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") long id) {

        RestTemplate restTemplate = templateBuilder.build();
        String url = "http://localhost:8080/user/"+id;
        //Map<String, Long> map = new HashMap<String, Long>();
        //map.put("id", id);
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }
}
