package org.example.server.Service;

import org.example.server.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    CourseMapper courseMapper;
    public void updateInfo(Integer id, String course_name,Double credit,Integer num,Integer course_type_id,Integer pre_course_id,String book,String extracurricular){
        courseMapper.updateInfo(id, course_name,credit,num,course_type_id,pre_course_id,book,extracurricular);
    }
}
