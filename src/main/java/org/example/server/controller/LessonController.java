package org.example.server.controller;

import org.example.server.Service.LessonService;
import org.example.server.payload.response.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
