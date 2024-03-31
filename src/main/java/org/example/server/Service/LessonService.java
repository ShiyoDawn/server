package org.example.server.Service;

import org.example.server.mapper.LessonMapper;
import org.example.server.payload.response.DataResponse;
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

}
