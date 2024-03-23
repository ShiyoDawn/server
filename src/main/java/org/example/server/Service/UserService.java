package org.example.server.Service;

import org.example.server.mapper.UserMapper;
import org.example.server.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public void insert() {
        userMapper.insert1();
    }

    public List<User> delete0() {
        return userMapper.selectAll();
    }

}
