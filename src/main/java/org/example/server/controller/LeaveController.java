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
import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

@RestController
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    @PostMapping("/insertLeave")
    public Result insertLeave(@Valid @RequestBody DataRequest dataRequest){
        String student_num=dataRequest.getString("student_num");
        String student_name=dataRequest.getString("student_name");
        String leave_type=dataRequest.getString("leave_type");
        String leave_reason=dataRequest.getString("leave_reason");
        String destination=dataRequest.getString("destination");
        String time=dataRequest.getString("time");
        String status=dataRequest.getString("status");
        String age=dataRequest.getString("age");
        String institute=dataRequest.getString("institute");
        String major=dataRequest.getString("major");
        String instructor_name=dataRequest.getString("instructor_name");
        String instructor_tele=dataRequest.getString("instructor_tele");
        String leave_detailed_reason=dataRequest.getString("leave_detailed_reason");
        String start_time=dataRequest.getString("start_time");
        String end_time=dataRequest.getString("end_time");
        String student_tele=dataRequest.getString("student_tele");
        return leaveService.insertLeave(student_num,student_name,leave_type,leave_reason,destination,time,status,age,institute,major,instructor_name,instructor_tele,leave_detailed_reason,start_time,end_time,student_tele);
    }

    @PostMapping("/updateStatus")
    public Result updateStatus(@Valid @RequestBody DataRequest dataRequest){
        String status=dataRequest.getString("status");
        String student_num=dataRequest.getString("student_num");
        String student_name=dataRequest.getString("student_name");
        String institute=dataRequest.getString("institute");
        String major=dataRequest.getString("major");
        String instructor_name=dataRequest.getString("instructor_name");
        String instructor_tele=dataRequest.getString("instructor_tele");
        String leave_detailed_reason=dataRequest.getString("leave_detailed_reason");
        String start_time=dataRequest.getString("start_time");
        String end_time=dataRequest.getString("end_time");
        String student_tele=dataRequest.getString("student_tele");
        String leave_reason=dataRequest.getString("leave_reason");
        String leave_type=dataRequest.getString("leave_type");
        String destination=dataRequest.getString("destination");
        return leaveService.updateStatus(status,student_num,student_name,institute,major,instructor_name,instructor_tele,leave_detailed_reason,start_time,end_time,student_tele,leave_reason,leave_type,destination);
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
        return leaveService.selectByStudentName(student_name);
    }
    @PostMapping("/getHomework")
    public Result getPhoto(@RequestBody DataRequest dataRequest) {
        String person_num = dataRequest.getString("person_num");
        File file=new File("src/main/homework/"+person_num+".jpg");
        if(!file.exists()) {
            return Result.error(-1,"文件不存在");
        }
        int len = (int) file.length();
        byte data[] = new byte[len];
        FileInputStream in = null;
        String imgstr=null;
        try {
            in = new FileInputStream(file);
            in.read(data);
            in.close();
            imgstr=new String(Base64.getEncoder().encode(data));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Result.success(imgstr);
    }
}
