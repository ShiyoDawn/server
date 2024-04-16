package org.example.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("lesson")
public class Lesson implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer course_id;

    private String course_name;

    private String time;

    private String date;

    private String time_sort;

    private String homework;

    private Integer status;

    private String terms;

    private String classes;

    private Integer teacher_id;

    private String room;

    private String teacher_name;

    private Integer week_time;
}
