package com.evaluation.api.controller.eval;

import com.evaluation.grace.result.GraceJSONResult;
import com.evaluation.pojo.bo.NewEvaluationBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * @author 小亮
 **/

@Api(value = "评价业务的controller", tags = {"评价业务的controller"})
@RequestMapping("evaluation")
public interface EvaluationControllerApi {

    @PostMapping("createEvaluation")
    @ApiOperation(value = "用户创建评价", notes = "用户创建评价", httpMethod = "POST")
    public GraceJSONResult createArticle(@RequestBody @Valid NewEvaluationBO newEvaluationBO);

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
    public GraceJSONResult queryEvaluationListOfService(@RequestParam String serviceId,
                                                        @RequestParam String date,
                                                        @RequestParam Integer level,
                                                        @RequestParam Integer page,
                                                        @RequestParam Integer pageSize);

}
