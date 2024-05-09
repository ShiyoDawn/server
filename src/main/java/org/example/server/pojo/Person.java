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

    private String person_name;//要

    private Integer gender_id;

    private String phone_number;

    private String identity;

    private String person_num;

    private String birthday;

    private Integer user_type;

    private String department;

    private String email;

    private String identity_number;

    private byte[] photo;

    private Student student;//联

    private Gender gender;//联


}
