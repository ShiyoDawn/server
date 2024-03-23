package org.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.server.pojo.Person;

import java.util.List;
import java.util.Optional;

public interface PersonMapper extends BaseMapper<Person> {
    List<Person> findByPersonName(String person_name);
    Optional<Person> findById(Integer id);
    Optional<Person> findByPersonNum(String person_num);
}


