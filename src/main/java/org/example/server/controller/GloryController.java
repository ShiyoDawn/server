package org.example.server.controller;

import org.example.server.Service.GloryService;
import org.example.server.payload.Result;
import org.example.server.payload.request.DataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/glory")
public class GloryController {
    @Autowired
    private GloryService gloryService;

    @PostMapping("/insertGlory")
    public Result insertGlory(@Valid @RequestBody DataRequest dataRequest) {
        String student_num = dataRequest.getString("student_num");
        String student_name = dataRequest.getString("student_name");
        String glory_name = dataRequest.getString("glory_name");
        String glory_type = dataRequest.getString("glory_type");
        String glory_level = dataRequest.getString("glory_level");
        System.out.println(dataRequest.getData());
        return gloryService.insertGlory(student_name, student_num, glory_name, glory_type, glory_level);
    }

    @PostMapping("/deleteGlory")
    public Result deleteGlory(@Valid @RequestBody DataRequest dataRequest) {
        String student_name = dataRequest.getString("student_name");
        String glory_name = dataRequest.getString("glory_name");
        return gloryService.deleteGlory(student_name, glory_name);
    }

    @PostMapping("/updateGlory")
    public Result updateGlory(@Valid @RequestBody DataRequest dataRequest) {
        String student_name = dataRequest.getString("student_name");
        String glory_name = dataRequest.getString("glory_name");
        String raw_glory_name = dataRequest.getString("raw_glory_name");
        String glory_level = dataRequest.getString("glory_level");
        String glory_type = dataRequest.getString("glory_type");
        return gloryService.updateGlory(student_name, glory_name, raw_glory_name, glory_level, glory_type);
    }

    @PostMapping("/selectByStudentAndGlory")
    public Result selectByStudentAndGlory(@Valid @RequestBody DataRequest dataRequest) {
        String student_name = dataRequest.getString("student_name");
        String glory_name = dataRequest.getString("glory_name");
        System.out.println(dataRequest.getData());
        return gloryService.selectByStudentAndGlory(student_name, glory_name);
    }

    @PostMapping("/selectByStudentName")
    public Result selectByStudentName(@Valid @RequestBody DataRequest dataRequest) {
        String student_name = dataRequest.getString("student_name");
        return gloryService.selectByStudentName(student_name);
    }

    @PostMapping("/selectByGloryName")
    public Result selectByGloryName(@Valid @RequestBody DataRequest dataRequest) {
        String glory_name = dataRequest.getString("glory_name");
        return gloryService.selectByGloryName(glory_name);
    }

    @PostMapping("/selectByStudentNum")
    public Result selectByStudentNum(@Valid @RequestBody DataRequest dataRequest) {
        String student_num = dataRequest.getString("student_num");
        return gloryService.selectByStudentNum(student_num);
    }

    @PostMapping("/selectById")
    public Result selectById(@Valid @RequestBody DataRequest dataRequest) {
        Integer id = dataRequest.getInteger("id");
        return gloryService.selectById(id);
    }

    @PostMapping("/getGloryList")
    public Result getScoreList() {
        return gloryService.getGloryList();
    }

}
