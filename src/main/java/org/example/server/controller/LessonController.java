package org.example.server.controller;

import org.example.server.Service.LessonService;
import org.example.server.payload.Result;
import org.example.server.payload.request.DataRequest;
import org.example.server.payload.response.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lesson")
@CrossOrigin
public class LessonController {
    @Autowired
    LessonService lessonService;
    //删除学生or老师，先删中间表
    @PostMapping("/updateHomework")
    public Result updateHomework(@RequestParam String homework,@RequestParam Integer id){
        return lessonService.updateHomework(homework,id);
    }
    @PostMapping("/selectAllHomeWorkFromStudent")
    public Result selectAllHomeWorkFromStudent(@RequestParam Integer id){
        return lessonService.selectAllHomeworkFromStudent(id);
    }
    //未测试
    @PostMapping("/selectAllHomeWorkFromTeacher")
    public Result selectAllHomeWorkFromTeacher(@RequestParam Integer id){
        return lessonService.selectAllHomeworkFromTeacher(id);
    }
    @PostMapping("/selectOneLessonFromStudent")
    public Result selectOneLessonFromStudent(Integer id,Integer student_id){
        return lessonService.selectOneLessonFromStudent(id,student_id);
    }
    @PostMapping("/selectOneLessonFromTeacher")
    public Result selectOneLessonFromTeacher(Integer id,Integer teacher_id){
        return lessonService.selectOneLessonFromTeacher(id,teacher_id);
    }
    @PostMapping("/updateHomeworkRating")
    public Result updateHomeworkRating(@RequestBody Map<String,Integer> map){
        return lessonService.updateHomeworkRating(map.get("homework_rating_id"),map.get("lesson_id"),map.get("studnet_id"));
    }
    @PostMapping("/selectHomeworkRatingStudent")
    public Result selectHomeworkRatingStudent(@RequestBody Map<String,Integer> map){
        return lessonService.selectHomeworkRatingStudent(map.get("lesson_id"),map.get("student_id"));
    }
    @PostMapping("/selectHomeworkRatingTeacher")
    public Result electHomeworkRatingTeacher(@RequestBody Map<String,Integer> map){
        return lessonService.selectHomeworkRatingTeacher(map.get("lesson_id"),map.get("teacher_id"));
    }
    @PostMapping("/selectLesson")
    public Result selectLesson(){
        return lessonService.selectLesson();
    }
    @PostMapping("/selectByCourseId")
    public Result selectByCourseId(@Valid @RequestBody DataRequest dataRequest){
        Integer id = dataRequest.getInteger("course_id");
        return lessonService.selectByCourseId(id);
    }
    @PostMapping("/addLesson")
    public Result addLesson(@Valid @RequestBody DataRequest dataRequest){
        List<List<String>> list = dataRequest.getList("lesson");
        List<List<String>> list1 = dataRequest.getList("course_id");
        return lessonService.addLesson(list1,list);
    }
    @PostMapping("/addStudentLesson")
    public Result addStudentLesson(@Valid @RequestBody DataRequest dataRequest){
        List<List<String>> list = dataRequest.getList("lesson");
        return lessonService.addStudentLesson(list);
    }
    @PostMapping("/updateInfo")
    public Result updateInfo(@Valid @RequestBody DataRequest dataRequest){
        Integer course_id = dataRequest.getInteger("course_id");
        Integer week = dataRequest.getInteger("week");
        Integer week_time = dataRequest.getInteger("week_time");
        Integer time_sort = dataRequest.getInteger("time_sort");
        String notes = dataRequest.getString("notes");
        String room = dataRequest.getString("room");
        String homework = dataRequest.getString("homework");
        String ppt = dataRequest.getString("ppt");
        String ddl = dataRequest.getString("ddl");
        return lessonService.updateInfo(course_id,week,week_time,time_sort,notes,room,homework,ppt,ddl);
    }
    @PostMapping("/deleteLesson")
    public Result deleteLesson(@Valid @RequestBody DataRequest dataRequest){
        Integer course_id = dataRequest.getInteger("course_id");
        Integer week = dataRequest.getInteger("week");
        Integer week_time = dataRequest.getInteger("week_time");
        Integer time_sort = dataRequest.getInteger("time_sort");
        return lessonService.deleteLesson(course_id,week,week_time,time_sort);
    }
    @PostMapping("/selectSpecific")
    public Result selectSpecific(@Valid @RequestBody DataRequest dataRequest){
        Integer course_id = dataRequest.getInteger("course_id");
        Integer week = dataRequest.getInteger("week");
        Integer week_time = dataRequest.getInteger("week_time");
        Integer time_sort = dataRequest.getInteger("time_sort");
        return lessonService.selectSpecific(course_id,week,week_time,time_sort);
    }


}
