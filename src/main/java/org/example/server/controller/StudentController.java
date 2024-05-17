package org.example.server.controller;

import org.example.server.Service.StudentService;
import org.example.server.mapper.PersonMapper;
import org.example.server.mapper.StudentMapper;
import org.example.server.payload.Result;
import org.example.server.payload.request.DataRequest;
import org.example.server.payload.response.DataResponse;
import org.example.server.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private PersonMapper personMapper;

    //查
    //查询所有学生；
    @PostMapping("/getStudentList")
    public Result getStudentList() {
        return Result.success(studentService.getStudentMapList());
    }//用

    //通过姓名查询特定学生；
    @PostMapping("/selectStudentByName")
    public Result selectStudentByName(@Valid @RequestBody DataRequest dataRequest) {
        String student_name = dataRequest.getString("student_name");
        return Result.success(studentService.findStudentByName(student_name));
    }

    //通过id查询学生，仅一人；
    @PostMapping("/selectStudentByPid")
    public Result selectStudentByPid(@RequestBody DataRequest dataRequest) {
        Integer person_id = dataRequest.getInteger("person_id");
        return Result.success(studentService.findStudentByPid(person_id));
    }

    //改
    //修改学生姓名
    @PostMapping("/updateStudentName")
    public void updateStudentName(@RequestParam Integer person_id, @RequestParam String student_name) {
        studentService.changeSNameByPid(person_id, student_name);
    }//用

    //通过姓名改学生部门
    @PostMapping("/updateStudent")
    public Result updateStudent(@RequestBody DataRequest dataRequest) {
        Integer id = Integer.parseInt(dataRequest.getString("id"));
        String person_num = dataRequest.getString("person_num");
        String student_name = dataRequest.getString("student_name");
        String department = dataRequest.getString("department");
        String classes = dataRequest.getString("classes");
        String grade = dataRequest.getString("grade");
        String major = dataRequest.getString("major");
        updateStudentName(id, student_name);
        studentService.updateStudent(id, student_name, department, classes, grade, major);
        Map m=new HashMap<>();
        m.put("id",id);
        m.put("person_num",person_num);
        personMapper.updatePerson(m);
        return Result.ok("修改成功！");
    }


    //增
    //增加一个学生，指定姓名；
    @PostMapping("/insertStudent")
    public Result insert(@RequestBody DataRequest dataRequest) {
        Integer person_id = dataRequest.getInteger("person_id");
        String person_num = dataRequest.getString("person_num");
        String student_name = dataRequest.getString("student_name");
        String department = dataRequest.getString("department");
        String classes = dataRequest.getString("classes");
        String grade = dataRequest.getString("grade");
        String major = dataRequest.getString("major");
        String s=studentService.insert(person_id, person_num, student_name, department, classes, grade, major);
        if (s.equals("学生已存在")){
            return Result.error(500,s);
        } else if (s.equals("人员不存在")){
            return Result.error(500,s);
        } else {
            return Result.ok(s);
        }

    }//用

    //删除一个学生，包括其家庭信息，其余信息等待联接表关系后进行编写；
    @PostMapping("/deleteStudent")
    public Result deleteStudent(@RequestBody DataRequest dataRequest) {
        Integer id = Integer.parseInt(dataRequest.getString("id"));
        String student_name = dataRequest.getString("student_name");
        studentService.deleteStudent(id, student_name);
        return Result.ok();
    }//用

    @PostMapping("/getStudentInfo")
    public Result getStudentById(@RequestBody DataRequest dataRequest) {
        Integer id = dataRequest.getInteger("id");
        return Result.success(studentService.getStudentInfoById(id));
    }//用
    //通过姓名改学生年级
//    @PostMapping("/updateStudentGrade")
//    public Result updateStudentGrade(@RequestParam String student_name, @RequestParam String grade) {
//        return Result.success(studentService.updateStudentGrade(student_name, grade));
//    }

    //通过姓名改学生专业
//    @PostMapping("/updateStudentMajor")
//    public Result updateStudentMajor(@RequestParam String student_name, @RequestParam String major) {
//        return Result.success(studentService.updateStudentMajor(student_name, major));
//    }
    //这个方法废了
//    @PostMapping("/selectStudent")
//    public List<Student> selectStudent(@RequestBody DataRequest request) {
//        Map<String, Object> requestData = request.getData();
//
//        // 调用服务层方法进行动态查询
//        List<Student> students = studentService.selectStudentByConditions(requestData);
//        return students;
//    }
//    @GetMapping("/selectByStudentIdWithStudentFamily")
//    public Result selectByStudentIdWithStudentFamily(@RequestParam Integer id){
//        return Result.success(studentService.selectByStudentIdWithStudentFamily(id));
//    }
}
