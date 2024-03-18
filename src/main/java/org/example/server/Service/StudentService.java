package org.example.server.Service;

import org.example.server.pojo.Person;
import org.example.server.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    public Map getMapFromStudent(Student student){
        Map map = new HashMap();
        if(student == null) {
            return map;
        }
        //Person person = new Person();

        map.put("id",student.getId());
        map.put("person_id",student.getPerson_id());
        map.put("student_name",student.getStudent_name());
        map.put("department",student.getDepartment());
        map.put("classes",student.getClasses());
        map.put("grade",student.getGrade());
        map.put("major",student.getMajor());
        return map;

    }
    public List getStudentMapList(String )
}
