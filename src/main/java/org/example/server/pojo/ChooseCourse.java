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

    private Integer course_id;

    private String course_name;

    private Integer student_id;

    private String student_name;

    private String start_time;

    private String end_time;
}
