package org.example.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@TableName("score")
public class Score {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField
    private Integer student_id;
    @TableField
    private String studnet_name;
    @TableField
    private Integer course_id;
    @TableField
    private String course_name;
    @TableField
    private Integer mark;
    @TableField
    private Integer ranking;
}
