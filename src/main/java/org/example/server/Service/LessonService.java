package org.example.server.Service;

import org.example.server.mapper.LessonMapper;
import org.example.server.payload.response.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
    @Autowired
    LessonMapper lessonMapper;
    public DataResponse updateHomework(String homework,Integer id){
        lessonMapper.updateHomework(homework, id);
        return DataResponse.ok("添加作业成功");
    }
}
