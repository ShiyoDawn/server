package org.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.server.pojo.Person;

import java.util.List;

@Mapper
public interface PersonMapper extends BaseMapper<Person> {
    List<Person> selectPerson(Integer id);
}
