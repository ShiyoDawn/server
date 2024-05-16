package org.example.server.Service;


import org.example.server.mapper.FeeMapper;
import org.example.server.mapper.PersonMapper;
import org.example.server.mapper.StudentMapper;
import org.example.server.payload.Result;
import org.example.server.pojo.Fee;
import org.example.server.pojo.Glory;
import org.example.server.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FeeService {
    @Autowired
    private FeeMapper feeMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private PersonMapper personMapper;

    public Result insertFee(Integer id,String student_num,String student_name,String date,String money,String activity,String activity_detail){
        Person person=personMapper.selectByPersonNum(student_num);
        Fee fee=new Fee();
        fee.setStudent_name(student_name);
        fee.setStudent_num(student_num);
        fee.setDate(date);
        fee.setMoney(money);
        fee.setActivity(activity);
        fee.setActivity_detail(activity_detail);
        fee.setPerson(person);
        fee.setPerson_id(person.getId());
        feeMapper.insertFee(fee);
        return Result.ok();
    }

    public Result getFeeList(){
        List<Fee> feeList = feeMapper.selectAll();
        List<Map<String, String>> dataList = new ArrayList();
        Map<String, String> map = new HashMap<>();
        Integer cnt=0;
        for (Fee fee : feeList) {
            map = new HashMap();
            map.put("id", ++cnt + "");
            Person person=personMapper.selectById(fee.getPerson_id());
            fee.setPerson(person);
            fee.setStudent_name(person.getPerson_name());
            fee.setStudent_num(person.getPerson_num());
            map.put("student_name", fee.getStudent_name());
            map.put("student_num", fee.getStudent_num());
            map.put("date",fee.getDate());
            map.put("money",fee.getMoney());
            map.put("activity",fee.getActivity());
            map.put("activity_detail",fee.getActivity_detail());
            dataList.add(map);
        }
        return Result.success(dataList);
    }

    public Result deleteFee(String student_num,String student_name,String date,String money,String activity,String activity_detail){
        feeMapper.deleteFee(student_num,student_name,date,money,activity,activity_detail);
        return Result.ok();
    }
}
