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
    @Test
    void selectMixed() {
        Integer id = 1;
        String course_name = "2";
        Double credit = null;
        Integer num = null;
        Integer course_type_id = 1;
        Integer pre_course_id = null;
        String book = null;
        String extracurricular = null;
        Course course = new Course(id,course_name,credit, num, course_type_id, pre_course_id, book, extracurricular);
        System.out.println(courseService.selectMixed(course,1));
    }
}
