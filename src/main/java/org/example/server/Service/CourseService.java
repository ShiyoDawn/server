/*
package org.example.server.Service;

import org.example.server.mapper.CourseMapper;
import org.example.server.payload.response.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CourseService {
    @Autowired
    CourseMapper courseMapper;
    public DataResponse updateInfo(Integer id, String course_name, Double credit, Integer num, Integer course_type_id, Integer pre_course_id, String book, String extracurricular){
        if (course_name == null){
            return "course_name cannot be null";
        } else if (credit == null) {
            return "credit cannot be null";
        } else if (num == null) {
            return "num cannot be null";
        } else if (course_type_id == 0) {
            return "course_type_id cannot be null";
        } else if (pre_course_id == null) {
            return "pre_course_id cannot be null";
        } else{
            courseMapper.updateInfo(id, course_name,credit,num,course_type_id,pre_course_id,book,extracurricular);
            return "success";
            return DataResponse.error(400,"course_name cannot be null");
        } else if (credit == null) {
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
}
*/
