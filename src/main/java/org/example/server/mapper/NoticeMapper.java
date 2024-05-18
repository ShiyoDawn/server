package org.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.server.pojo.Course;

import java.awt.*;
import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeMapper extends BaseMapper {
    @Select("select text, color from notice;")
    List<Map> selectNotice();


    @Update("update notice set text = #{text}, color = #{color} where id = 1")
    void updateNotice(String text, String color);

}

