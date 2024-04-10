package org.example.server.Service;

import org.example.server.mapper.StudentFamilyMapper;
import org.example.server.mapper.StudentMapper;
import org.example.server.payload.request.DataRequest;
import org.example.server.pojo.Student;
import org.example.server.pojo.StudentFamily;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentFamilyService {

    @Autowired
    private StudentFamilyMapper studentFamilyMapper;
    @Autowired
    private StudentMapper studentMapper;
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
    public void saveFamilyMember(DataRequest dataRequest){
        Integer student_id = dataRequest.getInteger("studentId");
        List<StudentFamily> list;
        StudentFamily f = null;
        if(student_id != null) {
            list = studentFamilyMapper.findFamilyByStudentId(student_id);
            if(list.isEmpty()) {
                for (int i=0;i<list.size();i++){
                    f = list.get(1);
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
                }
            }
        }
    }
    public void deleteFamilyMember(DataRequest dataRequest){
        Integer student_id = dataRequest.getInteger("studentId");
        List<StudentFamily> list;
        list = studentFamilyMapper.findFamilyByStudentId(student_id);
        if(list.isEmpty()) {
            studentFamilyMapper.deleteByStudentId(student_id);
        }
    }
    public void deleteFamilyMember(Integer person_id){
        Student student=studentMapper.selectByPid(person_id);
        List studentFamily=studentFamilyMapper.findFamilyByStudentId(student.getId());
        if(studentFamily.isEmpty()){
            return;
        }
        studentFamilyMapper.deleteByPid(person_id);
        return;
    }

}

