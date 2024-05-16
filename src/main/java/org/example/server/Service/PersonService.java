package org.example.server.Service;

import org.example.server.mapper.*;
import org.example.server.payload.Result;
import org.example.server.pojo.*;
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
    @Autowired
    private GloryMapper gloryMapper;
    @Autowired
    private StudentFamilyMapper studentFamilyMapper;
    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private FeeMapper feeMapper;
    @Autowired
    private EvaluateMapper evaluateMapper;

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

    public void addPerson(String personName, String phoneNumber, String identity, String personNum, String birthday, String userType, String department, String email, String identityNumber,Integer gender_id) {
        Person p=personMapper.selectByPersonNum(personNum);
        if (p!=null){
            return;
        }
        Integer user_type=3;
        if (userType.equals("学生")){
            user_type=3;
        }
        if (userType.equals("教师")){
            user_type=2;
        }
        if (userType.equals("管理员")){
            user_type=1;
        }
        Map<String, Object> personMap = new HashMap<>();
        personMap.put("person_name", personName);
        personMap.put("phone_number", phoneNumber);
        personMap.put("identity", identity);
        personMap.put("person_num", personNum);
        personMap.put("birthday", birthday);
        personMap.put("user_type", user_type);
        personMap.put("department", department);
        personMap.put("email", email);
        personMap.put("identity_number", identityNumber);
        personMap.put("gender_id",gender_id);
        personMapper.insertPerson(personMap);
    }

    public void updatePerson(Integer id, String personName, String phoneNumber, String identity, String personNum, String birthday, String userType, String department, String email, String identityNumber,Integer gender_id) {
        Person p=personMapper.selectById(id);
        if (p==null){
            return;
        }
        Integer user_type=3;
        if (userType.equals("学生")){
            user_type=3;
        }
        if (userType.equals("教师")){
            user_type=2;
        }
        if (userType.equals("管理员")){
            user_type=1;
        }
        Map<String, Object> personMap = new HashMap<>();
        personMap.put("id", id);
        personMap.put("person_name", personName);
        personMap.put("phone_number", phoneNumber);
        personMap.put("identity", identity);
        personMap.put("person_num", personNum);
        personMap.put("birthday", birthday);
        personMap.put("user_type", user_type);
        personMap.put("department", department);
        personMap.put("email", email);
        personMap.put("identity_number", identityNumber);
        personMap.put("gender_id",gender_id);
        personMapper.update(personMap);
    }

    public void deletePerson(Integer id) {
        //先删除关联的信息：学生信息，用户信息，活动信息，荣誉信息，家庭信息，分数信息，学费信息
        Person person=personMapper.selectById(id);
        if (person==null){
            return;
        }
        Student student=studentMapper.selectByPid(id);
        if (student!=null){
            studentMapper.deleteByPid(id);
            List<Glory> glory=gloryMapper.selectByStudentNum(person.getPerson_num());
            if (glory!=null){
                gloryMapper.deleteByStudentNum(person.getPerson_num());
            }
            List<StudentFamily> studentFamily=studentFamilyMapper.findFamilyByStudentId(student.getId());
            if (studentFamily!=null){
                studentFamilyMapper.deleteByPid(id);
            }
            List<Score> score=scoreMapper.selectByStudentId(person.getPerson_num());
            if (score!=null){
                scoreMapper.deleteByStudentNum(person.getPerson_num());
            }
            List<Fee> fee=feeMapper.selectByStudentNum(person.getPerson_num());
            if (fee!=null){
                feeMapper.deleteByStudentNum(person.getPerson_num());
            }
        }
        List<Evaluate> evaluate=evaluateMapper.selectByPid(id);
        System.out.println(1);
        if (evaluate!=null){
            evaluateMapper.deleteByPid(id);
        }
        User user=userMapper.selectByPersonNum(person.getPerson_num());
        if (user!=null){
            userMapper.deleteByPersonNum(person.getPerson_num());
        }
        personMapper.deleteById(id);
    }//此处对teacher不适配，后改
}
