package org.example.server.controller;

import org.example.server.Service.LessonService;
import org.example.server.payload.Result;
import org.example.server.payload.request.DataRequest;
import org.example.server.payload.response.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lesson")
@CrossOrigin
public class LessonController {
    @Autowired
    LessonService lessonService;
    //删除学生or老师，先删中间表
    @PostMapping("/updateHomework1")
    public Result updateHomework1(@RequestParam String homework,@RequestParam Integer id){
        return lessonService.updateHomework1(homework,id);
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
        Integer student_id = dataRequest.getInteger("student_id");
        Integer lesson_id = dataRequest.getInteger("lesson_id");
        return lessonService.addStudentLesson(student_id,lesson_id);
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
    @PostMapping("/selectStudentLesson")
    public Result selectStudentLesson(@Valid @RequestBody DataRequest dataRequest){
        Integer student_id = dataRequest.getInteger("student_id");
        Integer lesson_id = dataRequest.getInteger("lesson_id");
        return lessonService.selectStudentLesson(student_id,lesson_id);
    }
    @PostMapping("/getPhoto")
    public Result getPhoto(@RequestBody DataRequest dataRequest) {
        String student_id = dataRequest.getString("student_id");
        String lesson_id = dataRequest.getString("lesson_id");
        File file=new File("src/main/homework/"+ student_id + "a" + lesson_id + "a" + "1" +".jpg");
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
    @PostMapping("/updateHomework")
    public Result updateHomework(@Valid @RequestBody DataRequest dataRequest){
        String statusHome = dataRequest.getString("statusHome");
        String time = dataRequest.getString("time");
        Integer student_id = dataRequest.getInteger("student_id");
        Integer lesson_id = dataRequest.getInteger("lesson_id");
        return lessonService.updateHomework(statusHome,time,student_id,lesson_id);
    }
    @PostMapping("/updateHomeworkRank")
    public Result updateHomeworkRank(@Valid @RequestBody DataRequest dataRequest){
        String homework_rank = dataRequest.getString("homework_rank");
        Integer student_id = dataRequest.getInteger("student_id");
        Integer lesson_id = dataRequest.getInteger("lesson_id");
        return lessonService.updateHomeworkRang(homework_rank,student_id,lesson_id);
    }


}
