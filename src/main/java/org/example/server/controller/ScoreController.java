package org.example.server.controller;

import org.example.server.Service.ScoreService;
import org.example.server.mapper.CourseMapper;
import org.example.server.mapper.ScoreMapper;
import org.example.server.mapper.StudentMapper;
import org.example.server.payload.request.DataRequest;
import org.example.server.payload.response.DataResponse;
import org.example.server.pojo.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    //增添/删减/修改学生的某个课程的分数
    @PostMapping("/insertScore")
    public DataResponse insertScore(@RequestParam Integer student_id, @RequestParam Integer course_id, @RequestParam Integer mark) {
        return scoreService.insertScore(student_id, course_id, mark);
    }

    @PostMapping("/deleteScore")
    public DataResponse deleteScoreById(@RequestParam Integer student_id, @RequestParam Integer course_id) {
        return scoreService.deleteOnlyScore(student_id, course_id);
    }

    @PostMapping("/deleteAllById")
    public DataResponse deleteAllById(@RequestParam Integer student_id, @RequestParam Integer course_id) {
        return scoreService.deleteAllById(student_id, course_id);
    }

    @PostMapping("/updateScore")
    public DataResponse updateScore(@RequestParam Integer student_id, @RequestParam Integer course_id, @RequestParam Integer mark) {
        return scoreService.updateScoreAndRanking(student_id, course_id, mark);
    }

    @PostMapping("/selectByStudentAndCourse")
    public DataResponse selectByStudentAndCourse(@RequestParam Integer student_id, @RequestParam Integer course_id) {
        return scoreService.selectByStudentAndCourse(student_id, course_id);
    }

    @PostMapping("/selectByStudentId")
    public DataResponse selectByStudentId(@RequestParam Integer student_id) {
        return scoreService.selectByStudentId(student_id);
    }

    @PostMapping("/selectByStudentName")
    public DataResponse selectByStudentName(@RequestParam String student_name) {
        return scoreService.selectByStudentName(student_name);
    }

    @PostMapping("/selectByCourseId")
    public DataResponse selectByCourseId(@RequestParam Integer course_id) {
        return scoreService.selectByCourseId(course_id);
    }


    /*@PostMapping("/selectByCourseName")
    public DataResponse selectByCourseName(@RequestParam String course_name){
        return scoreService.selectByCourseName(course_name);
    }*/


    @GetMapping("/getScoreList")
    public DataResponse getScoreList(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize) {
        return scoreService.getScoreList(pageNum,pageSize);
    }

    @PostMapping("/scoreSave")
    public DataResponse scoreSave(@Valid @RequestBody DataRequest dataRequest) {
        return scoreService.scoreSave(dataRequest);
    }

    @PostMapping("/getScoreSorted_Ascending")
    public DataResponse getScoreSorted_Ascending(@RequestParam Integer course_id) {
        List<Score> list = scoreService.getScoreSorted_Ascending(course_id);
        return DataResponse.success(list);
    }

    @PostMapping("/getScoreSorted_Descending")
    public DataResponse getScoreSorted_Descending(@RequestParam Integer course_id) {
        List<Score> list = scoreService.getScoreSorted_Descending(course_id);
        return DataResponse.success(list);
    }
}
