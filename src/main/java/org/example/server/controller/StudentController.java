package org.example.server.controller;

import org.example.server.Service.StudentService;
import org.example.server.mapper.StudentMapper;
import org.example.server.payload.request.DataRequest;
import org.example.server.payload.response.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;//为什么要在controller里面注入mapper？应该是StudentService吧
    @Autowired
    private StudentService studentService;
//查
    //查询所有学生；
    @GetMapping("/getStudentList")
    public DataResponse getStudentList() {
        return DataResponse.success(studentService.getStudentMapList());
    }
    //通过姓名查询特定学生；
    @GetMapping("/selectStudentByName")
    public DataResponse selectStudentByName(@RequestParam String student_name) {
        return DataResponse.success(studentService.findStudentByName(student_name));
    }
    //通过id查询学生，仅一人；
    @GetMapping("/selectStudentByPid")
    public DataResponse selectStudentByPid(@RequestParam Integer person_id){
        return DataResponse.success(studentService.findStudentByPid(person_id));
    }
//增
    //增加一个学生，指定姓名；
    @PostMapping("/updateStudentName")
    public Boolean refactorStudentInfo(@RequestParam Integer person_id,@RequestParam String student_name){
        return studentService.changeSNameByPid(person_id,student_name);
    }

    @PostMapping("/insertStudent")
    public DataResponse insert(@RequestParam Integer person_id,@RequestParam String student_name,@RequestParam String department,@RequestParam String classes,@RequestParam String grade,@RequestParam String major){
        return DataResponse.success(studentService.insert(person_id,student_name,department,classes,grade,major),"增添成功！");
    }
}
