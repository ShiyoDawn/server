package org.example.server;

import org.example.server.pojo.Course;
import org.junit.jupiter.api.Test;
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
    @Test
    void selectMixed(){
        Integer id = null;
        String course_name = "j";
        Double credit = null;
        Integer num = null;
        Integer course_type_id = 2;
        Integer pre_course_id = null;
        String book = null;
        String extracurricular = null;
        Course course = new Course(id,course_name,credit, num, course_type_id, pre_course_id, book, extracurricular);
//        selectMixed(course,1);
    }

}
