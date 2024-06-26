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

    private String student_num;

    private String student_name;

    private String course_num;

    private String course_name;

    private Double mark;

    @TableField(exist = false)
    private Course course;

    @TableField(exist = false)
    private Student student;

    @TableField(exist = false)
    private Person person;

    private Integer person_id;

    private Integer course_id;

}
