package org.example.server.controller;

import org.example.server.Service.StudentService;
import org.example.server.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;//为什么要在controller里面注入mapper？应该是StudentService吧
    @Autowired
    private StudentService studentService;
}
