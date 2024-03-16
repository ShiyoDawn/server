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
@TableName("choose_course")
public class ChooseCourse {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField
    private Integer course_id;
    @TableField
    private String course_name;
    @TableField
    private Integer student_id;
    @TableField
    private String student_name;
    @TableField
    private String start_time;
    @TableField
    private String end_time;
}
