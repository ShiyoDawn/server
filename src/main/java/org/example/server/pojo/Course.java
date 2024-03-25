package org.example.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("course")
public class Course implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String course_name;
    private Double credit;
    private Integer num;
    private Integer course_type_id;
    private Integer pre_course_id;
    private String book;
    private String extracurricular;
}
