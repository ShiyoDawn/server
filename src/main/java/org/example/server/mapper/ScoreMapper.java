package org.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.example.server.pojo.Score;
import org.springframework.beans.factory.annotation.Autowired;

public interface ScoreMapper extends BaseMapper<Score> {
    @Select("SELECT * from score where student_name = #{student_name}")
    Integer getScoreByName();
}
