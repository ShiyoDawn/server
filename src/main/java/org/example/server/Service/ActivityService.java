package org.example.server.Service;

import org.example.server.mapper.ActivityMapper;
import org.example.server.mapper.PersonMapper;
import org.example.server.payload.Result;
import org.example.server.pojo.Activity;
import org.example.server.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private PersonMapper personMapper;
    public Result getActivityList() {
        List<Activity> activityList=activityMapper.selectAll();
        List<Map<String, String>> dataList = new ArrayList();
        Map<String, String> map = new HashMap<>();
        for (Activity activity:activityList) {
            map = new HashMap();
            Person person=activity.getPerson();
            map.put("id",activity.getId()+"");
            map.put("student_num",person.getPerson_num());
            map.put("student_name",person.getPerson_name());
            map.put("activity_name",activity.getActivity_name());
            map.put("activity_type",activity.getActivity_type());
            map.put("date",activity.getDate());
            map.put("score",activity.getScore());
            dataList.add(map);
        }
        return Result.success(dataList);
    }

    public Result insertActivity(String student_num, String student_name, String activity_name, String activity_type, String date, String score) {
        Person person=personMapper.selectByPersonNum(student_num);
        Activity activity=new Activity();
        activity.setStudent_num(person.getPerson_num());
        activity.setStudent_name(person.getPerson_name());
        activity.setPerson(person);
        activity.setActivity_name(activity_name);
        activity.setActivity_type(activity_type);
        activity.setDate(date);
        activity.setScore(score);
        System.out.println(activity);
        activityMapper.insertActivity(activity);
        return Result.ok();
    }

    public Result deleteActivity(String student_num, String student_name, String activity_name, String activity_type, String date, String score) {
        activityMapper.deleteActivity(student_num,student_name,activity_name,activity_type,date,score);
        return Result.ok();
    }

    public Result selectByStudentNum(String student_num) {
        List<Activity> activityList=activityMapper.selectByStudentNum(student_num);
        List<Map<String, String>> dataList = new ArrayList();
        Map<String, String> map = new HashMap<>();
        Person person=personMapper.selectByPersonNum(student_num);
        for (Activity activity:activityList) {
            map = new HashMap();
            map.put("id",activity.getId()+"");
            map.put("student_num",person.getPerson_num());
            map.put("student_name",person.getPerson_name());
            map.put("activity_name",activity.getActivity_name());
            map.put("activity_type",activity.getActivity_type());
            map.put("date",activity.getDate());
            map.put("score",activity.getScore());
            dataList.add(map);
        }
        return Result.success(dataList);
    }
}
