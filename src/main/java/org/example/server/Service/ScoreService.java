package org.example.server.Service;

import org.example.server.mapper.CourseMapper;
import org.example.server.mapper.ScoreMapper;
import org.example.server.mapper.StudentMapper;
import org.example.server.payload.request.DataRequest;
import org.example.server.payload.response.DataResponse;
import org.example.server.pojo.Course;
import org.example.server.pojo.Score;
import org.example.server.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.*;

@Service
public class ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CourseMapper courseMapper;

    //增添分数
    public void insert(Integer id, Integer student_id, Integer course_id, Integer mark) {
        scoreMapper.insert(new Score(id, student_id, studentMapper.selectById(student_id).getStudent_name(), course_id, courseMapper.selectById(course_id).getCourse_name(), mark, null));
    }

    //删除分数
    public void deleteById(Integer student_id, Integer course_id, Integer id) {
        scoreMapper.delete1(student_id, course_id, id);
    }

    //修改分数
    public void update(Integer student_id, Integer course_id, Integer id, Integer mark) {
        scoreMapper.update1(student_id, course_id, id, mark);
    }

    //查询分数
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

    public DataResponse scoreSave(@Valid @RequestBody DataRequest dataRequest) {
        Integer studentId = dataRequest.getInteger("student_id");
        Integer courseId = dataRequest.getInteger("course_id");
        Integer mark = dataRequest.getInteger("mark");
        Integer scoreId = dataRequest.getInteger("id");

        Score score = null;
        if (scoreId != null) {
            score = scoreMapper.selectById(scoreId);
        }
        if (score == null) {
            score = new Score();
            Student student = studentMapper.selectById(studentId);
            Course course = courseMapper.selectById(courseId);
            if (student == null && course != null) {
                return DataResponse.error(404, "Student does not exist.");
            } else if (student != null && course == null) {
                return DataResponse.error(404, "Course does not exist.");
            } else if (student == null && course == null) {
                return DataResponse.error(404, "Course and Student do not exist.");
            } else {
                score.setStudent_name(student.getStudent_name());
                score.setCourse_name((course.getCourse_name()));
            }
        }
        score.setMark(mark);
        scoreMapper.saveScore(score);
        return DataResponse.ok();
    }

    //给按某课程分数排序(暂时不知道需不需要)
    //升序排序
    public List<Score> getScoreSorted_Ascending(Integer course_id) {
        return scoreMapper.getScoreSorted_Ascending(course_id);
    }

    //降序排序
    public List<Score> getScoreSorted_Descending(Integer course_id) {
        return scoreMapper.getScoreSorted_Descending(course_id);
    }

}
