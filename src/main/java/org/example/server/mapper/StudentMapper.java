package org.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.server.pojo.Student;

import java.util.List;
import java.util.Optional;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    Optional<Student> findByPersonId(Integer personId);

    Optional<Student> findByPersonNum(String personNum);

    List<Student> findByPersonName(String personName);

    //这个似乎不用写注释了(xml文件似乎会覆盖掉注释内容)
    @Select("select * from student where id=#{id}")
    public Student selectById(Integer id);
}
