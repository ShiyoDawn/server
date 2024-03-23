package org.example.server.controller;

import org.example.server.Service.ScoreService;
import org.example.server.mapper.CourseMapper;
import org.example.server.mapper.ScoreMapper;
import org.example.server.mapper.StudentMapper;
import org.example.server.pojo.Score;
import org.example.server.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


    @PostMapping("/insertScore")
    public String insert(@RequestParam Integer id){
        scoreService.insert(id);
        return "增加成功！";
    }

    @PostMapping("/deleteScore")
    public String delete(@RequestParam Integer id) {
        scoreService.deleteById(id);
        return "删除成功！";
    }
    @PostMapping("updateScore")
    public String update(@RequestParam Integer id,@RequestParam Integer new_score){
        scoreService.update(id,new_score);
        return "更新成功！";
    }
}
