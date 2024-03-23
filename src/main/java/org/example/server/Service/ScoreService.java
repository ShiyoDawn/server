package org.example.server.Service;

import org.example.server.mapper.CourseMapper;
import org.example.server.mapper.ScoreMapper;
import org.example.server.mapper.StudentMapper;
import org.example.server.pojo.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CourseMapper courseMapper;


    //增添分数
    public void insert(Integer student_id, Integer course_id, Integer mark){
        scoreMapper.insert(new Score(null,student_id,studentMapper.selectById(student_id).getStudent_name(),course_id,courseMapper.selectById(course_id),mark,null));
    }
    //删除分数
    public void deleteById(Integer student_id,Integer course_id,Integer id){
        scoreMapper.deleteById(id,student_id,studentMapper.selectById(student_id).getStudent_name(),course_id,courseMapper.selectById(course_id),null,null);
    }
    //修改分数
    public void update(Integer student_id,Integer course_id,Integer id,Integer mark){
        scoreMapper.update1(student_id,course_id,id,mark);
    }
    //查询分数
    public Score select(Integer student_id,Integer course_id){
        return scoreMapper.select1(student_id,course_id);
    }
}
