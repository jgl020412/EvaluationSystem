package com.evaluation.api.controller.eval;

import com.evaluation.grace.result.GraceJSONResult;
import com.evaluation.pojo.bo.NewReplyBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author 小亮
 **/
@Api(value = "回复相关业务的controller", tags = {"回复相关业务的controller"})
@RequestMapping("reply")
public interface ReplyControllerApi {
    @PostMapping("createReply")
    @ApiOperation(value = "创建回复", notes = "创建回复", httpMethod = "POST")
    public GraceJSONResult createReply(@RequestBody NewReplyBO newReplyBO);

    @PostMapping("deleteReply")
    @ApiOperation(value = "删除回复", notes = "删除回复", httpMethod = "POST")
    public GraceJSONResult deleteReply(@RequestParam String id);

    @GetMapping("getReplies")
    @ApiOperation(value = "查询回复", notes = "查询回复", httpMethod = "GET")
    public GraceJSONResult getReplies(@RequestParam String evaluationId);
}
