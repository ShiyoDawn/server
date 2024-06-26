package org.example.server.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.server.pojo.Leave;

import java.util.List;

@Mapper
public interface LeaveMapper {


    List<Leave> selectByStudentNum(String student_num);

    List<Leave> selectByStudentName(String student_name);
    List<Leave> selectAll();

    void updateStatus(String status,String student_num,String student_name,String institute,String major,String instructor_name,String instructor_tele,String leave_detailed_reason,String start_time,String end_time,String student_tele,String leave_reason,String leave_type,String destination);
    void insertLeave(Leave leave);
}
