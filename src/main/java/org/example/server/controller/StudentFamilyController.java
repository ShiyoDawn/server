package org.example.server.controller;

import org.example.server.Service.StudentFamilyService;
import org.example.server.mapper.StudentFamilyMapper;
import org.example.server.payload.request.DataRequest;
import org.example.server.payload.response.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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
        studentFamilyService.saveFamilyMember(dataRequest);
        return DataResponse.success(null,"保存成功");
    }
    @PostMapping("/familyMemberDelete")
    public DataResponse familyMemberDelete(@Valid @RequestBody DataRequest dataRequest) {
        studentFamilyService.deleteFamilyMember(dataRequest);
        return DataResponse.success(null,"删除成功");
    }
}
