package org.example.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("activity")
public class Activity {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(exist = false)
    private Person person;

    private String student_num;

    private String student_name;

    private String activity_name;

    private String activity_type;

    private String score;

    private String date;

    private Integer person_id;
}
