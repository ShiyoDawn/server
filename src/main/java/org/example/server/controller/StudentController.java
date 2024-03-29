package org.example.server.controller;

import org.example.server.Service.StudentService;
import org.example.server.mapper.StudentMapper;
import org.example.server.payload.request.DataRequest;
import org.example.server.payload.response.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;//为什么要在controller里面注入mapper？应该是StudentService吧
    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudentList")
    public DataResponse getStudentList() {
        return DataResponse.success(studentService.getStudentMapList());
    }

    @PostMapping("/selectStudentByName")
    public DataResponse selectStudentByName(@RequestParam String student_name) {
        return DataResponse.success(studentService.findStudentsByName(student_name));
    }
}
