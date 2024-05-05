
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
    public DataResponse updateInfo(@RequestBody DataRequest dataRequest) {
        Integer id=dataRequest.getInteger("id");
        String course_name=dataRequest.getString("course_name");
        Double credit=dataRequest.getDouble("credit");
        String num=dataRequest.getString("num");
        String course_type = dataRequest.getString("course_type");
        String book=dataRequest.getString("book");
        String extracurricular=dataRequest.getString("extracurricular");
        String teacher = dataRequest.getString("teacher");
        String classes = dataRequest.getString("classes");
        return courseService.updateInfo(id, course_name, credit, num, course_type, book, extracurricular,teacher,classes);
    }
    @PostMapping("/selectInfo")
    public DataResponse selectInfo(@RequestBody DataRequest dataRequest){
        Integer id=dataRequest.getInteger("id");
        return courseService.selectInfo(id);
    }
    @PostMapping("/addCourse")
    public DataResponse addCourse(@RequestBody DataRequest dataRequest){
        String course_name=dataRequest.getString("course_name");
        Double credit=dataRequest.getDouble("credit");
        String num=dataRequest.getString("num");
        String course_type=dataRequest.getString("course_type");
        Integer pre_course_id=dataRequest.getInteger("pre_course_id");
        String book=dataRequest.getString("book");
        String extracurricular=dataRequest.getString("extracurricular");
        String classes=dataRequest.getString("classes");
        String teacher_name=dataRequest.getString("teacher_name");
        String terms=dataRequest.getString("terms");
        return courseService.addCourse(course_name, credit, num, course_type, pre_course_id, book, extracurricular,classes,teacher_name,terms);
    }
    @PostMapping("/deleteCourseById")
    public DataResponse deleteCourseByID(@RequestBody DataRequest dataRequest){
        Integer id=dataRequest.getInteger("id");
        return courseService.deleteCourseById(id);
    }
    @PostMapping("/selectMixed")
    public DataResponse selectMixed(@RequestBody DataRequest dataRequest){
        Course course=(Course) dataRequest.get("course");
        Integer pageNum=dataRequest.getInteger("pageNum");
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
    public Result selectIdByStudent(@RequestBody DataRequest dataRequest){
        Integer student_id=dataRequest.getInteger("student_id");
        return courseService.selectIdByStudent(student_id);
    }
    @PostMapping("/selectLessonByStudent")
    public Result selectLessonByStudent(@RequestBody DataRequest dataRequest){
        Integer student_id = dataRequest.getInteger("student_id");
        Integer week = dataRequest.getInteger("week");
        String terms = dataRequest.getString("terms");
        return courseService.selectLessonByStudent(student_id,week,terms);
    }

    @PostMapping("/selectByNum")
    public Result selectByNum(@RequestBody DataRequest dataRequest){
        String num=dataRequest.getString("num");
        return courseService.selectByNum(num);
    }

    @PostMapping("/selectType")
    public Result selectType (@Valid @RequestBody DataRequest dataRequest){
        Integer course_id = dataRequest.getInteger("course_id");
        return courseService.selectType(course_id);
    }
    @PostMapping("/selectAllType")
    public Result selectAllType(){
        return courseService.selectAllType();
    }
    @PostMapping("selectSpecial")
    public Result selectSpecial (@Valid @RequestBody DataRequest dataRequest){
        String course_name = dataRequest.getString("course_name");
        String terms = dataRequest.getString("terms");
        String course_type = dataRequest.getString("course_type");
        String num = dataRequest.getString("classNum");
        String classes = dataRequest.getString("classes");
        Integer pageNum = dataRequest.getInteger("pageNum");
        return courseService.selectSpecial(terms,course_type,course_name,pageNum,num,classes);
    }
    @PostMapping("/deleteCourse")
    public Result deleteCourse(@Valid @RequestBody DataRequest dataRequest){
        Integer id = dataRequest.getInteger("id");
        return courseService.deleteCourse(id);
    }
    @PostMapping("/selectStudentCourse")
    public Result selectStudentCourse(@Valid @RequestBody DataRequest dataRequest){
        Integer id = dataRequest.getInteger("id");
        return courseService.selectStudentCourse(id);
    }

}


