package org.example.server.Service;

import org.example.server.mapper.StudentFamilyMapper;
import org.example.server.pojo.StudentFamily;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentFamilyService {

    @Autowired
    private StudentFamilyMapper studentFamilyMapper;
    public List findFamilyMemberByStudentName(String student_name){
        List<StudentFamily> studentFamilies=studentFamilyMapper.findFamilyByStudentName(student_name);
        List dataList = new ArrayList();
        Map m;
        if(studentFamilies==null){
            return null;
        }
        if (studentFamilies != null) {
            for (StudentFamily f : studentFamilies) {
                m = new HashMap();
                m.put("id",f.getId());
                m.put("student_id",f.getStudent_id());
                m.put("student_name",f.getStudent_name());
                m.put("name",f.getName());
                m.put("phone",f.getPhone());
                m.put("age",f.getAge());
                m.put("job",f.getJob());
                m.put("address",f.getAddress());
                m.put("relation",f.getRelation());
                dataList.add(m);
            }
        }
        return dataList;
    }

}

