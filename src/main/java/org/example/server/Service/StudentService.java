package org.example.server.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.server.mapper.*;
import org.example.server.payload.response.DataResponse;
import org.example.server.payload.response.OptionItem;
import org.example.server.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Max;
import java.util.*;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private StudentFamilyMapper studentFamilyMapper;
    @Autowired
    private StudentFamilyService studentFamilyService;
    @Autowired
    private GenderMapper genderMapper;
    @Autowired
    private StudentForeschoolMapper studentForeschoolMapper;
    @Autowired
    private GloryMapper gloryMapper;

    public void insert(Integer person_id,String person_num,String student_name,String department,String classes,String grade,String major){
        Student student=studentMapper.selectByPid(person_id);
        if(student != null){
            return;
        }
        Map<String, Object> personMap = new HashMap<>();
        personMap.put("student_name", student_name);
        personMap.put("person_num", person_num);
        personMap.put("gender_id", 1/* 这里应该是一个非null的值 */);
        person_id=personMapper.getAllPerson()+1;
        System.out.println(studentMapper.insertPersonInfo(personMap));
        System.out.println(person_id);
        Map<String, Object> studentMap = new HashMap<>();
        studentMap.put("person_id", person_id);
        studentMap.put("student_name", student_name);
        studentMap.put("department", department);
        studentMap.put("classes", classes);
        studentMap.put("grade", grade);
        studentMap.put("major", major);
        System.out.println(studentMap);

        studentMapper.insertStudentInfo(studentMap);

        return;
    }

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

    public List<Map<String, String>> getStudentMapList() {
        List<Student> students = studentMapper.findAllStudent();
        if (students == null || students.isEmpty()) {
            return null;
        }
        List<Map<String, String>> list = new ArrayList<>();
        for (Student student : students) {
            Map<String, String> map = new HashMap<>();
            map.put("id", String.valueOf(student.getId()));
            map.put("person_id", String.valueOf(student.getPerson_id()));
            map.put("student_name", student.getStudent_name());
            map.put("department", student.getDepartment());
            map.put("classes", student.getClasses());
            map.put("grade", student.getGrade());
            map.put("major", student.getMajor());
            Person person = personMapper.selectById(student.getPerson_id());
            student.setPerson(person);
            if (person != null) {
                map.put("person_num", person.getPerson_num());
                map.put("photo", person.getPhoto() == null ? "" : new String(person.getPhoto()));
            }
            list.add(map);
        }
        return list;
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

        map.put("id", student.getId()+"");
        map.put("person_id", student.getPerson_id()+"");
        map.put("student_name", student.getStudent_name());
        map.put("department", student.getDepartment());
        map.put("classes", student.getClasses());
        map.put("grade", student.getGrade());
        map.put("major", student.getMajor());
        return map;

    }
    public Map findStudentByPid(Integer person_id){
        Student student=studentMapper.selectByPid(person_id);
        student.setStudentFamilies(studentFamilyMapper.findFamilyByStudentId(student.getId()));
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

        map.put("id", student.getId()+"");
        map.put("person_id", student.getPerson_id()+"");
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
            m.put("id", s.getId()+"");
            m.put("person_num", s.getPerson().getPerson_num()+"");
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

    public Boolean updateStudent(Integer id,String student_name,String department,String classes,String grade,String major) {
        Student student=studentMapper.selectById(id);
        if(student==null){
            return false;
        }
        Map map=new HashMap();
        map.put("id",id);
        map.put("student_name",student_name);
        map.put("department",department);
        map.put("classes",classes);
        map.put("grade",grade);
        map.put("major",major);
        System.out.println(map);
        studentMapper.updateStudent(map);
//        studentMapper.updateStudentName(new_student_name,id);
        return true;
    }

    public Boolean updateStudentGrade(String student_name, String grade) {
        Student student=studentMapper.findByStudentName(student_name);
        if(student==null){
            return false;
        }
        studentMapper.updateStudentGrade(student_name,grade);
        return true;
    }

    public Boolean updateStudentMajor(String student_name, String major) {
        Student student=studentMapper.findByStudentName(student_name);
        if(student==null){
            return false;
        }
        studentMapper.updateStudentMajor(student_name,major);
        return true;
    }

    public void deleteStudent(Integer id,String student_name){
        Student student=studentMapper.selectById(id);
        if(student==null){
            return;
        }
        //如果没有名字就填上，因为Mapper里的删除要求有student_name和person_id
        if(student.getStudent_name()==null){
            studentMapper.updateStudentName(student_name,student.getPerson_id());
        }
        studentFamilyService.deleteFamilyMember(student.getPerson_id());
        personMapper.deletePersonById(student.getPerson_id());
        //先删除studentFamily再删除student，否则会使studentFamily的数据无法被删除；
        studentMapper.deleteStudentByPidAndName(student.getPerson_id(),student_name);
        return;
    }
    public List<Map> selectByStudentIdWithStudentFamily(Integer id){
        Student student=studentMapper.selectById(id);
        if(student==null){
            return new ArrayList<>();
        }
        List studentSFamilyMapList=studentMapper.selectStudentAndStudentFamilyById(id);
        return studentSFamilyMapList;
    }
    public List<Map> selectStudentWithPerson(Integer id){
        Student student=studentMapper.selectById(id);
        if(student==null){
            return new ArrayList<>();
        }
        List studentPersonMapList=studentMapper.selectStudentAndPersonById(id);
        return studentPersonMapList;
    }
    public List<Student> selectStudentByConditions(Map<String, Object> conditions) {
        // 根据条件构建查询语句，使用 MyBatisPlus 或其他持久化框架执行查询操作
        // 示例：假设 StudentMapper 中有一个名为 selectByConditions 的方法用于动态查询
        List<Student> students = studentMapper.selectByConditions(conditions);
        return students;
    }
    public Map getStudentInfoById(Integer id) {
        Student student=studentMapper.selectById(id);
        if(student==null){
            return null;
        }
        Person person=personMapper.selectById(student.getPerson_id());
        Map<String, Object> studentMap = new HashMap<>();
        if(person!=null){
            studentMap.put("person_num", person.getPerson_num());
            studentMap.put("gender_id", person.getGender_id());
            studentMap.put("phone_number", person.getPhone_number());
            studentMap.put("identity", person.getIdentity());
            studentMap.put("identity_number", person.getIdentity_number());
            studentMap.put("birthday", person.getBirthday());
            studentMap.put("email", person.getEmail());
        }
        Gender gender=genderMapper.selectById(person.getGender_id());
        System.out.println(gender);
        if (gender!=null){
            studentMap.put("gender",gender.getGender());
        }
        StudentForeschool studentForeschool=studentForeschoolMapper.selectStudentForeSchoolByStudent_id(student.getId());
        if (studentForeschool!=null){
            studentMap.put("primary",studentForeschool.getPrimary());
            studentMap.put("junior",studentForeschool.getJunior());
            studentMap.put("senior",studentForeschool.getSenior());
        }
        List<StudentFamily> studentFamilies=studentFamilyMapper.findFamilyByStudentId(student.getId());
//        if (studentFamilyMapper!=null){
//            for (StudentFamily sf:studentFamilies){
//                if(sf.getRelation().equals("父亲")){
//                    studentMap.put("father_name",sf.getName());
//                    studentMap.put("father_phone",sf.getPhone());
//                    studentMap.put("father_age",sf.getAge());
//                    studentMap.put("father_job",sf.getJob());
//                    studentMap.put("father_address",sf.getAddress());
//                }
//                else if (sf.getRelation().equals("母亲")){
//                    studentMap.put("mother_name",sf.getName());
//                    studentMap.put("mother_phone",sf.getPhone());
//                    studentMap.put("mother_age",sf.getAge());
//                    studentMap.put("mother_job",sf.getJob());
//                    studentMap.put("mother_address",sf.getAddress());
//                }
//            }
//        }
        if (studentFamilies!=null){
            List<Map<String, String>> studentFamilyList = new ArrayList<>();
            for (StudentFamily studentFamily : studentFamilies) {
                Map<String, String> studentFamilyMap = new HashMap<>();
                studentFamilyMap.put("name", studentFamily.getName());
                studentFamilyMap.put("relation", studentFamily.getRelation());
                studentFamilyMap.put("phone", studentFamily.getPhone());
                studentFamilyMap.put("age", studentFamily.getAge());
                studentFamilyMap.put("job", studentFamily.getJob());
                studentFamilyMap.put("address", studentFamily.getAddress());
                studentFamilyList.add(studentFamilyMap);
            }
            studentMap.put("studentFamilies", studentFamilyList);
        }
        List<Glory> glories=gloryMapper.selectByStudentNum(person.getPerson_num());
        if(glories!=null){
            List<Map<String, String>> gloryList = new ArrayList<>();
            for (Glory glory : glories) {
                Map<String, String> gloryMap = new HashMap<>();
                gloryMap.put("glory_name", glory.getGlory_name());
                gloryMap.put("glory_type", glory.getGlory_type());
                gloryMap.put("glory_level", glory.getGlory_level());
                gloryList.add(gloryMap);
            }
            studentMap.put("glories", gloryList);
        }
        studentMap.put("id", student.getId());
        studentMap.put("person_id", student.getPerson_id());
        studentMap.put("student_name", student.getStudent_name());
        studentMap.put("department", student.getDepartment());
        studentMap.put("classes", student.getClasses());
        studentMap.put("grade", student.getGrade());
        studentMap.put("major", student.getMajor());
        return studentMap;
    }
}
