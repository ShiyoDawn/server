package org.example.server.controller;

import org.example.server.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/student")
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;
}
