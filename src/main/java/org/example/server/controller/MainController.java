package org.example.server.controller;

import org.example.server.Service.UserService;
import org.example.server.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class MainController {
    @Autowired
    private UserService userService;

    @PostMapping("/test2")
    public String test2 (){
        userService.insert();
        return "已添加";
    }

    @PostMapping("/test1")
    public List<User> test1() {
        return userService.delete0();
    }
}
