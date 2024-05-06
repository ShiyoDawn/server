package org.example.server.Service;

import org.example.server.mapper.GloryMapper;
import org.example.server.mapper.StudentMapper;
import org.example.server.payload.Result;
import org.example.server.pojo.Course;
import org.example.server.pojo.Glory;
import org.example.server.pojo.Score;
import org.example.server.pojo.Student;
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

    public Result insertGlory(String student_name, String student_num, String glory_name, String glory_type, String glory_level) {
        Glory glory = gloryMapper.selectByStudentAndGlory(student_name, glory_name);
        if (glory != null) {
            return Result.error(404, "Glory has existed!");
        }
        gloryMapper.insertGlory(student_name, student_num, glory_name, glory_type, glory_level);
        return Result.ok("添加成功！");
    }

    public Result deleteGlory(String student_name, String glory_name) {
        gloryMapper.deleteGlory(student_name, glory_name);
        return Result.ok("删除成功！");
    }

    public Result updateGlory(String student_name, String new_glory_name, String glory_name, String new_glory_level, String glory_type) {
        gloryMapper.updateGlory(student_name, new_glory_name, glory_name, new_glory_level, glory_type);
        return Result.ok("修改成功！");
    }

    public Result selectByStudentAndGlory(String student_name, String glory_name) {
        Glory glory = gloryMapper.selectByStudentAndGlory(student_name, glory_name);
        Map map = new HashMap();
        map.put("id", glory.getId() + "");
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
        for (int i = 0; i < gloryList.size(); i++) {
            gloryMapper.updateId(i + 1, gloryList.get(i).getStudent_name(), gloryList.get(i).getGlory_name());
        }
        for (Glory glory : gloryList) {
            System.out.println(glory.getId());
        }
        for (Glory glory : gloryList) {
            map = new HashMap();
            map.put("id", glory.getId() + "");
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
}
