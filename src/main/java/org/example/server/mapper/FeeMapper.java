package org.example.server.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.example.server.pojo.Fee;

import java.util.List;

@Mapper
public interface FeeMapper {
    void insertFee(Fee fee);

    List<Fee> selectAll();

    void deleteFee(String student_num, String student_name,String date, String money, String activity, String activity_detail);

    void updateId(Integer id, String student_num, String student_name, String date, String money, String activity, String activity_detail);

}
