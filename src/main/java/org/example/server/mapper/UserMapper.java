package org.example.server.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.server.pojo.User;

import java.io.File;
import java.util.List;

@Mapper

public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user")
    List<User> selectAll();

    @Delete("delete from user where id = 1 ")
    public void delete();

    @Insert("insert into user(id) values (null);")
    public void insert1();




}
