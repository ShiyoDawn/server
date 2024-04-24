
package org.example.server.controller;

import org.example.server.Service.CourseService;
import org.example.server.payload.Result;
import org.example.server.payload.request.DataRequest;
import org.example.server.payload.response.DataResponse;
import org.example.server.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;


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
    @PostMapping("/selectAllByPage")
    public Result selectAllByPage(@Valid @RequestBody DataRequest dataRequest){
        Integer pageNum = dataRequest.getInteger("pageNum");
        return courseService.selectAllByPage(pageNum);
    }

    @PostMapping("/selectCourseByName")
    public Result selectCourseByName(@Valid @RequestBody DataRequest dataRequest){
        String course_name=dataRequest.getString("course_name");
        System.out.println(course_name);
        return courseService.selectCourseByName(course_name);
    }
    @PostMapping("/selectIdByStudent")
    public Result selectIdByStudent(@RequestBody Map<String,Integer> map){
        return courseService.selectIdByStudent(map.get("student_id"));
    }
    @PostMapping("/selectLessonByStudent")
    public Result selectLessonByStudent(@RequestBody DataRequest dataRequest){
        Integer student_id = dataRequest.getInteger("student_id");
        Integer week = dataRequest.getInteger("week");
        String terms = dataRequest.getString("terms");
        return courseService.selectLessonByStudent(student_id,week,terms);
    }
    @PostMapping("selectType")
    public Result selectType (@Valid @RequestBody DataRequest dataRequest){
        Integer course_id = dataRequest.getInteger("course_id");
        return courseService.selectType(course_id);
    }
    @PostMapping("selectAllType")
    public Result selectAllType(){
        return courseService.selectAllType();
    }

}


