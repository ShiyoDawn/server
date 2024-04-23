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
    public Result insertGlory(@Valid @RequestBody DataRequest dataRequest){
        Integer student_id=dataRequest.getInteger("student_id");
        String student_name=dataRequest.getString("student_name");
        String glory_name=dataRequest.getString("glory_name");
        String glory_type=dataRequest.getString("glory_type");
        return gloryService.insertGlory(student_name,student_id,glory_name,glory_type);
    }

    @PostMapping("/deleteGlory")
    public Result deleteGlory(@Valid @RequestBody DataRequest dataRequest) {
        String student_name = dataRequest.getString("student_name");
        String glory_name=dataRequest.getString("glory_name");
        return gloryService.deleteGlory(student_name, glory_name);
    }

    @PostMapping("/updateGlory")
    public Result updateGlory(@Valid @RequestBody DataRequest dataRequest) {
        String student_name = dataRequest.getString("student_name");
        String glory_name=dataRequest.getString("glory_name");
        String new_glory_name=dataRequest.getString("new_glory_name");
        String glory_type=dataRequest.getString("glory_type");
        return gloryService.updateGlory(student_name,new_glory_name,glory_name,glory_type);
    }

    @PostMapping("/selectByStudentAndGlory")
    public Result selectByStudentAndGlory(@Valid @RequestBody DataRequest dataRequest){
        String student_name = dataRequest.getString("student_name");
        String glory_name=dataRequest.getString("glory_name");
        return gloryService.selectByStudentAndGlory(student_name,glory_name);
    }

    @PostMapping("/selectByStudentName")
    public Result selectByStudentName(@Valid @RequestBody DataRequest dataRequest){
        String student_name = dataRequest.getString("student_name");
        return gloryService.selectByStudentName(student_name);
    }

    @PostMapping("/selectByGloryName")
    public Result selectByGloryName(@Valid @RequestBody DataRequest dataRequest){
        String glory_name=dataRequest.getString("glory_name");
        return gloryService.selectByGloryName(glory_name);
    }

    @PostMapping("/getGloryList")
    public Result getScoreList() {
        return gloryService.getGloryList();
    }

}
