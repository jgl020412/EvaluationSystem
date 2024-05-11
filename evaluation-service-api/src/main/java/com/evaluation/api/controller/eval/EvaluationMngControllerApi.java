package com.evaluation.api.controller.eval;

import com.evaluation.grace.result.GraceJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;

/**
 * @author 小亮
 **/
@Api(value = "管理评价的接口定义", tags = {"管理评价的接口定义"})
@RequestMapping("EvaluationMng")
public interface EvaluationMngControllerApi {


    @PostMapping("queryEvaluationList")
    @ApiOperation(value = "查看评价列表", notes = "查看评价列表", httpMethod = "POST")
    public GraceJSONResult queryEvaluationList(String serviceId,
                                               String startDate,
                                               String endDate,
                                               String level) throws ParseException;

    @PostMapping("queryEvaluation")
    @ApiOperation(value = "查看评价", notes = "查看评价", httpMethod = "POST")
    public GraceJSONResult queryEvaluation(@RequestParam String id);

    @PostMapping("deleteEvaluation")
    @ApiOperation(value = "删除评价", notes = "删除评价", httpMethod = "POST")
    public GraceJSONResult deleteEvaluation(@RequestParam String id);

    @GetMapping("getTotalEvaluation")
    @ApiOperation(value = "获取评价总数量", notes = "获取评价总数量", httpMethod = "GET")
    public GraceJSONResult getTotalEvaluationCount();

    @GetMapping("getLevelRatio")
    @ApiOperation(value = "获取评价级别分布情况", notes = "获取评价级别分布情况", httpMethod = "GET")
    public GraceJSONResult getLevelRatio();

    @PostMapping("getAnalysisEvaluation")
    @ApiOperation(value = "满意度排行分析", notes = "满意度排行分析", httpMethod = "POST")
    public GraceJSONResult getAnalysisEvaluation(@RequestParam Integer level);

}
