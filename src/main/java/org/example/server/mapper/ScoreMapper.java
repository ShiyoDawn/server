package org.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.server.pojo.Course;
import org.example.server.pojo.Score;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface ScoreMapper extends BaseMapper<Score> {
    public void update1(Integer student_id,Integer course_id,Integer id,Integer mark);

    public Score select1(Integer student_id,Integer course_id);

    public void delete1(Integer id, Integer studentId,Integer courseId);

    List<Score> findByStudentId(Integer studentId);

}
