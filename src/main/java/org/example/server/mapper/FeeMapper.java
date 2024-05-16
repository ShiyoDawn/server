package org.example.server.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.example.server.pojo.Fee;

import java.util.List;

@Mapper
public interface FeeMapper {
    void insertFee(Integer id,String student_num,String student_name,String date,String money,String activity,String activity_detail);

    List<Fee> selectAll();

    void deleteFee(Integer id);

    void updateId(Integer id, String student_num, String student_name, String date, String money, String activity, String activity_detail);

    List<Fee> selectByStudentNum(String student_num);

    void deleteByStudentNum(String student_num);
}
