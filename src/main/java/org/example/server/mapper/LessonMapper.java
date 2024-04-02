package org.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.server.pojo.Lesson;

import java.util.List;

@Mapper
public interface LessonMapper extends BaseMapper<Lesson> {
    List<Lesson> selectLesson();
    void updateHomework(String homework,Integer id);
    void updateHomeworkFromStudent(String student_homework,Integer student_id,Integer lesson_id);

    List<String> selectAllHomeworkFromStudent(Integer student_id);
    List<String> selectAllHomeworkFromTeacher(Integer lesson_id);
    List<Lesson> selectOneLessonFromTeacher(Integer course_id,Integer teacher_id);
    List<Lesson> selectOneLessonFromStudent(Integer course_id,Integer student_id);
    void updateHomeworkRating(Integer homework_rating_id,Integer lesson_id,Integer student_id);
    List<String> selectHomeworkRatingStudent(Integer lesson_id,Integer student_id);
    List<String> selectHomeworkRatingTeacher(Integer lesson_id,Integer teacher_id);
}
