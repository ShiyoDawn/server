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

    void insertStudent(Integer person_id,String student_name,String department,String classes,String grade,String major);

    Student findByStudentName(String student_name);

    List<Student> findAllStudent();

    List<Student> findByDepartment(String department);

    public Student selectById(Integer id);
    public Student selectByPid(Integer person_id);
    public Integer updateStudentName(String student_name,Integer person_id);

    public void updateStudentDepartment(String student_name,String department);

    public  void updateStudentGrade(String student_name, String grade);

    public  void updateStudentMajor(String student_name, String major);
}
