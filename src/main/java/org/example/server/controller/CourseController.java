package org.example.server.controller;

import org.example.server.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController {
    @Autowired
    CourseService courseService;
    @PostMapping("/updateInfo")
    public String updateInfo(@RequestParam Integer id, @RequestParam String course_name, @RequestParam Double credit, @RequestParam Integer num, @RequestParam Integer course_type_id, @RequestParam Integer pre_course_id, @RequestParam String book, @RequestParam String extracurricular){
        return courseService.updateInfo(id, course_name,credit,num,course_type_id,pre_course_id,book,extracurricular);
    }
}
