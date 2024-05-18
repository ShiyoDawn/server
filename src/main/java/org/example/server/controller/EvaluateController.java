package org.example.server.controller;


import org.example.server.Service.EvaluateService;
import org.example.server.payload.Result;
import org.example.server.payload.request.DataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evaluate")
public class EvaluateController {
    @Autowired
    private EvaluateService evaluateService;
    @PostMapping("/getEvaluateList")
    public Result getEvaluateList() {
        return Result.success(evaluateService.findAllEvaluate());
    }
    @PostMapping("/addEvaluate")
    public Result addEvaluate(@RequestBody DataRequest dataRequest) {
        try {
            evaluateService.addEvaluate(dataRequest.getData());
            return Result.ok();
        }
        catch (Exception e){
            return Result.error(404,e.getMessage());
        }
    }
}
