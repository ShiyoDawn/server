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
@TableName("student_family")
public class StudentFamily {
    @TableId(type = IdType.AUTO)
    private Integer student_id;

    private String student_name;

    private String name;

    private String phone;

    private String age;

    private String job;

    private String address;

    private String relation;
}
