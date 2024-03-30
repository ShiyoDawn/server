package org.example.server.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.server.mapper.StudentMapper;
import org.example.server.pojo.Person;
import org.example.server.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public Map findStudentByName(String student_name) {
        //QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        //queryWrapper.like("student_name", student_Name);
        //上面两行是mp提供的模糊搜索，试了一下但不太会用，感觉没必要，以后再说；
        Student student = studentMapper.findByStudentName(student_name);
        /*Map m = new HashMap();
        m.put("id", student.getId());
        m.put("person_id", student.getPerson_id());
        m.put("student_name", student.getStudent_name());
        m.put("department", student.getDepartment());
        m.put("classes", student.getClasses());
        m.put("grade", student.getGrade());
        m.put("major", student.getMajor());*/
        return studentAdderMap(student);
    }

    public List getStudentMapList() {
        List<Student> students = studentMapper.findAllStudent();
        /*List list = new ArrayList();
        if (students == null || students.size() == 0)
            return list;
        Map m;
        for (Student s : students) {
            m = new HashMap();
            m.put("id", s.getId());
            m.put("person_id", s.getPerson_id());
            m.put("student_name", s.getStudent_name());
            m.put("department", s.getDepartment());
            m.put("classes", s.getClasses());
            m.put("grade", s.getGrade());
            m.put("major", s.getMajor());
            list.add(m);
        }*/

        return studentMapList(students);
    }

    public List<Student> searchStudentByDepartment(String department) {
        List<Student> departmentStudentMember = studentMapper.findByDepartment(department);
        return departmentStudentMember;
    }

    public List getDepartmentMemberList(String department) {
        List<Student> departmentStudentMember = studentMapper.findByDepartment(department);
        /*List list = new ArrayList();
        if (departmentStudentMember == null || departmentStudentMember.size() == 0)
            return list;
        Map m;
        for (Student s : departmentStudentMember) {
            m = new HashMap();
            m.put("id", s.getId());
            m.put("person_id", s.getPerson_id());
            m.put("student_name", s.getStudent_name());
            m.put("department", s.getDepartment());
            m.put("classes", s.getClasses());
            m.put("grade", s.getGrade());
            m.put("major", s.getMajor());
            list.add(m);
        }*/
        return studentMapList(departmentStudentMember);
    }


    public Map getMapFromStudent(Student student) {
        Map map = new HashMap();
        if (student == null) {
            return map;
        }
        //Person person = new Person();

        map.put("id", student.getId());
        map.put("person_id", student.getPerson_id());
        map.put("student_name", student.getStudent_name());
        map.put("department", student.getDepartment());
        map.put("classes", student.getClasses());
        map.put("grade", student.getGrade());
        map.put("major", student.getMajor());
        return map;

    }
    public Map findStudentByPid(Integer person_id){
        Student student=studentMapper.selectByPid(person_id);
        /*Map map = new HashMap();
        if (student == null) {
            return map;
        }
        //Person person = new Person();

        map.put("id", student.getId());
        map.put("person_id", student.getPerson_id());
        map.put("student_name", student.getStudent_name());
        map.put("department", student.getDepartment());
        map.put("classes", student.getClasses());
        map.put("grade", student.getGrade());
        map.put("major", student.getMajor());*/
        return studentAdderMap(student);
    }
    //简化代码
    public Map studentAdderMap(Student student){
        Map map = new HashMap();
        if (student == null) {
            return map;
        }
        //Person person = new Person();

        map.put("id", student.getId());
        map.put("person_id", student.getPerson_id());
        map.put("student_name", student.getStudent_name());
        map.put("department", student.getDepartment());
        map.put("classes", student.getClasses());
        map.put("grade", student.getGrade());
        map.put("major", student.getMajor());
        return map;
    }
    public List studentMapList(List<Student> students){
        List list = new ArrayList();
        if (students == null || students.size() == 0)
            return list;
        Map m;
        for (Student s : students) {
            m = new HashMap();
            m.put("id", s.getId());
            m.put("person_id", s.getPerson_id());
            m.put("student_name", s.getStudent_name());
            m.put("department", s.getDepartment());
            m.put("classes", s.getClasses());
            m.put("grade", s.getGrade());
            m.put("major", s.getMajor());
            list.add(m);
        }

        return list;
    }

    public Boolean changeSNameByPid(Integer personId, String student_name) {
        Student student = studentMapper.selectByPid(personId);
        if (student == null) {
            return false; // 学生不存在
        }
        studentMapper.updateStudentName(student_name,personId);
        return true;
    }
}
