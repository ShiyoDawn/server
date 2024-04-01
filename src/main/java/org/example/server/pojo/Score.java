package org.example.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.server.mapper.StudentMapper;

@NoArgsConstructor
@Data
@AllArgsConstructor
@TableName("score")
public class Score {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer student_id;

    private String student_name;

    private Integer course_id;

    private String course_name;

    private Integer mark;

    private Integer ranking;

    private Course course;

    private Student student;

    private Integer teacher_id;

}
