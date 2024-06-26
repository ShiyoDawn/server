
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
        Integer capacity = dataRequest.getInteger("capacity");
        return courseService.updateInfo(id, course_name, credit, num, course_type, book, extracurricular,teacher,classes,capacity);
    }
    @PostMapping("/selectInfo")
    public DataResponse selectInfo(@RequestBody DataRequest dataRequest){
        Integer id=dataRequest.getInteger("id");
        return courseService.selectInfo(id);
    }
    @PostMapping("/selectInfoMe")
    public Result selectInfoMe(@RequestBody DataRequest dataRequest){
        Integer id = dataRequest.getInteger("id");
        return courseService.selectInfoMe(id);
    }
    @PostMapping("/addCourse")
    public Result addCourse(@RequestBody DataRequest dataRequest){
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
        String capacity=dataRequest.getString("capacity");
        String students=dataRequest.getString("students");
        return courseService.addCourse(course_name, credit, num, course_type, pre_course_id, book, extracurricular,classes,teacher_name,terms,capacity,students);
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
    @PostMapping("/selectLessonByTeacher")
    public Result selectLessonByTeacher(@RequestBody DataRequest dataRequest){
        Integer teacher_id = dataRequest.getInteger("teacher_id");
        Integer week = dataRequest.getInteger("week");
        String terms = dataRequest.getString("terms");
        return courseService.selectLessonByTeacher(teacher_id,week,terms);
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
        String classe = dataRequest.getString("classe");
        Integer pageNum = dataRequest.getInteger("pageNum");
        return courseService.selectSpecial(terms,course_type,course_name,pageNum,num,classes,classe);
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
    @PostMapping("/selectStudentCourse2")
    public Result selectStudentCourse2(@Valid @RequestBody DataRequest dataRequest){
        Integer id = dataRequest.getInteger("id");
        Integer lesson_id = dataRequest.getInteger("lesson_id");
        return courseService.selectStudentCourse2(id,lesson_id);
    }
    @PostMapping("/deleteStudent")
    public Result deleteStudent(@Valid @RequestBody DataRequest dataRequest){
        Integer student_id = dataRequest.getInteger("student_id");
        Integer course_id = dataRequest.getInteger("course_id");
        return courseService.deleteStudent(student_id,course_id);
    }
    @PostMapping("/addStudent")
    public Result addStudent(@RequestBody DataRequest dataRequest){
        Integer course_id = dataRequest.getInteger("course_id");
        Integer student_id = dataRequest.getInteger("student_id");
        String student_name = dataRequest.getString("student_name");
        return courseService.addStudent(course_id,student_id,student_name);
    }
    @PostMapping("/selectStudentAndCourse")
    public Result selectStudentAndCourse(@Valid @RequestBody DataRequest dataRequest){
        Integer student_id = dataRequest.getInteger("student_id");
        Integer course_id = dataRequest.getInteger("course_id");
        return courseService.selectStudentAndCourse(student_id,course_id);
    }
    @PostMapping("/selectClasses")
    public Result selectClasses(@Valid @RequestBody DataRequest dataRequest){
        Integer id = dataRequest.getInteger("id");
        return courseService.selectClasses(id);
    }
    @PostMapping("/selectClassesT")
    public Result selectClassesT(@Valid @RequestBody DataRequest dataRequest){
        Integer id = dataRequest.getInteger("id");
        return courseService.selectClassesT(id);
    }
    @PostMapping("/selectCourseByType")
    public Result selectCourseByType(@Valid @RequestBody DataRequest dataRequest){
        Integer id1 = dataRequest.getInteger("course_type_id");
        Integer id2 = dataRequest.getInteger("course_typ_id");
        Integer id3 = dataRequest.getInteger("course_ty_id");
        Integer pageNum = dataRequest.getInteger("pageNum");
        String classes = dataRequest.getString("classes");
        String classe = dataRequest.getString("classe");
        String terms = dataRequest.getString("terms");
        return courseService.selectCourseByType(id1,id2,id3,pageNum,classes,classe,terms);
    }
    @PostMapping("/selectPre")
    public Result selectPre(@Valid @RequestBody DataRequest dataRequest){
        Integer student_id = dataRequest.getInteger("student_id");
        Integer pre_course_id = dataRequest.getInteger("pre_course_id");
        return courseService.selectPre(student_id,pre_course_id);
    }
    @PostMapping("/selectLessonStudent")
    public Result selectLessonStudent(@RequestBody DataRequest dataRequest){
        Integer student_id = dataRequest.getInteger("student_id");
        String terms = dataRequest.getString("terms");
        return courseService.selectLessonStudent2(student_id,terms);
    }
    @PostMapping("/selectByNum2")
    public Result selectByNum2(@RequestBody DataRequest dataRequest){
        String num = dataRequest.getString("num");
        return courseService.selectByNum2(num);
    }
    @PostMapping("/addCourseStudent")
    public Result addCourseStudent(@Valid @RequestBody DataRequest dataRequest){
        Integer id = dataRequest.getInteger("course_id");
        return courseService.addCourseStudent(id);
    }
    @PostMapping("/minusCourseStudent")
    public Result minusCourseStudent(@Valid @RequestBody DataRequest dataRequest){
        Integer id = dataRequest.getInteger("course_id");
        return courseService.minusCourseStudent(id);
    }
    @PostMapping("/selectCourseByStudent")
    public Result selectCourseByStudent(@Valid @RequestBody DataRequest dataRequest){
        Integer id = dataRequest.getInteger("student_id");
        Integer pageNum = dataRequest.getInteger("pageNum");
        return courseService.selectCourseByStudent(id,pageNum);
    }
    @PostMapping("/selectCourseByTeacher")
    public Result selectCourseByTeacher(@Valid @RequestBody DataRequest dataRequest){
        Integer id = dataRequest.getInteger("teacher_id");
        Integer pageNum = dataRequest.getInteger("pageNum");
        return courseService.selectCourseByTeacher(id,pageNum);
    }
    @PostMapping("/selectAllTeacher")
    public Result selectAllTeacher(){
        return courseService.selectAllTeacher();
    }
    @PostMapping("/addTeacherCourse")
    public Result addTeacherCourse(@Valid @RequestBody DataRequest dataRequest){
        Integer teacher_id = dataRequest.getInteger("teacher_id");
        Integer course_id = dataRequest.getInteger("course_id");
        return courseService.addTeacherCourse(teacher_id,course_id);
    }
    @PostMapping("/addEvent")
    public Result addEvent(@Valid @RequestBody DataRequest dataRequest){
        Integer student_id = dataRequest.getInteger("student_id");
        return courseService.addEvent(student_id);
    }
    @PostMapping("/selectLessonByStudentA")
    public Result selectLessonByStudentA(@Valid @RequestBody DataRequest dataRequest){
        Integer course_id = dataRequest.getInteger("course_id");
        return courseService.selectLessonByStudentA(course_id);
    }
}


