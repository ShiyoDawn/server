package org.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.server.payload.response.DataResponse;
import org.example.server.pojo.Course;
import org.example.server.pojo.Score;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface ScoreMapper extends BaseMapper<Score> {

    void insertMark(Integer student_id, String student_name, Integer course_id, String course_name, Double mark);

    void updateMark(Integer student_id, Integer course_id, Double mark);

    void updateId(Integer student_id,Integer course_id,Integer id);

    void deleteOnlyScore(Integer student_id, Integer course_id);

    void deleteForAll(Integer student_id,Integer course_id);

    //Integer calculateRanking(Integer student_id,Integer course_id,Integer mark);

    //void updateRanking(Integer student_id,Integer course_id,Integer ranking);

    List<Score> selectAll();

    Score selectByStudentAndCourse(Integer student_id, Integer course_id);

    List<Score> selectByStudentId(Integer student_id);

    List<Score> selectByCourseId(Integer course_id);

    void saveScore(Score score);

    List<Score> getScoreSorted_Ascending(Integer course_id);

    List<Score> getScoreSorted_Descending(Integer course_id);
}
