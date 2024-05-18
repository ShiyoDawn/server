package org.example.server.Service;

import org.example.server.mapper.GloryMapper;
import org.example.server.mapper.PersonMapper;
import org.example.server.mapper.StudentMapper;
import org.example.server.payload.Result;
import org.example.server.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GloryService {

    @Autowired
    private GloryMapper gloryMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private PersonMapper personMapper;

    public Result insertGlory(String student_name, String student_num, String glory_name, String glory_type, String glory_level) {
        Person person=personMapper.selectByPersonNum(student_num);
        System.out.println(student_num);
        System.out.println(person);
        Glory glory=new Glory();
        glory.setPerson(person);
        glory.setStudent_name(student_name);
        glory.setStudent_num(student_num);
        glory.setGlory_name(glory_name);
        glory.setGlory_type(glory_type);
        glory.setGlory_level(glory_level);
        glory.setPerson_id(person.getId());
        System.out.println(glory);
        gloryMapper.insertGlory(glory);
        return Result.ok("添加成功！");
    }

    public Result deleteGlory(String student_name, String glory_name,String glory_type,String glory_level,String student_num) {
        gloryMapper.deleteGlory(student_name, glory_name, glory_type, glory_level, student_num);
        return Result.ok("删除成功！");
    }

    public Result updateGlory(String student_num, String student_name, String glory_name, String glory_level, String glory_type, String raw_glory_name, String raw_glory_level, String raw_glory_type) {
        gloryMapper.updateGlory(student_num, student_name, glory_name, glory_level, glory_type, raw_glory_name, raw_glory_level, raw_glory_type);
        System.out.println(student_num+" "+student_name+" "+glory_name+" "+glory_level+" "+glory_type+" "+raw_glory_name+" "+raw_glory_level+" "+raw_glory_type);
        return Result.ok("修改成功！");
    }

    public Result selectByStudentAndGlory(String student_num, String glory_name) {
        Glory glory = gloryMapper.selectByStudentAndGlory(student_num, glory_name);
        Map map = new HashMap();
        map.put("id", 1 + "");
        map.put("student_name", glory.getStudent_name());
        map.put("student_num", glory.getStudent_num());
        map.put("glory_name", glory.getGlory_name());
        map.put("glory_type", glory.getGlory_type());
        map.put("glory_level", glory.getGlory_level());
        System.out.println(map);
        return Result.success(map, "查询成功！");
    }

    public Result selectByStudentName(String student_name) {
        List<Glory> gloryList = gloryMapper.selectByStudentName(student_name);
        List<Map> gloryMap = new ArrayList<>();
        for (Glory glory : gloryList) {
            Map map = new HashMap();
            map.put("id", glory.getId() + "");
            map.put("student_name", glory.getStudent_name());
            map.put("student_num", glory.getStudent_num());
            map.put("glory_name", glory.getGlory_name());
            map.put("glory_type", glory.getGlory_type());
            map.put("glory_level", glory.getGlory_level());
            gloryMap.add(map);
        }
        return Result.success(gloryMap, "查询成功！");
    }

    public Result selectByGloryName(String glory_name) {
        List<Glory> gloryList = gloryMapper.selectByGloryName(glory_name);
        List<Map> gloryMap = new ArrayList<>();
        for (Glory glory : gloryList) {
            Map map = new HashMap();
            map.put("id", glory.getId() + "");
            map.put("student_name", glory.getStudent_name());
            map.put("student_num", glory.getStudent_num());
            map.put("glory_name", glory.getGlory_name());
            map.put("glory_type", glory.getGlory_type());
            map.put("glory_level", glory.getGlory_level());
            gloryMap.add(map);
        }
        return Result.success(gloryMap, "查询成功！");
    }

    public Result getGloryList() {
        List<Glory> gloryList = gloryMapper.selectAll();
        List<Map<String, String>> dataList = new ArrayList();
        Map<String, String> map = new HashMap<>();
        Integer cnt=0;
        for (Glory glory : gloryList) {
            map = new HashMap();
            Person person=personMapper.selectById(glory.getPerson_id());
            glory.setPerson(person);
            glory.setStudent_name(person.getPerson_name());
            glory.setStudent_num(person.getPerson_num());

            map.put("id", ++cnt + "");
            map.put("student_name", glory.getStudent_name());
            map.put("student_num", glory.getStudent_num());
            map.put("glory_name", glory.getGlory_name());
            map.put("glory_type", glory.getGlory_type());
            map.put("glory_level", glory.getGlory_level());
            //map.put("ranking", s.getRanking() + "");
            dataList.add(map);
        }
        return Result.success(dataList);
    }

    public Result selectById(Integer id) {
        Glory glory = gloryMapper.selectById(id);
        Map map = new HashMap();
        map.put("id", glory.getId() + "");
        map.put("student_name", glory.getStudent_name());
        map.put("student_num", glory.getStudent_num());
        map.put("glory_name", glory.getGlory_name());
        map.put("glory_type", glory.getGlory_type());
        map.put("glory_level", glory.getGlory_level());
        return Result.success(map);
    }

    public Result selectByStudentNum(String student_num) {
        List<Glory> gloryList = gloryMapper.selectByStudentNum(student_num);
        List<Map> gloryMap = new ArrayList<>();
        Integer cnt=0;
        for (Glory glory : gloryList) {
            Map map = new HashMap();
            Person person=personMapper.selectById(glory.getPerson().getId());
            glory.setPerson(person);
            glory.setStudent_name(person.getPerson_name());
            glory.setStudent_num(person.getPerson_num());
            map.put("id", ++cnt + "");
            map.put("student_name", glory.getStudent_name());
            map.put("student_num", glory.getStudent_num());
            map.put("glory_name", glory.getGlory_name());
            map.put("glory_type", glory.getGlory_type());
            map.put("glory_level", glory.getGlory_level());
            gloryMap.add(map);
        }
        return Result.success(gloryMap, "查询成功！");
    }
}
