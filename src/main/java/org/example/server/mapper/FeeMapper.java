package org.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.server.pojo.Fee;

import java.util.List;
import java.util.Optional;

public interface FeeMapper extends BaseMapper<Fee> {
    List<Fee> findByPersonId(Integer person_id);
}
