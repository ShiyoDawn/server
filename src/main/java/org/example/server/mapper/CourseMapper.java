package org.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.server.payload.request.DataRequest;
import org.example.server.pojo.Course;
import org.example.server.pojo.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    void updateInfo(Integer id, String course_name,Double credit,String num,Integer course_type_id,String book,String extracurricular,String teacher,String classes);
    List<Map<String,String>> selectAll();
    List<Map<String,String>> selectAllByPage(Integer pageNum);
    List<Map<String,String>> selectInfo(Integer id);
    void addCourse(String course_name, Double credit, String num, Integer course_type_id, Integer pre_course_id, String book, String extracurricular,String classes,String teacher_name,String terms);
    Course selectByNum(String num);
    void deleteCourseById(Integer id);
    List<Course> selectMixed(String course_name, Integer course_type_id,Integer pageNum);
    Course selectCourseByName(String course_name);

    List<String> selectIdByStudent(Integer student_id);
    List<Map<String,String>> selectLessonByStudent(Integer student_id,Integer week,String terms);
    List<Map<String,String>> selectType(Integer course_id);
    List<Map<String,String>> selectAllType();
    List<Map<String,String>> selectSpecial(String terms,Integer course_type_id,String course_name,Integer pageNum,String num,String classes);
    void deleteCourse(Integer id);
    List<Map<String,String>> selectStudentCourse(Integer id);
}
