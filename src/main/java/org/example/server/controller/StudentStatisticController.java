package org.example.server.controller;

import org.example.server.Service.StudentStatisticService;
import org.example.server.payload.Result;
import org.example.server.payload.request.DataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/studentStatistic")
public class StudentStatisticController {
    @Autowired
    private StudentStatisticService studentStatisticService;

    @PostMapping("/getStudentStatistic")
    public Result getStudentStatistic(@Valid @RequestBody DataRequest dataRequest) {
        return Result.success(studentStatisticService.getStudentStatistic(dataRequest.getString("person_num")));
    }
}
