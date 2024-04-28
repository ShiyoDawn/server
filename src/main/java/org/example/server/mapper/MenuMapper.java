package org.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.server.pojo.Course;

import java.awt.*;
import java.util.List;
import java.util.Map;

@Mapper
public interface MenuMapper extends BaseMapper {
    @Select("select name, url from menu where access like '%${userType}%';")
    List<Map> selectByAccess(String userType);
}
