package org.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.server.pojo.Student;
import org.example.server.pojo.StudentFamily;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Mapper
public interface StudentFamilyMapper extends BaseMapper<StudentFamily> {
    List<StudentFamily> findFamilyByStudentName(String student_name);
    Optional<StudentFamily> findFamilyByStudentId(Integer student_id);

    void deleteByStudentId(Integer studentId);
    void deleteByPid(Integer person_id);
}