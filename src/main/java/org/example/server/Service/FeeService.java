package org.example.server.Service;


import org.example.server.mapper.FeeMapper;
import org.example.server.mapper.StudentMapper;
import org.example.server.payload.Result;
import org.example.server.pojo.Fee;
import org.example.server.pojo.Glory;
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

    public Result insertFee(Integer id,String student_num,String student_name,String date,String money,String activity,String activity_detail){
        feeMapper.insertFee(id,student_num,student_name,date,money,activity,activity_detail);
        return Result.ok();
    }

    public Result getFeeList(){
        List<Fee> feeList = feeMapper.selectAll();
        List<Map<String, String>> dataList = new ArrayList();
        Map<String, String> map = new HashMap<>();
        for(int i=0;i<feeList.size();i++){
            Fee fee=feeList.get(i);
            feeMapper.updateId(i+1,fee.getStudent_num(),fee.getStudent_name(),fee.getDate(),fee.getMoney(),fee.getActivity(),fee.getActivity_detail());
        }
        for (Fee fee : feeList) {
            map = new HashMap();
            map.put("id", fee.getId() + "");
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

    public Result deleteFee(Integer id) {
        feeMapper.deleteFee(id);
        return Result.ok();
    }
}
