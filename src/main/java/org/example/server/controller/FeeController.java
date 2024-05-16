package org.example.server.controller;


import org.example.server.Service.FeeService;
import org.example.server.payload.Result;
import org.example.server.payload.request.DataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/fee")
public class FeeController {
    @Autowired
    private FeeService feeService;

    @PostMapping("/insertFee")
    public Result insertFee(@Valid @RequestBody DataRequest dataRequest){
        Integer id=dataRequest.getInteger("id");
        String student_name=dataRequest.getString("student_name");
        String student_num=dataRequest.getString("student_num");
        String date=dataRequest.getString("date");
        String money=dataRequest.getString("money");
        String activity=dataRequest.getString("activity");
        String activity_detail=dataRequest.getString("activity_detail");
        System.out.println(dataRequest.getData());
        return feeService.insertFee(id,student_num,student_name,date,money,activity,activity_detail);
    }

    @PostMapping("/deleteFee")
    public Result deleteFee(@Valid @RequestBody DataRequest dataRequest){
        String student_num=dataRequest.getString("student_num");
        String student_name=dataRequest.getString("student_name");
        String date=dataRequest.getString("date");
        String money=dataRequest.getString("money");
        String activity=dataRequest.getString("activity");
        String activity_detail=dataRequest.getString("activity_detail");
        return feeService.deleteFee(student_num,student_name,date,money,activity,activity_detail);
    }

    @PostMapping("/getFeeList")
    public Result getFeeList(){
        return feeService.getFeeList();
    }

}
