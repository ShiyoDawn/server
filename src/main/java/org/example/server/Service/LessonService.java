package org.example.server.Service;

import org.example.server.mapper.LessonMapper;
import org.example.server.payload.response.DataResponse;
import org.example.server.pojo.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {
    @Autowired
    LessonMapper lessonMapper;
    public DataResponse updateHomework(String homework,Integer id){
        lessonMapper.updateHomework(homework, id);
        return DataResponse.ok("添加作业成功");
    }
    public DataResponse selectAllHomeworkFromStudent(Integer id){
        List<String> slist = lessonMapper.selectAllHomeworkFromStudent(id);
        if(slist == null || slist.size() == 0){
            return DataResponse.ok("所有作业均已完成");
        }else {
            return DataResponse.success(slist);
        }
    }
    public DataResponse selectAllHomeworkFromTeacher(Integer id){
        List<String> slist = lessonMapper.selectAllHomeworkFromTeacher(id);
        if(slist == null || slist.size() == 0){
            return DataResponse.ok("还没有人提交作业");
        } else {
            return DataResponse.success(slist);
        }
    }
    public DataResponse selectOneLesson(Integer course_id){
        List<Lesson> slist = lessonMapper.selectOneLesson(course_id);
        if(slist == null){
            return DataResponse.error("没有此课程");
        } else {
            return DataResponse.success(slist);
        }
    }

}
