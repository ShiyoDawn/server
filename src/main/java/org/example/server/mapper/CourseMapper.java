package org.example.server.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.server.pojo.Course;

import java.util.List;

@Mapper
public interface CourseMapper {
    List<Course> updateInfo();
}
