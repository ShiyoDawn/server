package org.example.server.Service;

import org.example.server.mapper.CourseMapper;
import org.example.server.mapper.PersonMapper;
import org.example.server.mapper.ScoreMapper;
import org.example.server.mapper.StudentMapper;
import org.example.server.payload.Result;
import org.example.server.payload.request.DataRequest;

import org.example.server.pojo.Course;
import org.example.server.pojo.Person;
import org.example.server.pojo.Score;
import org.example.server.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.*;


//！！！这里面根据更新的分数从而更新排名的逻辑有点小问题，之后再删改！！！
@Service
public class ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private PersonMapper personMapper;

    //增添分数
    public Result insertScore(String student_num, String course_num, Double mark) {
        Person person = personMapper.selectByPersonNum(student_num);
        Course course = courseMapper.selectByNum(course_num);
        Score score = new Score();
        score.setStudent_num(student_num);
        score.setCourse_num(course_num);
        score.setStudent_name(person.getPerson_name());
        score.setCourse_name(course.getCourse_name());
        score.setMark(mark);
        score.setPerson(person);
        score.setCourse(course);
        scoreMapper.insertMark(score);

        return Result.ok("添加成功！");
    }

    //删除分数
    public Result deleteOnlyScore(String student_num, String course_num) {
        scoreMapper.deleteOnlyScore(student_num, course_num);

        //modifyStudentRanking(course_id);
        return Result.ok("删除成功！");
    }

    public Result deleteAllById(String student_num, String course_num) {
        scoreMapper.deleteForAll(student_num, course_num);

        //modifyStudentRanking(course_id);
        return Result.ok("删除成功！");
    }

    //修改分数
    public Result updateScoreAndRanking(String student_num, String course_num, Double mark) {
        scoreMapper.updateMark(student_num, course_num, mark);
        //Integer studentRanking = scoreMapper.calculateRanking(student_id,course_id, mark);
        //scoreMapper.updateRanking(student_id, course_id, studentRanking);
        //modifyStudentRanking(course_id);
        return Result.ok("修改成功！");
    }

    //查询分数
    public Result selectByStudentAndCourse(String student_num, String course_num) {
        Score score = scoreMapper.selectByStudentAndCourse(student_num, course_num);
        if(score!=null){
            return Result.success(score, "查询成功！");
        }
        return null;
    }

