package org.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.server.pojo.Student;

import java.util.List;
import java.util.Optional;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    Optional<Student> findByPersonId(Integer personId);

    Optional<Student> findByPersonNum(String personNum);

    List<Student> findByPersonName(String personName);

    List<Student> findByStudentName(String studentName);
    List<Student> findByDepartment(String department);

    public Student selectById(Integer id);
}
