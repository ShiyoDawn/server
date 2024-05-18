package org.example.server.Service;

import org.example.server.mapper.*;
import org.example.server.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentStatisticService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private GloryMapper gloryMapper;
    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private StudentFamilyMapper studentFamilyMapper;

    public Map getStudentStatistic(String person_num) {
        Map<String, Object> map = new HashMap<>();
        Person person = personMapper.selectByPersonNum(person_num);
        if (person != null) {
            Student student = studentMapper.selectByPid(person.getId());
            if (student != null) {
                map.put("person_num", person_num+"");
                map.put("student_name", student.getStudent_name()+"");
                List<StudentFamily> studentFamilyList = studentFamilyMapper.findFamilyByStudentId(student.getId());
                if (!studentFamilyList.isEmpty()) {
                    map.put("student_family_number", studentFamilyList.size()+"");
                }
                else {
                    map.put("student_family_number", "0");
                }
                List<Glory> gloryList = gloryMapper.selectByStudentNum(person_num);
                if (!gloryList.isEmpty()) {
                    map.put("glory_number", gloryList.size()+"");
                }
                else {
                    map.put("glory_number", "0");
                }
                List<Score> scores = scoreMapper.selectByStudentId(person.getPerson_num());
                if (!scores.isEmpty()) {
                    Double sum = 0.0;
                    Double score1 = 0.0;
                    Double highest_score = 0.0;
                    Double lowest_score = 0.0;
                    for (Score score : scores) {
                        Course course = courseMapper.selectById(score.getCourse_id());
                        Double credit = course.getCredit();
                        sum += credit;
                        score1 += score.getMark() * credit;
                        if (score.getMark() > highest_score) {
                            highest_score = score.getMark();
                        }
                        if (score.getMark() < lowest_score) {
                            lowest_score = score.getMark();
                        }
                    }
                    map.put("max_score", highest_score+"");
                    map.put("min_score", lowest_score+"");
                    if (scores.size() != 0) {
                        score1 = score1 / sum;
                        map.put("average_score", score1+"");
                    }
                    map.put("course_number", scores.size()+"");
                }
                else {
                    map.put("max_score", "0");
                    map.put("min_score", "0");
                    map.put("average_score", "0");
                    map.put("course_number", "0");
                }
                List<Activity> activities = activityMapper.selectByStudentNum(person_num);
                if (!activities.isEmpty()) {
                    map.put("activity_number", activities.size()+"");
                }
                else {
                    map.put("activity_number", "0");
                }
                return map;
            }
        }
        return map;
    }
}
