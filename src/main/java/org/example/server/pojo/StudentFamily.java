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
    private Integer id;

    private Integer student_id;

    private String student_name;

    private String name;//可以改动

    private String phone;//可以改动

    private String age;//可以改动

    private String job;//可以改动

    private String address;//可以改动

    private String relation;
}
