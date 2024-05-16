package org.example.server.controller;

import org.example.server.Service.UserService;
import org.example.server.payload.Result;
import org.example.server.payload.request.DataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.*;
import java.util.Base64;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/updatePassword")
    public void updatePassword(@Valid @RequestBody DataRequest dataRequest) {
        String person_num = dataRequest.getString("person_num");
        String password = dataRequest.getString("password");
        userService.updatePassword(person_num, password);
    }

    @PostMapping("/selectByNum")
    public Result selectByNum(@RequestBody DataRequest dataRequest) {
        String person_num = dataRequest.getString("person_num");
        return userService.selectByNum(person_num);
    }

    @PostMapping(path = "/uploadPhoto")
    public Result uploadPhoto(@RequestBody byte[] barr,
                              @RequestParam(name = "remoteFile") String remoteFile,
                              @RequestParam(name = "fileName") String fileName) {
        try {
            File file=new File("src/main/" + remoteFile+"/"+fileName);
            OutputStream os = new FileOutputStream(new File("src/main/" + remoteFile+"/"+fileName));
            os.write(barr);
            os.close();
            return Result.ok();
        } catch (Exception e) {
            return Result.ok();
        }

    }

    @PostMapping("/getPhoto")
    public Result getPhoto(@RequestBody DataRequest dataRequest) {
        String person_num = dataRequest.getString("person_num");
        File file=new File("src/main/photo/"+person_num+".jpg");
        if(!file.exists()) {
            return Result.error(-1,"文件不存在");
        }
        int len = (int) file.length();
        byte data[] = new byte[len];
        FileInputStream in = null;
        String imgstr=null;
        try {
            in = new FileInputStream(file);
            in.read(data);
            in.close();
            imgstr=new String(Base64.getEncoder().encode(data));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Result.success(imgstr);
    }
}
