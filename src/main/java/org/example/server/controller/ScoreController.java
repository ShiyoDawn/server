package org.example.server.controller;

import org.example.server.Service.ScoreService;
import org.example.server.mapper.CourseMapper;
import org.example.server.mapper.ScoreMapper;
import org.example.server.mapper.StudentMapper;
import org.example.server.pojo.Score;
import org.example.server.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String insert(@RequestParam Integer id,@RequestParam Integer student_id,@RequestParam Integer course_id,@RequestParam Integer mark){
        scoreService.insert(student_id,course_id,mark);
        return "增加成功！";
    }

    @PostMapping("/deleteScore")
    public String delete(@RequestParam Integer student_id,@RequestParam Integer course_id,@RequestParam Integer id) {
        scoreService.deleteById(student_id,course_id,id);
        return "删除成功！";
    }
    @PostMapping("/updateScore")
    public String update(@RequestParam Integer student_id,@RequestParam Integer course_id,@RequestParam Integer id,@RequestParam Integer mark){
        scoreService.update(student_id,course_id,id,mark);
        return "更新成功！";
    }
    @PostMapping("/selectScore")
    public String select(@RequestParam Integer student_id,@RequestParam Integer course_id,@RequestParam Integer id,@RequestParam Integer mark){
        scoreService.select(student_id,course_id);
        return "查询成功！";
    }

}

