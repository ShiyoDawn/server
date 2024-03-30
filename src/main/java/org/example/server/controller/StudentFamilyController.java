package org.example.server.controller;

import org.example.server.Service.StudentFamilyService;
import org.example.server.mapper.StudentFamilyMapper;
import org.example.server.payload.request.DataRequest;
import org.example.server.payload.response.DataResponse;
import org.example.server.pojo.StudentFamily;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/studentFamily")
public class StudentFamilyController {
    @Autowired
    StudentFamilyService studentFamilyService;
    @Autowired
    StudentFamilyMapper studentFamilyMapper;
    @GetMapping("/selectStudentFamilyMember")
    public DataResponse selectStudentFamilyMember(@RequestParam String student_name){
        return DataResponse.success(studentFamilyService.findFamilyMemberByStudentName(student_name));
    }
    @PostMapping("/familyMemberSave")
    public DataResponse familyMemberSave(@RequestParam DataRequest dataRequest) {
        Integer student_id = dataRequest.getInteger("studentId");
        Optional<StudentFamily> op;
        StudentFamily f = null;
        if(student_id != null) {
            op = studentFamilyMapper.findFamilyByStudentId(student_id);
            if(op.isPresent()) {
                f = op.get();
            }
        }
        if(f== null) {
            f = new StudentFamily();
        }
        f.setStudent_id(student_id);
        f.setStudent_name(dataRequest.getString("student_name"));
        f.setName("name");
        f.setPhone("phone");
        f.setAge("age");
        f.setJob("job");
        f.setAddress("address");
        f.setRelation("relation");
        return DataResponse.success(null,"保存成功");
    }
    @PostMapping("/familyMemberDelete")
    public DataResponse familyMemberDelete(@Valid @RequestBody DataRequest dataRequest) {
        Integer student_id = dataRequest.getInteger("studentId");
        Optional<StudentFamily> op;
        op = studentFamilyMapper.findFamilyByStudentId(student_id);
        if(op.isPresent()) {
            studentFamilyMapper.deleteByStudentId(student_id);
        }
        return DataResponse.success(null,"删除成功");
    }
}
