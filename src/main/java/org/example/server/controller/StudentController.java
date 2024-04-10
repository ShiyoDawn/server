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
    public DataResponse selectStudentByPid(@RequestParam Integer person_id) {
        return DataResponse.success(studentService.findStudentByPid(person_id));
    }

    //改
    //修改学生姓名
    @PostMapping("/updateStudentName")
    public Boolean updateStudentName(@RequestParam Integer person_id, @RequestParam String student_name) {
        return studentService.changeSNameByPid(person_id, student_name);
    }

    //通过姓名改学生部门
    @PostMapping("/updateStudentDepartment")
    public DataResponse updateStudentDepartment(@RequestParam String student_name, @RequestParam String department) {
        return DataResponse.success(studentService.updateStudentDepartment(student_name, department));
    }

    //通过姓名改学生年级
    @PostMapping("/updateStudentGrade")
    public DataResponse updateStudentGrade(@RequestParam String student_name, @RequestParam String grade) {
        return DataResponse.success(studentService.updateStudentGrade(student_name, grade));
    }

    //通过姓名改学生专业
    @PostMapping("/updateStudentMajor")
    public DataResponse updateStudentMajor(@RequestParam String student_name, @RequestParam String major) {
        return DataResponse.success(studentService.updateStudentMajor(student_name, major));
    }

    //增
    //增加一个学生，指定姓名；
    @PostMapping("/insertStudent")
    public DataResponse insert(@RequestParam Integer person_id, @RequestParam String student_name, @RequestParam String department, @RequestParam String classes, @RequestParam String grade, @RequestParam String major) {
        return DataResponse.success(studentService.insert(person_id, student_name, department, classes, grade, major), "增添成功！");
    }
    @GetMapping("/selectByStudentIdWithStudentFamily")
    public DataResponse selectByStudentIdWithStudentFamily(@RequestParam Integer id){
        return DataResponse.success(studentService.selectByStudentIdWithStudentFamily(id));
    }
    //删除一个学生，包括其家庭信息，其余信息等待联接表关系后进行编写；
    @PostMapping("/deleteStudent")
    public DataResponse deleteStudent(@RequestParam Integer person_id,@RequestParam String student_name){
        studentService.deleteStudent(person_id,student_name);
        return DataResponse.ok();
    }
}
