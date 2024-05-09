package org.example.server.controller;

import org.example.server.Service.UserService;
import org.example.server.payload.request.DataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/updatePassword")
    public void updatePassword(@Valid @RequestBody DataRequest dataRequest) {
        String person_num = dataRequest.getString("person_num");
        String password = dataRequest.getString("password");
        userService.updatePassword(person_num, password);
    }
}
