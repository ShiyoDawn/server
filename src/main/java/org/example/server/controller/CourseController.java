
package org.example.server.controller;

import org.example.server.Service.CourseService;
import org.example.server.payload.Result;
import org.example.server.payload.response.DataResponse;
import org.example.server.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController {
    @Autowired
    private CourseService courseService;
    @PostMapping("/updateInfo")
    public DataResponse updateInfo(@RequestParam Integer id, @RequestParam String course_name, @RequestParam Double credit, @RequestParam Integer num, @RequestParam Integer course_type_id, @RequestParam Integer pre_course_id, @RequestParam String book, @RequestParam String extracurricular) {
        return courseService.updateInfo(id, course_name, credit, num, course_type_id, pre_course_id, book, extracurricular);
    }
    @PostMapping("/selectInfo")
    public DataResponse selectInfo(@RequestParam Integer id){
        return courseService.selectInfo(id);
    }
    @PostMapping("/addCourse")
    public DataResponse addCourse(@RequestParam String course_name, @RequestParam Double credit, @RequestParam Integer num, @RequestParam Integer course_type_id, @RequestParam Integer pre_course_id, @RequestParam String book, @RequestParam String extracurricular){
        return courseService.addCourse(course_name, credit, num, course_type_id, pre_course_id, book, extracurricular);
    }
    @PostMapping("/deleteCourseById")
    public DataResponse deleteCourseByID(@RequestParam Integer id){
        return courseService.deleteCourseById(id);
    }
    @PostMapping("/selectMixed")
    public DataResponse selectMixed(@RequestParam Course course ,@RequestParam(defaultValue = "1") Integer pageNum){
        return DataResponse.success(courseService.selectMixed(course,pageNum));
    }
    @PostMapping("/selectAll")
    public Result selectAll(){
        return courseService.selectAll();
    }

}


