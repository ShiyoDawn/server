package org.example.server.controller;

import com.alibaba.druid.support.json.JSONUtils;
import org.example.server.Service.EvaluateService;
import org.example.server.payload.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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

}
