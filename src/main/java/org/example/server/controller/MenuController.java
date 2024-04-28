package org.example.server.controller;

import org.example.server.mapper.MenuMapper;
import org.example.server.payload.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuMapper menuMapper;

    @PostMapping("/get")
    public Result getMenu(@RequestBody String type) {
        System.out.println(type);
        return new Result(200,menuMapper.selectByAccess(type),"ok");
    }
}
