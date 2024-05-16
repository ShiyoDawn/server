package org.example.server.Service;

import org.example.server.mapper.LeaveMapper;
import org.example.server.mapper.PersonMapper;
import org.example.server.payload.Result;
import org.example.server.pojo.Leave;
import org.example.server.pojo.Person;
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
    @Autowired
    private PersonMapper personMapper;


    public Result insertLeave(String student_num, String student_name, String leave_type, String leave_reason, String destination, String time, String status, String age, String institute, String major, String instructor_name, String instructor_tele, String leave_detailed_reason, String start_time, String end_time, String student_tele) {
        Person person=personMapper.selectByPersonNum(student_num);
        Leave leave=new Leave();
        leave.setPerson(person);
        leave.setPerson_id(person.getId());
        leave.setStudent_num(student_num);
        leave.setStudent_name(student_name);
        leave.setLeave_type(leave_type);
        leave.setLeave_reason(leave_reason);
        leave.setDestination(destination);
        leave.setTime(time);
        leave.setStatus(status);
        leave.setAge(age);
        leave.setInstitute(institute);
        leave.setMajor(major);
        leave.setInstructor_name(instructor_name);
        leave.setInstructor_tele(instructor_tele);
        leave.setLeave_detailed_reason(leave_detailed_reason);
        leave.setStart_time(start_time);
        leave.setEnd_time(end_time);
        leave.setStudent_tele(student_tele);
        leaveMapper.insertLeave(leave);
        return Result.success("增添成功");

    }

    public Result updateStatus(String status,String student_num,String student_name,String institute,String major,String instructor_name,String instructor_tele,String leave_detailed_reason,String start_time,String end_time,String student_tele,String leave_reason,String leave_type,String destination){
        leaveMapper.updateStatus(status,student_num,student_name,institute,major,instructor_name,instructor_tele,leave_detailed_reason,start_time,end_time,student_tele,leave_reason,leave_type,destination);
        return Result.success("修改成功");
    }


    public Result getLeaveList(){
        List<Leave> leaveList=leaveMapper.selectAll();
        List<Map> mapList=new ArrayList<>();
        for(Leave leave:leaveList){
            Map map=new HashMap();
            Person person=personMapper.selectById(leave.getPerson_id());
            leave.setPerson(person);
            leave.setStudent_num(person.getPerson_num());
            leave.setStudent_name(person.getPerson_name());
            map.put("id",leave.getId()+"");
            map.put("student_num",leave.getStudent_num());
            map.put("student_name",leave.getStudent_name());
            map.put("leave_type",leave.getLeave_type());
            map.put("leave_reason",leave.getLeave_reason());
            map.put("destination",leave.getDestination());
            map.put("time",leave.getTime());
            map.put("age",leave.getAge());
            map.put("status",leave.getStatus());
            map.put("institute",leave.getInstitute());
            map.put("major",leave.getMajor());
            map.put("instructor_name",leave.getInstructor_name());
            map.put("instructor_tele",leave.getInstructor_tele());
            map.put("leave_detailed_reason",leave.getLeave_detailed_reason());
            map.put("start_time",leave.getStart_time());
            map.put("end_time",leave.getEnd_time());
            map.put("student_tele",leave.getStudent_tele());
            mapList.add(map);
        }
        return Result.success(mapList);
    }

    public Result selectByStudentNum(String student_num) {
        List<Leave> leaveList=leaveMapper.selectByStudentNum(student_num);
        List<Map> mapList=new ArrayList<>();
        Integer cnt=0;
        for(Leave leave:leaveList){
            Map map=new HashMap();
            Person person=personMapper.selectById(leave.getPerson_id());
            leave.setPerson(person);
            leave.setStudent_num(person.getPerson_num());
            leave.setStudent_name(person.getPerson_name());
            map.put("id",++cnt+"");
            map.put("student_num",leave.getStudent_num());
            map.put("student_name",leave.getStudent_name());
            map.put("leave_type",leave.getLeave_type());
            map.put("leave_reason",leave.getLeave_reason());
            map.put("destination",leave.getDestination());
            map.put("time",leave.getTime());
            map.put("status",leave.getStatus());
            map.put("age",leave.getAge());
            map.put("institute",leave.getInstitute());
            map.put("major",leave.getMajor());
            map.put("instructor_name",leave.getInstructor_name());
            map.put("instructor_tele",leave.getInstructor_tele());
            map.put("leave_detailed_reason",leave.getLeave_detailed_reason());
            map.put("start_time",leave.getStart_time());
            map.put("end_time",leave.getEnd_time());
            map.put("student_tele",leave.getStudent_tele());
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
            map.put("age",leave.getAge());
            map.put("institute",leave.getInstitute());
            map.put("major",leave.getMajor());
            map.put("instructor_name",leave.getInstructor_name());
            map.put("instructor_tele",leave.getInstructor_tele());
            map.put("leave_detailed_reason",leave.getLeave_detailed_reason());
            map.put("start_time",leave.getStart_time());
            map.put("end_time",leave.getEnd_time());
            map.put("student_tele",leave.getStudent_tele());
            mapList.add(map);
        }
        return Result.success(mapList);
    }


}
