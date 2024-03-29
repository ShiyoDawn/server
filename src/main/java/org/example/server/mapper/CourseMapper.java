package org.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.server.payload.request.DataRequest;
import org.example.server.pojo.Course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    void updateInfo(Integer id, String course_name,Double credit,Integer num,Integer course_type_id,Integer pre_course_id,String book,String extracurricular);
    List<HashMap<String,String>> selectAll();
    Course selectInfo(Integer id);

}
