package org.example.server.controller;

import org.example.server.Service.StudentClassificationService;
import org.example.server.payload.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studentClassification")
public class StudentClassificationController {
    @Autowired
    private StudentClassificationService studentClassificationService;

    @PostMapping("/getStudentClassification")
    public Result getStudentClassification() {
        return Result.success(studentClassificationService.getStudentClassification());
    }
}
