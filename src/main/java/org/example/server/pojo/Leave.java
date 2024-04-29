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

    private String student_num;

    private String student_name;

    private String leave_type;

    private String leave_reason;

    private String destination;

    private String time;

    private String status;
}
