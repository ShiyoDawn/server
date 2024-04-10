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
        Optional<StudentFamily> op;
        StudentFamily f = null;
        if(student_id != null) {
            op = studentFamilyMapper.findFamilyByStudentId(student_id);
            if(op.isPresent()) {
                f = op.get();
            }
        }
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
    public void deleteFamilyMember(DataRequest dataRequest){
        Integer student_id = dataRequest.getInteger("studentId");
        Optional<StudentFamily> op;
        op = studentFamilyMapper.findFamilyByStudentId(student_id);
        if(op.isPresent()) {
            studentFamilyMapper.deleteByStudentId(student_id);
        }
    }
    public void deleteFamilyMember(Integer person_id){
        Student student=studentMapper.selectByPid(person_id);
        List studentFamily=studentFamilyMapper.findFamilyByStudentName(student.getStudent_name());
        if(studentFamily.isEmpty()){
            return;
        }
        deleteFamilyMember(person_id);
        return;
    }

}

