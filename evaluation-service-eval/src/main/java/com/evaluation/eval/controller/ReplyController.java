package com.evaluation.eval.controller;

import com.evaluation.api.controller.BaseController;
import com.evaluation.api.controller.eval.ReplyControllerApi;
import com.evaluation.eval.service.ReplyService;
import com.evaluation.grace.result.GraceJSONResult;
import com.evaluation.grace.result.ResponseStatusEnum;
import com.evaluation.pojo.bo.NewReplyBO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小亮
 **/
@RestController
public class ReplyController extends BaseController implements ReplyControllerApi {

    @Autowired
    private ReplyService replyService;

    @Override
    public GraceJSONResult createReply(NewReplyBO newReplyBO) {
        replyService.createReply(newReplyBO);
        return GraceJSONResult.ok();
    }

    @Override
    public GraceJSONResult deleteReply(String id) {
        if (StringUtils.isBlank(id)) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.REPLY_DELETE_ERROR);
        }
        replyService.deleteReply(id);
        return GraceJSONResult.ok();
    }

    @Override
    public GraceJSONResult getReplies(String evaluationId) {
        if (StringUtils.isBlank(evaluationId)) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.SERVICE_NOT_EXIST_ERROR);
        }
        return GraceJSONResult.ok(replyService.getReplyList(evaluationId));
    }

}
