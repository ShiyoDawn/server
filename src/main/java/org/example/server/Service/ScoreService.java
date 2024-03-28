package org.example.server.Service;

import org.example.server.mapper.CourseMapper;
import org.example.server.mapper.ScoreMapper;
import org.example.server.mapper.StudentMapper;
import org.example.server.payload.request.DataRequest;
import org.example.server.payload.response.DataResponse;
import org.example.server.pojo.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CourseMapper courseMapper;

    //增添分数
    public void insert(Integer id,Integer student_id, Integer course_id, Integer mark) {
        scoreMapper.insert(new Score(id, student_id, studentMapper.selectById(student_id).getStudent_name(), course_id, courseMapper.selectById(course_id).getCourse_name(), mark, null));
    }

    //删除分数
    public void deleteById(Integer student_id, Integer course_id, Integer id) {
        scoreMapper.delete1(student_id, course_id,id);
    }

    //修改分数
    public void update(Integer student_id, Integer course_id, Integer id, Integer mark) {
        scoreMapper.update1(student_id, course_id, id, mark);
    }

    //查询分数

//    public Score select(Integer student_id, Integer course_id) {
//        return scoreMapper.select1(student_id, course_id);
//    }
//
//    public DataResponse getScoreList(@Valid @RequestBody DataRequest dataRequest) {
//        Integer studentId = dataRequest.getInteger("id");
//        if (studentId == null)
//            studentId = 0;
//        Integer courseId = dataRequest.getInteger("id");
//        if(courseId == null)
//            courseId = 0;
//    }


    public List<Score> selectByStudentAndCourse(Integer student_id, Integer course_id) {
        return scoreMapper.selectByStudentAndCourse(student_id, course_id);
    }

    public List<Score> selectByStudentId(Integer student_id) {
        return scoreMapper.selectByStudentId(student_id);
    }

    public List<Score> selectByCourseId(Integer course_id) {
        return scoreMapper.selectByCourseId(course_id);
    }


    public DataResponse getScoreList(@Valid @RequestBody DataRequest dataRequest) {
        Integer studentId = dataRequest.getInteger("id");
        if (studentId == null)
            studentId = 0;
        Integer courseId = dataRequest.getInteger("id");
        if (courseId == null)
            courseId = 0;
        List<Score> scoreList = scoreMapper.selectByStudentAndCourse(studentId, courseId);
        List<Map<String, String>> dataList = new ArrayList();
        Map<String, String> map;
        for (Score s : scoreList) {
            map = new HashMap();
            map.put("id", s.getId() + "");
            map.put("student_id", s.getStudent_id() + "");
            map.put("student_name", s.getStudent_name());
            map.put("course_id", s.getCourse_id() + "");
            map.put("course_name", s.getCourse_name());
            map.put("mark", s.getMark() + "");
            map.put("ranking", s.getRanking() + "");
            dataList.add(map);
        }
        return DataResponse.success(dataList);
    }

}
