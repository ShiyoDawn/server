package org.example.server.controller;

import org.example.server.Service.UserService;
import org.example.server.payload.Result;
import org.example.server.payload.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest){
        return userService.loginReq(loginRequest.getUserName(), loginRequest.getPassword());
    }
}
