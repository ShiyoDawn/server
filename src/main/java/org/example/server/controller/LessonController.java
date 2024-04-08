package org.example.server.controller;

import org.example.server.Service.LessonService;
import org.example.server.payload.response.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/lesson")
@CrossOrigin
public class LessonController {
    @Autowired
    LessonService lessonService;
    //删除学生or老师，先删中间表
    @PostMapping("/updateHomework")
    public DataResponse updateHomework(@RequestParam String homework,@RequestParam Integer id){
        return lessonService.updateHomework(homework,id);
    }
    @PostMapping("/selectAllHomeWorkFromStudent")
    public DataResponse selectAllHomeWorkFromStudent(@RequestParam Integer id){
        return lessonService.selectAllHomeworkFromStudent(id);
    }
    //未测试
    @PostMapping("/selectAllHomeWorkFromTeacher")
    public DataResponse selectAllHomeWorkFromTeacher(@RequestParam Integer id){
        return lessonService.selectAllHomeworkFromTeacher(id);
    }
    @PostMapping("/selectOneLessonFromStudent")
    public DataResponse selectOneLessonFromStudent(Integer id,Integer student_id){
        return lessonService.selectOneLessonFromStudent(id,student_id);
    }
    @PostMapping("/selectOneLessonFromTeacher")
    public DataResponse selectOneLessonFromTeacher(Integer id,Integer teacher_id){
        return lessonService.selectOneLessonFromTeacher(id,teacher_id);
    }
    @PostMapping("/updateHomeworkRating")
    public DataResponse updateHomeworkRating(@RequestBody Map<String,Integer> map){
        return lessonService.updateHomeworkRating(map.get("homework_rating_id"),map.get("lesson_id"),map.get("studnet_id"));
    }
    @PostMapping("/selectHomeworkRatingStudent")
    public DataResponse selectHomeworkRatingStudent(@RequestBody Map<String,Integer> map){
        return lessonService.selectHomeworkRatingStudent(map.get("lesson_id"),map.get("student_id"));
    }
    @PostMapping("/selectHomeworkRatingTeacher")
    public DataResponse electHomeworkRatingTeacher(@RequestBody Map<String,Integer> map){
        return lessonService.selectHomeworkRatingTeacher(map.get("lesson_id"),map.get("teacher_id"));
    }

}
