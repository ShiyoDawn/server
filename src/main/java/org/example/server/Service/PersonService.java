package org.example.server.Service;

import org.example.server.mapper.PersonMapper;
import org.example.server.mapper.StudentMapper;
import org.example.server.mapper.UserMapper;
import org.example.server.payload.response.DataResponse;
import org.example.server.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonMapper personMapper;//注入人员数据；
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    UserMapper userMapper;

    public DataResponse getPersonList() {
        return DataResponse.success(personMapper.selectAll());
    }

    public DataResponse selectById(Integer id) {
        Person person = personMapper.selectById(id);
        if (person == null)
            return DataResponse.error(404, "查询失败，此人不存在");
        else
            return DataResponse.success(person, "查询成功！");
    }

    public DataResponse selectByPersonNum(String person_num) {
        Person person = personMapper.selectByPersonNum(person_num);
        if (person == null)
            return DataResponse.error(404, "查询失败，此人不存在");
        else
            return DataResponse.success(person, "查询成功！");
    }

}
