package org.example.server.Service;

import org.example.server.mapper.EvaluateMapper;
import org.example.server.mapper.PersonMapper;
import org.example.server.pojo.Evaluate;
import org.example.server.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EvaluateService {
    @Autowired
    private EvaluateMapper evaluateMapper;
    @Autowired
    private PersonMapper personMapper;

    public List<Map<String, String>> findAllEvaluate(){
        List<Evaluate> evaluates = evaluateMapper.findAllEvaluate();
        if(evaluates == null || evaluates.isEmpty()){
            return null;
        }
        List<Map<String, String>> list = new ArrayList<>();
        for(Evaluate evaluate : evaluates){
            Person person=personMapper.selectById(evaluate.getPerson_id());
            Map<String, String> map = new HashMap<>();
            map.put("id", evaluate.getId().toString());
            map.put("person_id", evaluate.getPerson_id().toString());
            map.put("activity_name", evaluate.getActivity_name());
            map.put("date", evaluate.getDate());
            map.put("score", evaluate.getScore());
            map.put("activity_type_id", evaluate.getActivity_type_id().toString());
            if (person!=null){
                map.put("person_name", person.getPerson_name());
            }
            list.add(map);
        }
        return list;
    }
    public void addEvaluate(Map evaluate){
        if (personMapper.selectByPersonNum(evaluate.get("person_num").toString())==null){
            throw new RuntimeException("该学生不存在");
        }
        evaluateMapper.addEvaluate(evaluate);
    }
}
