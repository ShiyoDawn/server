package org.example.server.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.server.payload.request.DataRequest;
import org.example.server.pojo.Course;

import java.util.List;

@Mapper
public interface CourseMapper {
    void updateInfo(Integer id, String course_name,Double credit,Integer num,Integer course_type_id,Integer pre_course_id,String book,String extracurricular);
    List<Course> selectAll();
}
