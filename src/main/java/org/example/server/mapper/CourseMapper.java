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
    void updateInfo(Integer id, String course_name,Double credit,String num,Integer course_type_id,String book,String extracurricular,String teacher,String classes,String capacity);
    List<Map<String,String>> selectAll();
    List<Map<String,String>> selectAllByPage(Integer pageNum);
    Course selectInfo(Integer id);
    List<Map<String,String>> selectInfoMe(Integer id);
    void addCourse(String course_name, Double credit, String num, Integer course_type_id, Integer pre_course_id, String book, String extracurricular,String classes,String teacher_name,String terms,String capacity,String students);
    Course selectByNum(String num);
    void deleteCourseById(Integer id);
    List<Course> selectMixed(String course_name, Integer course_type_id,Integer pageNum);
    Course selectCourseByName(String course_name);

    List<String> selectIdByStudent(Integer student_id);
    List<Map<String,String>> selectLessonByStudent(Integer student_id,Integer week,String terms);
    List<Map<String,String>> selectType(Integer course_id);
    List<Map<String,String>> selectAllType();
    List<Map<String,String>> selectSpecial(String terms,Integer course_type_id,String course_name,Integer pageNum,String num,String classes,String classe);
    void deleteCourse(Integer id);
    List<Map<String,String>> selectStudentCourse(Integer id);
    List<Map<String,String>> selectStudentCourse2(Integer id);
    void deleteStudent(Integer student_id,Integer course_id);
    void addStudent(Integer course_id,Integer student_id,String student_name);
    List<Map<String,String>> selectStudentAndCourse(Integer student_id,Integer course_id);
    List<Map<String,String>> selectPre(Integer student_id,Integer pre_course_id);
    List<Map<String,String>> selectclasses(Integer id);
    List<Map<String,String>> selectCourseByType(Integer id1,Integer id2,Integer id3,Integer pageNum,String classes,String classe,String terms);
    List<Map<String,String>> selectLessonStudent(Integer student_id,String terms);
    List<Map<String,String>> selectByNum2(String num);
    void addCourseStudent(Integer id);
    void minusCourseStudent(Integer id);
    List<Map<String,String>> selectCourseByStudent(Integer student_id,Integer pageNum);
    Course selectById(Integer id);
}
