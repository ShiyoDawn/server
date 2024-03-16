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
@TableName("leave")
public class Leave {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField
    private Integer student_id;
    @TableField
    private Integer teacher_id;
    @TableField
    private String date;
    @TableField
    private String reason;
    @TableField
    private String leave_time;
    @TableField
    private String return_time;
    @TableField
    private String lesson_id;
    @TableField
    private String destination;
    @TableField
    private String status;

}
