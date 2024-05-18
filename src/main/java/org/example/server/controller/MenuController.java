package org.example.server.controller;

import org.example.server.mapper.MenuMapper;
import org.example.server.mapper.NoticeMapper;
import org.example.server.payload.Result;
import org.example.server.payload.request.DataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuMapper menuMapper;

    @Autowired
    NoticeMapper noticeMapper;

    @PostMapping("/get")
    public Result getMenu(@RequestBody String type) {
        return new Result(200,menuMapper.selectByAccess(type),"ok");
    }

    @PostMapping("/searchMenu")
    public Result searchMenu(@RequestBody Map<String,String> param) {

        List menuList = menuMapper.selectUn(param.get("type"),param.get("str"));
        if (menuList.isEmpty()) {
            Map nullMenu = new HashMap<>();
            nullMenu.put("name","未找到相关页面");
            menuList.add(nullMenu);
            return new Result(200,menuList,"查询为空");
        }
        else return new Result(200,menuList,"ok");
    }

    @PostMapping("/getNotice")
    public Result getNotice() {
        List<Map> notice = noticeMapper.selectNotice();
        return new Result(200,notice,"ok");
    }

    @PostMapping("/changeNotice")
    public Result changeNotice(@RequestBody DataRequest dataRequest) {
        Map newNotice = dataRequest.getData();
        noticeMapper.updateNotice(newNotice.get("text").toString(), newNotice.get("color").toString());
        return new Result(200,null,"fine");
    }
}
