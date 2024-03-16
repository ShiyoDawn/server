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
    @TableField
    private Integer person_id;
    @TableField
    private String date;
    @TableField
    private String money;
}
