package org.example.server.Service;

import org.example.server.mapper.*;
import org.example.server.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentClassificationService {
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

    public Integer age(String birthday) {
        String[] str = birthday.split("/");
        int year = Integer.parseInt(str[0]);
        int age = 2024 - year;
        return age;
    }

    public List<Map> getStudentClassification() {
        List<Map> list = new ArrayList<>();
        Set<String> classesSet = new HashSet<>();
        List<Student> students = studentMapper.findAllStudent();
        for (Student student : students) {
            classesSet.add(student.getClasses());
        }
        String[] grades = {"大一", "大二", "大三", "大四"};
        for (String grade : grades) {
            Integer male = 0;
            Integer female = 0;
            Integer party_member = 0;
            Integer league_member = 0;
            Integer glory_number = 0;
            Integer activity_number = 0;
            Double average_score = 0.0;
            Double highest_score = 0.0;
            Double lowest_score = 0.0;
            Integer le_18 = 0;
            Integer ge_19 = 0;
            Integer count = 0;
            Double score1 = 0.0;
            for (String classes : classesSet) {
                male= 0;
                female= 0;
                party_member= 0;
                league_member= 0;
                glory_number= 0;
                activity_number= 0;
                average_score= 0.0;
                highest_score= 0.0;
                lowest_score= 0.0;
                le_18= 0;
                ge_19= 0;
                List<Student> studentList = studentMapper.selectByGradeAndClasses(grade, classes);
                if(studentList.isEmpty()){
                    continue;
                }else {
                    for (Student student : studentList) {
                        Person person = personMapper.selectById(student.getPerson_id());
                        List<Activity> activities = activityMapper.selectByStudentNum(person.getPerson_num());
                        for (Activity activity : activities) {
                            activity_number++;
                        }
                        if (age(person.getBirthday()) < 19) {
                            le_18++;
                        } else {
                            ge_19++;
                        }
                        count++;
                        if (person.getGender_id() == 1) {
                            male++;
                        } else {
                            female++;
                        }
                        if (person.getIdentity().equals("党员")) {
                            party_member++;
                        } else if (person.getIdentity().equals("团员")) {
                            league_member++;
                        }
                        String person_num = person.getPerson_num();
                        List<Glory> glories = gloryMapper.selectByStudentNum(person_num);
                        List<Score> scores = scoreMapper.selectByStudentId(person.getPerson_num());
                        for (Glory glory : glories) {
                            glory_number++;
                        }
                        Double sum = 0.0;
                        for (Score score : scores) {
                            Course course = courseMapper.selectById(score.getCourse_id());
                            Double credit = course.getCredit();
                            sum += credit;
                            score1 += score.getMark() * credit;
                        }
                        if (scores.size() != 0) {
                            score1 = score1 / sum;//个人平均成绩
                            if (score1 > highest_score) {
                                highest_score = score1;
                            }
                            if (score1 < lowest_score) {
                                lowest_score = score1;
                            }
                            average_score += score1;//总成绩
                        }
                        if (count != 0) {
                            average_score = average_score / count;
                        } else if (count == 0) {
                            average_score = 0.0;
                        }
                    }
                    Map<String, Object> map = new HashMap<>();
                    map.put("grade", grade);
                    map.put("classes", classes);
                    map.put("male", male + "");
                    map.put("female", female + "");
                    map.put("party_member", party_member + "");
                    map.put("league_member", league_member + "");
                    map.put("glory_number", glory_number + "");
                    map.put("activity_number", activity_number + "");
                    map.put("average_score", average_score + "");
                    map.put("highest_score", highest_score + "");
                    map.put("lowest_score", lowest_score + "");
                    map.put("le_18", le_18 + "");
                    map.put("ge_19", ge_19 + "");
                    list.add(map);
                }
            }
        }
        return list;
    }
}
