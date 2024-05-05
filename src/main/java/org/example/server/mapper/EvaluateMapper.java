package org.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.server.pojo.Evaluate;
import org.example.server.pojo.Student;

import java.util.List;
import java.util.Map;

@Mapper
public interface EvaluateMapper extends BaseMapper<Evaluate> {
    List<Evaluate> findAllEvaluate();
    void addEvaluate(Map<String, Object> evaluate);
}
