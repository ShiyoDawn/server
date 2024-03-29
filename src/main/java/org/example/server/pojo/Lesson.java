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
@TableName("lesson")
public class Lesson {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer course_id;

    private String time;

    private String date;

    private String time_sort;

    private String homework;
}
