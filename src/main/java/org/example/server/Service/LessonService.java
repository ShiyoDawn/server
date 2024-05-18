package org.example.server.Service;

import org.example.server.mapper.LessonMapper;
import org.example.server.payload.Result;
import org.example.server.payload.response.DataResponse;
import org.example.server.pojo.Glory;
import org.example.server.pojo.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LessonService {
    @Autowired
    LessonMapper lessonMapper;
    public Result updateHomework(String homework,Integer id){
        lessonMapper.updateHomework(homework, id);
        return Result.ok("添加作业成功");
    }
    public Result selectAllHomeworkFromStudent(Integer id){
        List<String> slist = lessonMapper.selectAllHomeworkFromStudent(id);
        if(slist == null || slist.size() == 0){
            return Result.ok("所有作业均已完成");
        }else {
            return Result.success(slist);
        }
    }
    public Result selectAllHomeworkFromTeacher(Integer id){
        List<String> slist = lessonMapper.selectAllHomeworkFromTeacher(id);
        if(slist == null || slist.size() == 0){
            return Result.ok("还没有人提交作业");
        } else {
            return Result.success(slist);
        }
    }
    public Result selectOneLessonFromStudent(Integer course_id,Integer student_id){
        List<Lesson> slist = lessonMapper.selectOneLessonFromStudent(course_id,student_id);
        if(slist == null){
            return Result.error(400,"没有此课程");
        } else {
            return Result.success(slist);
        }
    }
    public Result selectOneLessonFromTeacher(Integer course_id,Integer teacher_id){
        List<Lesson> slist = lessonMapper.selectOneLessonFromTeacher(course_id,teacher_id);
        if(slist == null){
            return Result.error(400,"没有此课程");
        } else {
            return Result.success(slist);
        }
    }
    public Result updateHomeworkRating(Integer homework_rating_id,Integer lesson_id,Integer student_id) {
        lessonMapper.updateHomeworkRating(homework_rating_id,lesson_id,student_id);
        return Result.ok("更改成功");
    }
    public Result selectHomeworkRatingStudent(Integer lesson_id,Integer student_id) {
        List<String> slist = lessonMapper.selectHomeworkRatingStudent(lesson_id,student_id);
        if(slist == null){
            return Result.ok("老师暂未评定");
        } else {
            return Result.success(slist);
        }
    }
    public Result selectHomeworkRatingTeacher(Integer lesson_id,Integer teacher_id) {
        List<String> slist = lessonMapper.selectHomeworkRatingTeacher(lesson_id,teacher_id);
        if(slist == null){
            return Result.ok("您暂未评定");
        } else {
            return Result.success(slist);
        }
    }
    public Result selectLesson(){
        return Result.success(lessonMapper.selectLesson());
    }
    public Result selectByCourseId(Integer id){
        return Result.success(lessonMapper.selectByCourseId(id));
    }
    public Result addLesson(List<List<String>> list1,List<List<String>> list){
        for (List<String> strings : list) {
            lessonMapper.addLesson(idC(String.valueOf(list1.get(0).get(0))), idC(String.valueOf(strings.get(0))),idC(String.valueOf(strings.get(1))),idC(String.valueOf(strings.get(2))));
        }
        return Result.ok("添加成功");
    }
    private String idC(String str){
        int count = str.length();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '.'){
                count = i;
            }
        }
        return str.substring(0,count);
    }
    public Result updateInfo(Integer course_id,Integer week,Integer week_time,Integer time_sort,String notes,String room,String homework,String ppt,String ddl){
        if ((notes == null || notes.equals("")) && (room == null || room.equals("")) && !((homework != null && !(homework.equals(""))) && (!(ddl.equals("null"))  && !(ddl.equals(""))))&& (ppt == null || ppt.equals(""))) {
            return Result.error(400,"不能输入空值");
        } else {
            lessonMapper.updateInfo(course_id,week,week_time,time_sort,notes,room,homework,ppt,ddl);
            return Result.ok("添加成功");
        }
    }
    public Result deleteLesson(Integer course_id,Integer week,Integer week_time,Integer time_sort){
        lessonMapper.deleteLesson(course_id,week,week_time,time_sort);
        return Result.ok("删除成功");
    }
}
