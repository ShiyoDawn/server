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

    void insertMark(Score score);

    void updateMark(String student_num, String course_num, Double mark);

    void updateId(String student_num,String course_num,Integer id);

    void deleteOnlyScore(String student_num, String course_num);

    void deleteForAll(String student_num,String course_num);

    //Integer calculateRanking(Integer student_id,Integer course_id,Integer mark);

    //void updateRanking(Integer student_id,Integer course_id,Integer ranking);

    List<Score> selectAll();

    Score selectByStudentAndCourse(String student_num, String course_num);

    List<Score> selectByStudentId(String student_num);

    List<Score> selectByCourseId(String course_num);

    void saveScore(Score score);

    List<Score> getScoreSorted_Ascending(String course_num);

    List<Score> getScoreSorted_Descending(String course_num);

    void deleteByStudentNum(String student_num);


}
