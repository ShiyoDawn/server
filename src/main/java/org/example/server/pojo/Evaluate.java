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
@TableName("evaluate")
public class Evaluate {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer person_id;

    private String activity_name;

    private String date;

    private String score;

    private Integer activity_type_id;
}
