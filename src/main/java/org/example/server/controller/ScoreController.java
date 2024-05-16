package org.example.server.controller;

import org.example.server.Service.CourseService;
import org.example.server.Service.ScoreService;
import org.example.server.Service.StudentService;
import org.example.server.mapper.CourseMapper;
import org.example.server.mapper.ScoreMapper;
import org.example.server.mapper.StudentMapper;
import org.example.server.payload.Result;
import org.example.server.payload.request.DataRequest;
import org.example.server.payload.response.DataResponse;
import org.example.server.pojo.Score;
import org.example.server.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.DoubleBuffer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    //增添/删减/修改学生的某个课程的分数
    @PostMapping("/insertScore")
    public Result insertScore(@Valid @RequestBody DataRequest dataRequest) {
        String student_num = dataRequest.getString("student_num");
        String course_num = dataRequest.getString("course_num");
        Double mark = dataRequest.getDouble("mark");
        return scoreService.insertScore(student_num, course_num, mark);
    }

    @PostMapping("/deleteScore")
    public Result deleteScoreById(@Valid @RequestBody DataRequest dataRequest) {
        String student_num = dataRequest.getString("student_num");
        String course_num = dataRequest.getString("course_num");
        return scoreService.deleteOnlyScore(student_num, course_num);
    }

    @PostMapping("/deleteAllById")
    public Result deleteAllById(@Valid @RequestBody DataRequest dataRequest) {
        String student_num = dataRequest.getString("student_num");
        String course_num = dataRequest.getString("course_num");
        return scoreService.deleteAllById(student_num, course_num);
    }

    @PostMapping("/updateScore")
    public Result updateScore(@Valid @RequestBody DataRequest dataRequest) {
        String student_num = dataRequest.getString("student_num");
        String course_num = dataRequest.getString("course_num");
        Double mark = dataRequest.getDouble("mark");
        return scoreService.updateScoreAndRanking(student_num, course_num, mark);
    }

    @PostMapping("/selectByStudentAndCourse")
    public Result selectByStudentAndCourse(@Valid @RequestBody DataRequest dataRequest) {
        String student_num = dataRequest.getString("student_num");
        String course_num = dataRequest.getString("course_num");
        System.out.println(student_num+" "+course_num);
        return scoreService.selectByStudentAndCourse(student_num, course_num);
    }

/*    @PostMapping("/selectByStudentNum")
    public Result selectByStudentId(@Valid @RequestBody DataRequest dataRequest) {
        String student_num = dataRequest.getString("student_num");
        System.out.println(student_num+"ok");
        return scoreService.selectByStudentId(student_num);
    }*/

    @PostMapping("/selectByStudentName")
    public Result selectByStudentName(@Valid @RequestBody DataRequest dataRequest) {
        String student_name = dataRequest.getString("student_name");
        return scoreService.selectByStudentName(student_name);
    }

    @PostMapping("/selectByCourseNum")
    public Result selectByCourseId(@Valid @RequestBody DataRequest dataRequest) {
        String course_num = dataRequest.getString("course_num");
        return scoreService.selectByCourseId(course_num);
    }


/*    @PostMapping("/selectByCourseName")
    public Result selectByCourseName(@Valid @RequestBody DataRequest dataRequest) {
        String course_name = dataRequest.getString("course_name");
        return scoreService.selectByCourseName(course_name);
    }*/


    @PostMapping("/getScoreList")
    public Result getScoreList() {
        return scoreService.getScoreList();
    }

    @PostMapping("/scoreSave")
    public Result scoreSave(@Valid @RequestBody DataRequest dataRequest) {
        return scoreService.scoreSave(dataRequest);
    }

    @PostMapping("/getScoreSorted_Ascending")
    public Result getScoreSorted_Ascending(@Valid @RequestBody DataRequest dataRequest) {
        String course_name = dataRequest.getString("course_name");
        List<Score> list = scoreService.getScoreSorted_Ascending(course_name);
        return Result.success(list);
    }

    @PostMapping("/getScoreSorted_Descending")
    public Result getScoreSorted_Descending(@Valid @RequestBody DataRequest dataRequest) {
        String course_name = dataRequest.getString("course_name");
        List<Score> list = scoreService.getScoreSorted_Descending(course_name);
        return Result.success(list);
    }
}
