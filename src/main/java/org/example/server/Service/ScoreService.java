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
    public DataResponse insert(Integer student_id, Integer course_id, Integer mark) {
        Student student = studentMapper.selectById(student_id);
        Course course = courseMapper.selectInfo(course_id);
        if (student == null || course == null) {
            // 处理学生或课程不存在的情况
            return DataResponse.error(404, "Student or Course does not exist.");
        }
        scoreMapper.insert1(student_id, student.getStudent_name(), course_id, course.getCourse_name(), mark);
        return DataResponse.success(null, "添加成功！");
    }

    //删除分数
    public DataResponse deleteById(Integer student_id, Integer course_id) {
        Student student = studentMapper.selectById(student_id);
        if (student == null)
            return DataResponse.error(404, "删除失败，该学生不存在");
        Course course = courseMapper.selectInfo(course_id);
        if (course == null)
            return DataResponse.error(404, "删除失败，该课程不存在");
        scoreMapper.delete1(student_id, course_id);
        return DataResponse.success(null, "删除成功！");
    }

    //修改分数
    public DataResponse update(Integer student_id, Integer course_id, Integer mark) {
        Student student = studentMapper.selectById(student_id);
        if (student == null)
            return DataResponse.error(404, "修改失败，该学生不存在");
        Course course = courseMapper.selectInfo(course_id);
        if (course == null)
            return DataResponse.error(404, "修改失败，该学生不存在");
        scoreMapper.update1(student_id, course_id, mark);
        return DataResponse.success("更新成功！");
    }

    //查询分数
    public Score selectByStudentAndCourse(Integer student_id, Integer course_id) {
        return scoreMapper.selectByStudentAndCourse(student_id, course_id);
    }

    public List<Score> selectByStudentId(Integer student_id) {
        return scoreMapper.selectByStudentId(student_id);
    }

    public List<Score> selectByCourseId(Integer course_id) {
        return scoreMapper.selectByCourseId(course_id);
    }

    public DataResponse getScoreList() {
        List<Score> scoreList = scoreMapper.selectAll();
        //List<Score> scoreList = scoreMapper.selectByStudentAndCourse(studentId, courseId);
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
