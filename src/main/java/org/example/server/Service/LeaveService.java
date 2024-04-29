package org.example.server.Service;

import org.example.server.mapper.LeaveMapper;
import org.example.server.payload.Result;
import org.example.server.pojo.Leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LeaveService {

    @Autowired
    private LeaveMapper leaveMapper;


    public Result insertLeave(String student_num, String student_name, String leave_type, String leave_reason, String destination, String time, String status) {
        leaveMapper.insertLeave(student_num,student_name,leave_type,leave_reason,destination,time,status);
        System.out.println(student_num+" "+student_name+" "+leave_type+" "+leave_reason+" "+destination+" "+time+" "+status);
        return Result.success("增添成功");

    }

    public Result getLeaveList(){
        List<Leave> leaveList=leaveMapper.selectAll();
        List<Map> mapList=new ArrayList<>();
        for(Leave leave:leaveList){
            Map map=new HashMap();
            map.put("id",leave.getId()+"");
            map.put("student_num",leave.getStudent_num());
            map.put("student_name",leave.getStudent_name());
            map.put("leave_type",leave.getLeave_type());
            map.put("leave_reason",leave.getLeave_reason());
            map.put("destination",leave.getDestination());
            map.put("time",leave.getTime());
            map.put("status",leave.getStatus());
            mapList.add(map);
        }
        return Result.success(mapList);
    }

    public Result selectByStudentNum(String student_num) {
        List<Leave> leaveList=leaveMapper.selectByStudentNum(student_num);
        List<Map> mapList=new ArrayList<>();
        for(Leave leave:leaveList){
            Map map=new HashMap();
            map.put("id",leave.getId()+"");
            map.put("student_num",leave.getStudent_num());
            map.put("student_name",leave.getStudent_name());
            map.put("leave_type",leave.getLeave_type());
            map.put("leave_reason",leave.getLeave_reason());
            map.put("destination",leave.getDestination());
            map.put("time",leave.getTime());
            map.put("status",leave.getStatus());
            mapList.add(map);
        }
        return Result.success(mapList);
    }

    public Result selectByStudentName(String student_name) {
        List<Leave> leaveList=leaveMapper.selectByStudentName(student_name);
        List<Map> mapList=new ArrayList<>();
        for(Leave leave:leaveList){
            Map map=new HashMap();
            map.put("id",leave.getId()+"");
            map.put("student_num",leave.getStudent_num());
            map.put("student_name",leave.getStudent_name());
            map.put("leave_type",leave.getLeave_type());
            map.put("leave_reason",leave.getLeave_reason());
            map.put("destination",leave.getDestination());
            map.put("time",leave.getTime());
            map.put("status",leave.getStatus());
            mapList.add(map);
        }
        return Result.success(mapList);
    }
}
