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

    private Integer student_id;

    private Integer teacher_id;

    private String date;

    private String reason;

    private String leave_time;

    private String return_time;

    private String lesson_id;

    private String destination;

    private String status;

}
