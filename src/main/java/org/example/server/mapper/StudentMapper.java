package org.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.server.pojo.Student;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    void insertStudent(Integer person_id,String student_name,String department,String classes,String grade,String major);

    Student findByStudentName(String student_name);

    List<Student> findAllStudent();

    List<Student> findByDepartment(String department);

    Student selectById(Integer id);
    Student selectByPid(Integer person_id);
    Integer updateStudentName(String student_name,Integer person_id);

    void updateStudent(Integer person_id,String student_name,String department,String classes,String grade,String major);

    void updateStudentGrade(String student_name, String grade);

    void updateStudentMajor(String student_name, String major);
    //删
    //void deleteStudentByName(String student_name);不安全

    void deleteStudentByPidAndName(Integer person_id,String student_name);
//联表功能
    //Student和StudentFamily
    //查
    Student selectStudentAndStudentFamilyById(Integer id);

    List<Student> selectByConditions(Map<String, Object> conditions);
    //改
    //Student updateStudentAndStudentFamily()???
}
