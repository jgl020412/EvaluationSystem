package com.evaluation.eval.controller;

import com.evaluation.api.controller.BaseController;
import com.evaluation.api.controller.eval.EvaluationMngControllerApi;
import com.evaluation.eval.service.EvaluationService;
import com.evaluation.grace.result.GraceJSONResult;
import com.evaluation.pojo.Evaluation;
import com.evaluation.util.PagedGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小亮
 **/
@RestController
public class EvaluationMngController extends BaseController implements EvaluationMngControllerApi {

    @Autowired
    private EvaluationService evaluationService;

    @Override
    public GraceJSONResult queryEvaluationList(String serviceId, Integer page,
                                               Integer pageSize) {
        PagedGridResult pagedGridResult =
                evaluationService.queryEvaluationListOfService(serviceId, null, null, page, pageSize);
        return GraceJSONResult.ok(pagedGridResult);
    }

    @Override
    public GraceJSONResult queryEvaluation(String id) {
        Evaluation evaluation = evaluationService.queryEvaluation(id);
        return GraceJSONResult.ok(evaluation);
    }

    @Override
    public GraceJSONResult deleteEvaluation(String id) {
        evaluationService.deleteEvaluation(id);
        return GraceJSONResult.ok();
    }
}
