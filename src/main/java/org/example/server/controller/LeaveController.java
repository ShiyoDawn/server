package org.example.server.controller;


import org.example.server.Service.LeaveService;
import org.example.server.payload.Result;
import org.example.server.payload.request.DataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    @PostMapping("/insertLeave")
    public Result insert(@Valid @RequestBody DataRequest dataRequest){
        String student_num=dataRequest.getString("student_num");
        String student_name=dataRequest.getString("student_name");
        String leave_type=dataRequest.getString("leave_type");
        String leave_reason=dataRequest.getString("leave_reason");
        String destination=dataRequest.getString("destination");
        String time=dataRequest.getString("time");
        String status=dataRequest.getString("status");
        return leaveService.insertLeave(student_num,student_name,leave_type,leave_reason,destination,time,status);
    }

    @PostMapping("/getLeaveList")
    public Result getLeaveList(){
        return leaveService.getLeaveList();
    }

    @PostMapping("/selectByStudentNum")
    public Result selectByStudentNum(@Valid @RequestBody DataRequest dataRequest){
        String student_num=dataRequest.getString("student_num");
        return leaveService.selectByStudentNum(student_num);
    }

    @PostMapping("/selectByStudentName")
    public Result selectByStudentName(@Valid @RequestBody DataRequest dataRequest){
        String student_name=dataRequest.getString("student_name");
        return leaveService.selectByStudentNum(student_name);
    }
}
