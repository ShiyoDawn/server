package org.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.server.pojo.Person;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PersonMapper extends BaseMapper<Person> {
    List<Person> selectAll();

    Person selectById(Integer id);

    Person selectByPersonNum(String person_num);

    Person selectSPersonById(Integer id);

    Integer getAllPerson();

    void deletePersonById(Integer id);

    void updatePerson(Map map);

    void updatePhoto(String person_num, byte[] photo);

    byte[] selectPhoto(String person_num);
}


