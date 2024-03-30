package org.example.server.controller;

import org.example.server.pojo.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CourseControllerTest {
    @Autowired
    CourseController courseController;
    @Test
    void updateInfo() {
    }

    @Test
    void selectInfo() {
    }

    @Test
    void addCourse() {
    }

    @Test
    void deleteCourseByID() {
    }

    @Test
    void selectMixed() {
        Integer id = 1;
        String course_name = "高";
        Double credit = null;
        Integer num = null;
        Integer course_type_id = 2;
        Integer pre_course_id = null;
        String book = null;
        String extracurricular = null;
        Course course = new Course(id,course_name,credit, num, course_type_id, pre_course_id, book, extracurricular);
        courseController.selectMixed(course,1);
    }
}