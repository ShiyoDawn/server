package org.example.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User implements Serializable {
    @TableId(type= IdType.AUTO)
    private Integer id;

    private String person_num;

    private String password;

    private Integer user_type_id;

    private String last_login_time;

    private Integer login_count;

    private String create_time;

    @TableField(exist = false)
    private Person person;

    private Integer person_id;

}
