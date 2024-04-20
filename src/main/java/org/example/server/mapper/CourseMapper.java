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
    void updateInfo(Integer id, String course_name,Double credit,Integer num,Integer course_type_id,Integer pre_course_id,String book,String extracurricular);
    List<Course> selectAll();
    Course selectInfo(Integer id);

    void addCourse(String course_name, Double credit, Integer num, Integer course_type_id, Integer pre_course_id, String book, String extracurricular);
    Course selectByNum(Integer num);
    void deleteCourseById(Integer id);
    List<Course> selectMixed(String course_name, Integer course_type_id,Integer pageNum);
    Course selectByName(String course_name);

    List<String> selectIdByStudent(Integer student_id);
}
