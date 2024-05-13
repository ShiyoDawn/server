package org.example.server.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.server.payload.Result;
import org.example.server.pojo.Activity;

import java.util.List;

@Mapper
public interface ActivityMapper {
    List<Activity> selectAll();

    void insertActivity(String student_num, String student_name, String activity_name, String activity_type, String date, String score);

    void deleteActivity(String student_num, String student_name, String activity_name, String activity_type, String date, String score);

    List<Activity> selectByStudentNum(String student_num);
}
