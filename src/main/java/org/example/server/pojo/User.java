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
    @TableField
    private String person_num;
    @TableField
    private String password;
    @TableField
    private Integer user_type_id;
    @TableField
    private String last_login_time;
    @TableField
    private Integer login_count;
    @TableField
    private String create_time;

}
