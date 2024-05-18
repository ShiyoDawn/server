package org.example.server.controller;



import org.example.server.Service.ActivityService;
import org.example.server.payload.Result;
import org.example.server.payload.request.DataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @PostMapping("/getActivityList")
    public Result getActivityList(){
        return activityService.getActivityList();
    }

    @PostMapping("/insertActivity")
    public Result insertActivity(@Valid @RequestBody DataRequest dataRequest){
        String student_num=dataRequest.getString("student_num");
        String student_name=dataRequest.getString("student_name");
        String activity_name=dataRequest.getString("activity_name");
        String activity_type=dataRequest.getString("activity_type");
        String date=dataRequest.getString("date");
        String score=dataRequest.getString("score");
        return activityService.insertActivity(student_num,student_name,activity_name,activity_type,date,score);
    }

    @PostMapping("/deleteActivity")
    public Result deleteActivity(@Valid @RequestBody DataRequest dataRequest){
        String student_num=dataRequest.getString("student_num");
        String student_name=dataRequest.getString("student_name");
        String activity_name=dataRequest.getString("activity_name");
        String activity_type=dataRequest.getString("activity_type");
        String date=dataRequest.getString("date");
        String score=dataRequest.getString("score");
        return activityService.deleteActivity(student_num,student_name,activity_name,activity_type,date,score);
    }

    @PostMapping("selectByStudentNum")
    public Result selectByStudentNum(@Valid @RequestBody DataRequest dataRequest){
        String student_num=dataRequest.getString("student_num");
        return activityService.selectByStudentNum(student_num);
    }

}
