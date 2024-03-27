package org.example.server.mapper;

import org.example.server.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void testSelectList(){
        List<User> list=userMapper.selectList(null);
        list.forEach(System.out::println);
    }
}
