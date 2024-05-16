
package org.example.server.Service;

import org.example.server.mapper.CourseMapper;
import org.example.server.payload.Result;
import org.example.server.payload.response.DataResponse;
import org.example.server.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseMapper courseMapper;
    public DataResponse updateInfo(Integer id, String course_name, Double credit, String num, String course_type, String book, String extracurricular,String teacher,String classes,String capacity){
        Integer course_type_id;
        if (credit == null) {
            return DataResponse.error(400,"credit cannot be null");
        } else if (num == null || num.equals("")) {
            return DataResponse.error(400,"num cannot be null");
        } else if (course_type == null) {
            return DataResponse.error(400,"course_type cannot be null");
        } else if (course_name == null || course_name.equals("")) {
            return DataResponse.error(400,"course_name cannot be null");
        } else if(book == null || book.equals("")) {
            return DataResponse.error(400,"book cannot be null");
        } else if(extracurricular == null || extracurricular.equals("")) {
            return DataResponse.error(400,"extracurricular cannot be null");
        } else if(classes == null || classes.equals("")) {
            return DataResponse.error(400,"classes cannot be null");
        } else if(teacher == null || teacher.equals("")) {
            return DataResponse.error(400,"teacher cannot be null");
        }else if(capacity == null || capacity.equals("")) {
            return DataResponse.error(400,"capacity cannot be null");
        } else{
            if(course_type.equals("专业基础课")){
                course_type_id = 1;
            } else if (course_type.equals("学科基础课")) {
                course_type_id = 2;
            } else if (course_type.equals("通识核心课")) {
                course_type_id = 3;
            } else if (course_type.equals("通识选修课")) {
                course_type_id = 4;
            } else if (course_type.equals("创新实践计划")) {
                course_type_id = 5;
            } else if (course_type.equals("专业选修课")) {
                course_type_id = 6;
            } else if (course_type.equals("通识必修课")) {
                course_type_id = 7;
            } else {
                course_type_id = null;
            }
            courseMapper.updateInfo(id, course_name,credit,num,course_type_id,book,extracurricular,teacher,classes,capacity);
            return DataResponse.ok("success");
        }
    }
    public DataResponse selectInfo(Integer id){
        return DataResponse.success(courseMapper.selectInfo(id));
    }
    public Result addCourse(String course_name, Double credit, String num, String course_type, Integer pre_course_id, String book, String extracurricular,String classes,String teacher_name,String terms,String capacity,String students){
        Integer course_type_id;
        if(course_type == null){
            course_type_id = null;
        } else if(course_type.equals("专业基础课")){
            course_type_id = 1;
        } else if (course_type.equals("学科基础课")) {
            course_type_id = 2;
        } else if (course_type.equals("通识核心课")) {
            course_type_id = 3;
        } else if (course_type.equals("通识选修课")) {
            course_type_id = 4;
        } else if (course_type.equals("创新实践计划")) {
            course_type_id = 5;
        } else if (course_type.equals("专业选修课")) {
            course_type_id = 6;
        } else if (course_type.equals("通识必修课")) {
            course_type_id = 7;
        } else {
            course_type_id = null;
        }
        if(courseMapper.selectByNum(num) != null){
            return Result.error(400,"课程已存在");
        } else {
            courseMapper.addCourse(course_name,credit,num,course_type_id,pre_course_id,book,extracurricular,classes,teacher_name,terms,capacity,students);
            return Result.ok("添加成功");
        }

    }
    public DataResponse deleteCourseById(Integer id){
        if(courseMapper.selectInfo(id) == null){
            return DataResponse.error("课程不存在");
        } else {
            courseMapper.deleteCourseById(id);
            return DataResponse.ok();
        }
    }
    //    public DataResponse selectMixed(Course course){
//        return DataResponse.success(courseMapper.selectMixed(course));
//    }
    //分页查询课程
    public DataResponse selectMixed(Course course,Integer pageNum){
        List<Course> courseList = courseMapper.selectMixed(course.getCourse_name(),course.getCourse_type_id(),pageNum);
        if (courseList == null){
            return DataResponse.error("没有您想要课程");
        } else {
            return DataResponse.success(courseList);
        }

    }
    public Result selectAll(){
        return Result.success(courseMapper.selectAll());
    }
    public Result selectAllByPage(Integer pageNum){
        return Result.success(courseMapper.selectAllByPage(pageNum));
    }
    public Result selectCourseByName(String course_name) {
        return Result.success(courseMapper.selectCourseByName(course_name));
    }
    public Result selectIdByStudent(Integer student_id) {
        return Result.success(courseMapper.selectIdByStudent(student_id));
    }
    public Result selectLessonByStudent(Integer student_id,Integer week,String terms) {
        return Result.success(courseMapper.selectLessonByStudent(student_id,week,terms));
    }
    public Result selectType(Integer course_id){
        return Result.success(courseMapper.selectType(course_id));
    }
    public Result selectAllType(){
        return Result.success(courseMapper.selectAllType());
    }
    public Result selectSpecial(String terms,String course_type,String course_name,Integer pageNum,String num,String classes,String classe){
        Integer course_type_id;
        if(course_type == null){
            course_type_id = null;
        } else if(course_type.equals("专业基础课")){
            course_type_id = 1;
        } else if (course_type.equals("学科基础课")) {
            course_type_id = 2;
        } else if (course_type.equals("通识核心课")) {
            course_type_id = 3;
        } else if (course_type.equals("通识选修课")) {
            course_type_id = 4;
        } else if (course_type.equals("创新实践计划")) {
            course_type_id = 5;
        } else if (course_type.equals("专业选修课")) {
            course_type_id = 6;
        } else if (course_type.equals("通识必修课")) {
            course_type_id = 7;
        } else {
            course_type_id = null;
        }
        return Result.success(courseMapper.selectSpecial(terms,course_type_id,course_name,pageNum,num,classes,classe));
    }

    public Result selectByNum(String num) {
        return Result.success(courseMapper.selectByNum(num));
    }
    public Result deleteCourse(Integer id){
        courseMapper.deleteCourse(id);
        return Result.ok("删除成功");
    }
    public Result selectStudentCourse(Integer id){
        return Result.success(courseMapper.selectStudentCourse(id));
    }
    public Result deleteStudent(Integer student_id,Integer course_id){
        courseMapper.deleteStudent(student_id,course_id);
        return Result.ok("删除成功");
    }
    public Result addStudent(Integer course_id,Integer student_id,String student_name){
        courseMapper.addStudent(course_id,student_id,student_name);
        return Result.ok("添加学生成功");
    }
    public Result selectStudentAndCourse(Integer student_id,Integer course_id) {
        return Result.success(courseMapper.selectStudentAndCourse(student_id,course_id));
    }
    public Result selectClasses(Integer id) {
        return Result.success(courseMapper.selectclasses(id));
    }
    public Result selectCourseByType(Integer id1,Integer id2,Integer id3,Integer pageNum,String classes,String classe,String terms) {
        return Result.success(courseMapper.selectCourseByType(id1,id2,id3,pageNum,classes,classe,terms));
    }
    public Result selectPre(Integer student_id,Integer pre_course_id) {
        if(pre_course_id == 0){
            return Result.success(courseMapper.selectAll());
        } else {
            return Result.success(courseMapper.selectPre(student_id,pre_course_id));
        }
    }
    public Result selectLessonStudent(Integer student_id,String terms) {
        return Result.success(courseMapper.selectLessonStudent(student_id,terms));
    }
    public Result selectByNum2(String num) {
        return Result.success(courseMapper.selectByNum2(num));
    }
}

