package org.example.server.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.server.payload.Result;
import org.example.server.pojo.Glory;

import java.util.List;

@Mapper
public interface GloryMapper {


    void insertGlory(String student_name, String student_num, String glory_name, String glory_type, String glory_level);

    void deleteGlory(String student_name, String glory_name);

    void updateGlory(String student_name, String new_glory_name, String glory_name, String new_glory_level, String glory_type);

    List<Glory> selectByGloryName(String glory_name);

    List<Glory> selectByStudentName(String student_name);

    List<Glory> selectByStudentNum(String student_num);

    Glory selectByStudentAndGlory(String student_name, String glory_name);

    List<Glory> selectAll();

    void updateId(Integer id, String student_name, String glory_name);

    Glory selectById(Integer id);

    void deleteByStudentNum(String student_num);

}
