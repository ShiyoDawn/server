package org.example.server.Service;

import org.example.server.mapper.GenderMapper;
import org.example.server.mapper.PersonMapper;
import org.example.server.mapper.StudentMapper;
import org.example.server.mapper.UserMapper;
import org.example.server.payload.Result;
import org.example.server.pojo.Gender;
import org.example.server.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
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
    @Autowired
    private GenderMapper genderMapper;

    public Result getPersonList() {
        return Result.success(personMapper.selectAll());
    }

    public Result selectById(Integer id) {
        Person person = personMapper.selectById(id);
        if (person == null)
            return Result.error(404, "查询失败，此人不存在");
        else
            return Result.success(person, "查询成功！");
    }

    public Result selectByPersonNum(String person_num) {
        Person person = personMapper.selectByPersonNum(person_num);
        if (person == null)
            return Result.error(404, "查询失败，此人不存在");
        else
            return Result.success(person, "查询成功！");
    }

    public Result selectSPersonByIdMap(Integer id){
        Person person=personMapper.selectById(id);
        if (person == null )
            return null;
        Map m=new HashMap<>();
        Person p=personMapper.selectSPersonById(id);
        m.put("id",p.getId()+"");
        m.put("person_name",p.getPerson_name());
        m.put("gender_id",p.getGender_id()+"");
        m.put("phone_number",p.getPhone_number());
        m.put("identity",p.getIdentity());
        m.put("person_num",p.getPerson_num());
        m.put("birthday",p.getBirthday());
        m.put("user_type",p.getUser_type()+"");
        m.put("department",p.getDepartment());
        m.put("email",p.getEmail());
        m.put("identity_number",p.getIdentity_number());
        m.put("classes",p.getStudent().getClasses());
        m.put("grade",p.getStudent().getGrade());
        m.put("major",p.getStudent().getMajor());
        return Result.success(m);
    }
    public Integer getAllPerson(){
        return personMapper.getAllPerson();
    }

    public Result updatePhoto(String person_num, byte[] photo) {
        personMapper.updatePhoto(person_num,photo);
        return Result.ok();
    }

    public Result selectPhoto(String person_num) {
        System.out.println(personMapper.selectPhoto(person_num).getClass());
        return Result.success(personMapper.selectPhoto(person_num));
    }

    public List<Map<String, String>> getAll() {
        List<Person> personList=personMapper.selectAll();
        if (personList==null){
            return null;
        }
        List<Map<String, String>> list = new ArrayList<>();
        for (Person person : personList) {
            Map<String, String> map = new HashMap<>();
            map.put("id", person.getId() + "");
            map.put("person_name", person.getPerson_name());
            map.put("gender_id", person.getGender_id() + "");
            map.put("phone_number", person.getPhone_number());
            map.put("identity", person.getIdentity());
            map.put("person_num", person.getPerson_num());
            map.put("birthday", person.getBirthday());
            map.put("user_type", person.getUser_type() + "");
            map.put("department", person.getDepartment());
            map.put("email", person.getEmail());
            map.put("identity_number", person.getIdentity_number());
            Gender gender=genderMapper.selectById(person.getGender_id());
            if (gender!=null){
                map.put("gender",gender.getGender());
            }
            list.add(map);
        }
        return list;
    }
}
