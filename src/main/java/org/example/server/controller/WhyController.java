package org.example.server.controller;

import org.example.server.payload.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WhyController {
    @PostMapping("/hello")
    public Result hello()
    {
        return new Result(0,null,"hellowhy");
    }
}
