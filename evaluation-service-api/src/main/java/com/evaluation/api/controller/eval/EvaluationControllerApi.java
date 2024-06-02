package com.evaluation.api.controller.eval;

import com.evaluation.grace.result.GraceJSONResult;
import com.evaluation.pojo.bo.NewEvaluationBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;

/**
 * @author 小亮
 **/

@Api(value = "评价业务的controller", tags = {"评价业务的controller"})
@RequestMapping("evaluation")
public interface EvaluationControllerApi {

    @PostMapping("createEvaluation")
    @ApiOperation(value = "用户创建评价", notes = "用户创建评价", httpMethod = "POST")
    public GraceJSONResult createEvaluation(@RequestBody @Valid NewEvaluationBO newEvaluationBO);

    @PostMapping("queryMyList")
    @ApiOperation(value = "查询用户的评价列表", notes = "查询用户的评价列表", httpMethod = "POST")
    public GraceJSONResult queryMyList(@RequestParam String userId,
                                       @RequestParam String date,
                                       @RequestParam String serviceId,
                                       @RequestParam Integer level,
                                       @RequestParam Integer page,
                                       @RequestParam Integer pageSize);
    @PostMapping("queryEvaluationListOfService")
    @ApiOperation(value="查询服务下的评价列表", notes = "查询服务下的评价列表", httpMethod = "POST")
    public GraceJSONResult queryEvaluationList(@RequestParam String serviceId,
                                                        @RequestParam String startDate,
                                                        @RequestParam String endDate,
                                                        @RequestParam Integer level) throws ParseException;

    @PostMapping("deleteEvaluation")
    @ApiOperation(value = "删除评价", notes = "删除评价", httpMethod = "POST")
    public GraceJSONResult deleteEvaluation(@RequestParam String id, @RequestParam String userId);

    @GetMapping("queryAllEvaluation")
    @ApiOperation(value = "获取所有评价列表", notes = "获取所有评价列表", httpMethod = "GET")
    public GraceJSONResult queryAllEvaluation();

    @GetMapping("queryEvaluationOfUser")
    @ApiOperation(value = "获取某一个用户的评价列表", notes = "获取某一个用户的评价列表", httpMethod = "GET")
    public GraceJSONResult queryEvaluationOfUser(@RequestParam String userId);

}
