package org.example.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("student")
public class Student {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer person_id;

    private String student_name;

    private String department;

    private String classes;//联查

    private String grade;//联查

    private String major;//联查

    private List<StudentFamily> studentFamilies;

    @TableField(exist = false)
    private Person person;

    private Gender gender;
}
