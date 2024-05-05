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
@TableName("fee")
public class Fee {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String student_num;

    private String student_name;

    private String date;

    private String activity;

    private String money;

    private String activity_detail;
}
