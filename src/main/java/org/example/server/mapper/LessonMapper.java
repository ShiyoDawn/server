package org.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.server.pojo.Lesson;

import java.util.List;

@Mapper
public interface LessonMapper extends BaseMapper<Lesson> {
    void updateHomework(String homework,Integer id);
    List<Lesson> selectLesson();
    List<String> selectAllHomeworkFromStudent(Integer student_id);
    List<String> selectAllHomeworkFromTeacher(Integer lesson_id);
    List<Lesson> selectOneLesson(Integer course_id);
}
