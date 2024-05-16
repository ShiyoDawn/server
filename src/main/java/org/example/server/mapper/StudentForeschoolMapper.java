package org.example.server.mapper;

import org.example.server.pojo.StudentForeschool;

public interface StudentForeschoolMapper {
    StudentForeschool selectStudentForeSchoolByStudent_id(Integer student_id);
}
