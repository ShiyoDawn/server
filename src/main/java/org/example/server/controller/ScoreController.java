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
    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private StudentMapper studentMapper;


    //增添/删减/修改学生的某个课程的分数(通过score本身id / student_id和course_id查询到对应的分数再进行修改？)
    @PostMapping("/insertScore")
    public String insert(@RequestParam Integer id, @RequestParam Integer student_id, @RequestParam Integer course_id, @RequestParam Integer mark) {
        scoreService.insert(id, student_id, course_id, mark);
        return "增加成功！";
    }

    @PostMapping("/deleteScore")
    public String delete(@RequestParam Integer student_id, @RequestParam Integer course_id, @RequestParam Integer id) {
        scoreService.deleteById(student_id, course_id, id);
        return "删除成功！";
    }

    @PostMapping("/updateScore")
    public String update(@RequestParam Integer student_id, @RequestParam Integer course_id, @RequestParam Integer id, @RequestParam Integer mark) {
        scoreService.update(student_id, course_id, id, mark);
        return "更新成功！";
    }

    @PostMapping("/selectByStudentAndCourse")
    public DataResponse selectByStudentAndCourse(@RequestParam Integer student_id, @RequestParam Integer course_id) {
        return DataResponse.success(scoreService.selectByStudentAndCourse(student_id, course_id), "查询成功!");
    }

    @PostMapping("/selectByStudentId")
    public DataResponse selectByStudentId(@RequestParam Integer student_id) {
        return DataResponse.success(scoreService.selectByStudentId(student_id), "查询成功！");
    }

    @PostMapping("/selectByCourseId")
    public DataResponse selectByCourseId(@RequestParam Integer course_id) {
        return DataResponse.success(scoreService.selectByCourseId(course_id), "查询成功！");
    }

    @PostMapping("/getScoreList")
    public DataResponse getScoreList(@Valid @RequestBody DataRequest dataRequest) {
        return scoreService.getScoreList(dataRequest);
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