/*    public Result selectByStudentId(String student_num) {
        Person person = personMapper.selectByPersonNum(student_num);
        List<Score> scoreList = scoreMapper.selectByStudentId(student_num);
        List<Map> scoreMap = new ArrayList<>();
        Integer cnt=0;
        for (Score score : scoreList) {
            String course_num = score.getCourse_num();
            Course course=courseMapper.selectInfo(score.getCourse_id());
            person=personMapper.selectById(score.getPerson_id());
            score.setCourse(course);
            score.setPerson(person);
            score.setStudent_num(person.getPerson_num());
            score.setStudent_name(person.getPerson_name());
            score.setCourse_num(course.getNum());
            score.setCourse_name(course.getCourse_name());
            Map map = new HashMap();
            map.put("id", ++cnt + "");
            map.put("student_num", person.getPerson_num());
            map.put("student_name", person.getPerson_name());
            map.put("course_num", course.getNum());
            map.put("course_name", course.getCourse_name());
            map.put("credit", course.getCredit() + "");
            map.put("mark", score.getMark() + "");
            scoreMap.add(map);
        }
        return Result.success(scoreMap, "查询成功！");
    }*/

    public Result selectByStudentName(String student_name) {
        Student student = studentMapper.findByStudentName(student_name);
        Person person = personMapper.selectById(student.getPerson_id());
        String student_num = person.getPerson_num();
        List<Score> scoreList = scoreMapper.selectByStudentId(student_num);
        List<Map> scoreMap = new ArrayList<>();
        for (Score score : scoreList) {
            String course_num = score.getCourse_num();
            Course course=courseMapper.selectByNum(course_num);
            Map map = new HashMap();
            map.put("id", score.getId() + "");
            map.put("student_num", person.getPerson_num());
            map.put("student_name", person.getPerson_name());
            map.put("course_num", course.getNum());
            map.put("course_name", course.getCourse_name());
            map.put("credit", course.getCredit() + "");
            map.put("mark", score.getMark() + "");
            scoreMap.add(map);
        }
        return Result.success(scoreMap, "查询成功！");
    }

    public Result selectByCourseId(String course_num) {
        Course course = courseMapper.selectByNum(course_num);
        List<Score> scoreList = scoreMapper.selectByCourseId(course_num);
        List<Map> scoreMap = new ArrayList<>();
        for (Score score : scoreList) {
            Person person=personMapper.selectById(score.getPerson_id());
            Map map = new HashMap();
            score.setPerson(person);
            score.setStudent_num(person.getPerson_num());
            score.setStudent_name(person.getPerson_name());
            map.put("id", score.getId() + "");
            map.put("student_num", person.getPerson_num());
            map.put("student_name", person.getPerson_name());
            map.put("course_num", course.getNum());
            map.put("course_name", course.getCourse_name());
            map.put("credit", course.getCredit() + "");
            map.put("mark", score.getMark() + "");
            scoreMap.add(map);
        }
        return Result.success(scoreMap, "查询成功！");
    }


    /*public Result selectByCourseName(String course_name) {
        String course_num = courseMapper.selectCourseByName(course_name).getNum();
        System.out.println(course_name + " " + course_num);
        List<Score> scoreList = scoreMapper.selectByCourseId(course_num);
        List<Map> scoreMap = new ArrayList<>();
        for (Score score : scoreList) {
            Double credit = courseMapper.selectByNum(course_num).getCredit();
            Map map = new HashMap();
            map.put("id", score.getId() + "");
            map.put("student_num", score.getStudent_num());
            map.put("student_name", score.getStudent_name());
            map.put("course_num", score.getCourse_num());
            map.put("course_name", score.getCourse_name());
            map.put("credit", credit + "");
            map.put("mark", score.getMark() + "");
            scoreMap.add(map);
        }
        return Result.success(scoreMap, "查询成功！");
    }*/


    public Result getScoreList() {
        //int offset = (pageNum - 1) * pageSize;
        List<Score> scoreList = scoreMapper.selectAll();
        List<Map<String, String>> dataList = new ArrayList();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < scoreList.size(); i++) {
            map = new HashMap();
            map.put("id", i + 1 + "");
            Person person=personMapper.selectById(scoreList.get(i).getPerson().getId());
            Course course=courseMapper.selectInfo(scoreList.get(i).getCourse().getId());
            scoreList.get(i).setStudent_num(person.getPerson_num());
            scoreList.get(i).setStudent_name(person.getPerson_name());
            scoreList.get(i).setCourse_num(course.getNum());
            scoreList.get(i).setCourse_name(course.getCourse_name());
            scoreList.get(i).setCourse(course);
            scoreList.get(i).setPerson(person);
            map.put("student_num", person.getPerson_num());
            map.put("student_name", person.getPerson_name());
            map.put("course_num", course.getNum());
            map.put("course_name", course.getCourse_name());
            map.put("credit", course.getCredit()+"");
            map.put("mark", scoreList.get(i).getMark() + "");
            /*System.out.println(person);
            System.out.println(course);
            System.out.println();*/
            //map.put("id", scoreList.get(i).getId() + "");
            //map.put("ranking", s.getRanking() + "");
            dataList.add(map);
        }
        return Result.success(dataList);
    }

    public Result scoreSave(@Valid @RequestBody DataRequest dataRequest) {
        Integer studentId = dataRequest.getInteger("student_id");
        Integer courseId = dataRequest.getInteger("course_id");
        Double mark = dataRequest.getDouble("mark");
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
                return Result.error(404, "Student does not exist.");
            } else if (student != null && course == null) {
                return Result.error(404, "Course does not exist.");
            } else if (student == null && course == null) {
                return Result.error(404, "Course and Student do not exist.");
            } else {
                score.setStudent_name(student.getStudent_name());
                score.setCourse_name((course.getCourse_name()));
            }
        }
        score.setMark(mark);
        scoreMapper.saveScore(score);
        return Result.ok();
    }


    /*public void modifyStudentRanking(Integer course_id){
        List<Score> scoreList = scoreMapper.selectByCourseId(course_id);
        for (Score score : scoreList) {
            Integer newStudent_Id = score.getStudent_id();
            Integer newCourse_Id = score.getCourse_id();
            Integer newMark = score.getMark();
            Integer newRanking = scoreMapper.calculateRanking(newStudent_Id, newCourse_Id, newMark);
            scoreMapper.updateRanking(newStudent_Id, newCourse_Id, newRanking);
        }
    }*/
    //给按某课程分数排序(暂时不知道需不需要)
    //升序排序
    public List<Score> getScoreSorted_Ascending(String course_num) {
        return scoreMapper.getScoreSorted_Ascending(course_num);
    }

    //降序排序
    public List<Score> getScoreSorted_Descending(String course_num) {
        return scoreMapper.getScoreSorted_Descending(course_num);
    }

}
