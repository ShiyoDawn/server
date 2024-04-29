
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
    public DataResponse updateInfo(Integer id, String course_name, Double credit, String num, Integer course_type_id, Integer pre_course_id, String book, String extracurricular){
        if (credit == null) {
            return DataResponse.error(400,"credit cannot be null");
        } else if (num == null) {
            return DataResponse.error(400,"num cannot be null");
        } else if (course_type_id == null) {
            return DataResponse.error(400,"course_name cannot be null");
        } else if (pre_course_id == null) {
            return DataResponse.error(400,"pre_course_id cannot be null");
        } else{
            courseMapper.updateInfo(id, course_name,credit,num,course_type_id,pre_course_id,book,extracurricular);
            return DataResponse.ok("success");
        }
    }
    public DataResponse selectInfo(Integer id){
        return DataResponse.success(courseMapper.selectInfo(id));
    }
    public DataResponse addCourse(String course_name, Double credit, String num, Integer course_type_id, Integer pre_course_id, String book, String extracurricular){
        if(courseMapper.selectByNum(num) != null){
            return DataResponse.error("课程已存在");
        } else {
            courseMapper.addCourse(course_name,credit,num,course_type_id,pre_course_id,book,extracurricular);
            return DataResponse.ok();
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

    public Result selectByNum(String num) {
        return Result.success(courseMapper.selectByNum(num));
    }
}

