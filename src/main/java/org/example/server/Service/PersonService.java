package org.example.server.Service;

import org.example.server.mapper.PersonMapper;
import org.example.server.mapper.StudentMapper;
import org.example.server.mapper.UserMapper;
import org.example.server.payload.response.DataResponse;
import org.example.server.pojo.Person;
import org.example.server.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonService {
    @Autowired
    PersonMapper personMapper;//注入人员数据；
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    UserMapper userMapper;

    public DataResponse getPersonList() {
        return DataResponse.success(personMapper.selectAll());
    }

    public DataResponse selectById(Integer id) {
        Person person = personMapper.selectById(id);
        if (person == null)
            return DataResponse.error(404, "查询失败，此人不存在");
        else
            return DataResponse.success(person, "查询成功！");
    }

    public DataResponse selectByPersonNum(String person_num) {
        Person person = personMapper.selectByPersonNum(person_num);
        if (person == null)
            return DataResponse.error(404, "查询失败，此人不存在");
        else
            return DataResponse.success(person, "查询成功！");
    }

    public Map selectSPersonByIdMap(Integer id){
        Person person=personMapper.selectById(id);
        if (person == null )
            return null;
        Map m=new HashMap<>();
        Person p=personMapper.selectSPersonById(id);
        m.put("id",p.getId());
        m.put("person_name",p.getPerson_name());
        m.put("gender_id",p.getGender_id());
        m.put("phone_number",p.getPhone_number());
        m.put("identity",p.getIdentity());
        m.put("person_num",p.getPerson_num());
        m.put("birthday",p.getBirthday());
        m.put("user_type",p.getUser_type());
        m.put("department",p.getDepartment());
        m.put("email",p.getEmail());
        m.put("identity_number",p.getIdentity_number());
        m.put("classes",p.getStudent().getClasses());
        m.put("grade",p.getStudent().getGrade());
        m.put("major",p.getStudent().getMajor());
        return m;
    }

}
