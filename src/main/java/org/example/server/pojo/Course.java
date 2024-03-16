package org.example.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("course")
public class Course {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField
    private String course_name;
    @TableField
    private Double credit;
    @TableField
    private Integer num;
    @TableField
    private Integer course_type_id;
    @TableField
    private Integer pre_course_id;
    @TableField
    private String book;
    @TableField
    private String extracurricular;
}
