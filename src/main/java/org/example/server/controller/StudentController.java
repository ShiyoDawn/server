package org.example.server.controller;

import org.example.server.Service.StudentService;
import org.example.server.mapper.StudentMapper;
import org.example.server.payload.request.DataRequest;
import org.example.server.payload.response.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;//为什么要在controller里面注入mapper？应该是StudentService吧
    @Autowired
    private StudentService studentService;
    @PostMapping("/getStudentList")
    public DataResponse getStudentList(@Valid @RequestBody DataRequest dataRequest){
        return DataResponse.success(studentService.getStudentMapList());
    }
}
