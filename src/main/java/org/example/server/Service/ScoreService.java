package org.example.server.Service;

import org.example.server.mapper.CourseMapper;
import org.example.server.mapper.ScoreMapper;
import org.example.server.mapper.StudentMapper;
import org.example.server.payload.Result;
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


//！！！这里面根据更新的分数从而更新排名的逻辑有点小问题，之后再删改！！！
@Service
public class ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CourseMapper courseMapper;

    //增添分数
    public Result insertScore(Integer student_id, Integer course_id, Integer mark) {
        Student student = studentMapper.selectById(student_id);
        Course course = courseMapper.selectInfo(course_id);
        if (student == null || course == null) {
            // 处理学生或课程不存在的情况
            return Result.error(404, "Student or Course does not exist.");
        }
        Score score = scoreMapper.selectByStudentAndCourse(student_id, course_id);
        if (score != null) {
            return Result.error(404, "Score has existed.");
        }
        //scoreMapper.updateMark(student_id,course_id,mark);
        //Integer ranking = scoreMapper.calculateRanking(student_id,course_id, mark);
        scoreMapper.insertMark(student_id, student.getStudent_name(), course_id, course.getCourse_name(), mark);

        //根据加入成绩更新排名
        //Integer studentRanking = scoreMapper.calculateRanking(student_id,course_id, mark);
        //scoreMapper.updateRanking(student_id, course_id, studentRanking);

        //modifyStudentRanking(course_id);
        return Result.ok("添加成功！");
    }

    //删除分数
    public Result deleteOnlyScore(Integer student_id, Integer course_id) {
        Student student = studentMapper.selectById(student_id);
        if (student == null)
            return Result.error(404, "删除失败，该学生不存在");
        Course course = courseMapper.selectInfo(course_id);
        if (course == null)
            return Result.error(404, "删除失败，该课程不存在");

        scoreMapper.deleteOnlyScore(student_id, course_id);

        //modifyStudentRanking(course_id);
        return Result.ok("删除成功！");
    }

    public Result deleteAllById(Integer student_id, Integer course_id) {
        Student student = studentMapper.selectById(student_id);
        if (student == null)
            return Result.error(404, "删除失败，该学生不存在");
        Course course = courseMapper.selectInfo(course_id);
        if (course == null)
            return Result.error(404, "删除失败，该课程不存在");

        scoreMapper.deleteForAll(student_id, course_id);

        //modifyStudentRanking(course_id);
        return Result.ok("删除成功！");
    }

    //修改分数
    public Result updateScoreAndRanking(Integer student_id, Integer course_id, Integer mark) {
        Student student = studentMapper.selectById(student_id);
        if (student == null)
            return Result.error(404, "修改失败，该学生不存在");
        Course course = courseMapper.selectInfo(course_id);
        if (course == null)
            return Result.error(404, "修改失败，该课程不存在");

        scoreMapper.updateMark(student_id, course_id, mark);

        //Integer studentRanking = scoreMapper.calculateRanking(student_id,course_id, mark);
        //scoreMapper.updateRanking(student_id, course_id, studentRanking);
        //modifyStudentRanking(course_id);
        return Result.ok("修改成功！");
    }

    //查询分数
    public Result selectByStudentAndCourse(Integer student_id, Integer course_id) {
        Student student = studentMapper.selectById(student_id);
        if (student == null)
            return Result.error(404, "查询失败，该学生不存在");
        Course course = courseMapper.selectInfo(course_id);
        if (course == null)
            return Result.error(404, "查询失败，该课程不存在");
        Score score=scoreMapper.selectByStudentAndCourse(student_id, course_id);
        Double credit=courseMapper.selectInfo(course_id).getCredit();
        Map map=new HashMap();
        map.put("id",score.getId()+"");
        map.put("student_id",score.getStudent_id()+"");
        map.put("student_name",score.getStudent_name()+"");
        map.put("course_id",score.getCourse_id()+"");
        map.put("course_name",score.getCourse_name()+"");
        map.put("credit",credit+"");
        map.put("mark",score.getMark()+"");
        System.out.println(map);
        return Result.success(map,"查询成功！");
    }

    public Result selectByStudentId(Integer student_id) {
        Student student = studentMapper.selectById(student_id);
        if (student == null)
            return Result.error(404, "查询失败，该学生不存在");
        List<Score> scoreList=scoreMapper.selectByStudentId(student_id);
        List<Map> scoreMap=new ArrayList<>();
        for(Score score:scoreList){
            Integer course_id=score.getCourse_id();
            Double credit=courseMapper.selectInfo(course_id).getCredit();
            Map map=new HashMap();
            map.put("id",score.getId()+"");
            map.put("student_id",score.getStudent_id()+"");
            map.put("student_name",score.getStudent_name()+"");
            map.put("course_id",score.getCourse_id()+"");
            map.put("course_name",score.getCourse_name()+"");
            map.put("credit",credit+"");
            map.put("mark",score.getMark()+"");
            scoreMap.add(map);
        }
        return Result.success(scoreMap, "查询成功！");
    }

    public Result selectByStudentName(String student_name) {
        Student student = studentMapper.findByStudentName(student_name);
        Integer studentId = student.getId();
        if (student == null)
            return Result.error(404, "查询失败，该学生不存在");
        List<Score> scoreList=scoreMapper.selectByStudentId(studentId);
        List<Map> scoreMap=new ArrayList<>();
        for(Score score:scoreList){
            Integer course_id=score.getCourse_id();
            Double credit=courseMapper.selectInfo(course_id).getCredit();
            Map map=new HashMap();
            map.put("id",score.getId()+"");
            map.put("student_id",score.getStudent_id()+"");
            map.put("student_name",score.getStudent_name()+"");
            map.put("course_id",score.getCourse_id()+"");
            map.put("course_name",score.getCourse_name()+"");
            map.put("credit",credit+"");
            map.put("mark",score.getMark()+"");
            scoreMap.add(map);
        }
        return Result.success(scoreMap, "查询成功！");
    }

    public Result selectByCourseId(Integer course_id) {
        Course course = courseMapper.selectInfo(course_id);
        if (course == null)
            return Result.error(404, "查询失败，该课程不存在");
        List<Score> scoreList=scoreMapper.selectByCourseId(course_id);
        List<Map> scoreMap=new ArrayList<>();
        for(Score score:scoreList){
            Double credit=courseMapper.selectInfo(course_id).getCredit();
            Map map=new HashMap();
            map.put("id",score.getId()+"");
            map.put("student_id",score.getStudent_id()+"");
            map.put("student_name",score.getStudent_name()+"");
            map.put("course_id",score.getCourse_id()+"");
            map.put("course_name",score.getCourse_name()+"");
            map.put("credit",credit+"");
            map.put("mark",score.getMark()+"");
            scoreMap.add(map);
        }
        return Result.success(scoreMap, "查询成功！");
    }

    //未写由coursename得到courseid，故先放这，之后补

    public Result selectByCourseName(String course_name) {
        Integer course_id = courseMapper.selectCourseByName(course_name).getId();
        System.out.println(course_name + " " + course_id);
        List<Score> scoreList=scoreMapper.selectByCourseId(course_id);
        List<Map> scoreMap=new ArrayList<>();
        for(Score score:scoreList){
            Double credit=courseMapper.selectInfo(course_id).getCredit();
            Map map=new HashMap();
            map.put("id",score.getId()+"");
            map.put("student_id",score.getStudent_id()+"");
            map.put("student_name",score.getStudent_name()+"");
            map.put("course_id",score.getCourse_id()+"");
            map.put("course_name",score.getCourse_name()+"");
            map.put("credit",credit+"");
            map.put("mark",score.getMark()+"");
            scoreMap.add(map);
        }
        return Result.success(scoreMap, "查询成功！");
    }


    public Result getScoreList() {
        //int offset = (pageNum - 1) * pageSize;
        List<Score> scoreList = scoreMapper.selectAll();
        List<Map<String, String>> dataList = new ArrayList();
        Map<String, String> map = new HashMap<>();
        for(int i=0;i<scoreList.size();i++){
            scoreMapper.updateId(scoreList.get(i).getStudent_id(),scoreList.get(i).getCourse_id(),i+1);
        }
        for(Score score:scoreList){
            System.out.println(score.getId());
        }
        for (int i = 0; i < scoreList.size(); i++) {
            map = new HashMap();
            map.put("id",scoreList.get(i).getId()+"");
            //map.put("id", scoreList.get(i).getId() + "");
            map.put("student_id", scoreList.get(i).getStudent_id() + "");
            map.put("student_name", scoreList.get(i).getStudent_name());
            map.put("course_id", scoreList.get(i).getCourse_id() + "");
            map.put("course_name", scoreList.get(i).getCourse_name());
            map.put("credit", courseMapper.selectInfo(scoreList.get(i).getCourse_id()).getCredit() + "");
            map.put("mark", scoreList.get(i).getMark() + "");
            //map.put("ranking", s.getRanking() + "");
            dataList.add(map);
        }
        return Result.success(dataList);
    }

    public Result scoreSave(@Valid @RequestBody DataRequest dataRequest) {
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
    public List<Score> getScoreSorted_Ascending(Integer course_id) {
        return scoreMapper.getScoreSorted_Ascending(course_id);
    }

    //降序排序
    public List<Score> getScoreSorted_Descending(Integer course_id) {
        return scoreMapper.getScoreSorted_Descending(course_id);
    }

}
