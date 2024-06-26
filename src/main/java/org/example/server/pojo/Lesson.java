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

    private String week;

    private String date;

    private String time_sort;

    private String homework;

    private Integer status;

    private String terms;

    private String classes;

    private String room;

    private String notes;

    private Integer week_time;

    private String attend;

    private String ppt;

    private String ddl;
}
