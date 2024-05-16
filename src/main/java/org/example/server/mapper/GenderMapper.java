package org.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.server.pojo.Gender;

@Mapper
public interface GenderMapper extends BaseMapper<Gender> {
    Gender selectById(Integer id);
}
