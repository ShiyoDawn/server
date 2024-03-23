package org.example.server.Service;

import org.example.server.mapper.ScoreMapper;
import org.example.server.pojo.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;

    public void insert(Integer id){
        //insert()返回值为int;
        scoreMapper.insert(new Score(id,null,null,null,null,null,null,null));
    }
    public void deleteById(Integer id){
        scoreMapper.deleteById(id);
    }

    public void update(Integer id,Integer score) {
        scoreMapper.update1(id,score);
    }
}
