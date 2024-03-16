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
    @TableField
    private Integer person_id;
    @TableField
    private String activity_name;
    @TableField
    private String date;
    @TableField
    private String score;
    @TableField
    private Integer activity_type_id;
}
