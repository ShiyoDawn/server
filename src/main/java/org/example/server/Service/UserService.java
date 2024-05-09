package org.example.server.Service;

import org.example.server.mapper.UserMapper;
import org.example.server.payload.Result;
import org.example.server.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public void insert() {
        userMapper.insert1();
    }

    public List<User> delete0() {
        return userMapper.selectAll();
    }

    public Result loginReq(String num, String password) {
        User user = userMapper.selectByNum(num);
        if (user ==  null){
            return new Result(400,null,"用户不存在");
        }
        if (password.equals(user.getPassword())){
            return new Result(200,user,"登陆成功");
        }else {
            return new Result(400,null,"密码错误");
        }
    }

    public Result updatePassword(String person_num, String password) {
        userMapper.updatePassword(person_num, password);
        return new Result(200,null,"修改成功");
    }

}
