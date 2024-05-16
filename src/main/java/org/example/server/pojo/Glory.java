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
@TableName("glory")
public class Glory {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String student_name;

    private String student_num;

    private String glory_name;

    private String glory_type;

    private String glory_level;

    @TableField(exist = false)
    private Person person;

    private Integer person_id;
}
