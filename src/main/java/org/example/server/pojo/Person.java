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
@TableName("person")
public class Person {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField
    private String person_name;
    @TableField
    private Integer gender_id;
    @TableField
    private String phone_number;
    @TableField
    private String identity;
    @TableField
    private String person_num;
    @TableField
    private String birthday;
    @TableField
    private Integer user_type;
    @TableField
    private String department;
    @TableField
    private String email;
    @TableField
    private String identity_number;
}
