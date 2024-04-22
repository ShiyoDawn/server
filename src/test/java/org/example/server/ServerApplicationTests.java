package org.example.server;

import org.example.server.Service.CourseService;
import org.example.server.payload.response.DataResponse;
import org.example.server.pojo.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ServerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void select() {
    }


    @Autowired
    CourseService courseService;

}
