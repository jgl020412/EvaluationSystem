package com.evaluation.eval.controller;

import com.evaluation.api.controller.BaseController;
import com.evaluation.api.controller.eval.EvaluationMngControllerApi;
import com.evaluation.eval.service.EvaluationService;
import com.evaluation.grace.result.GraceJSONResult;
import com.evaluation.pojo.Evaluation;
import com.evaluation.pojo.vo.EvaluationVO;
import com.evaluation.util.PagedGridResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 小亮
 **/
@RestController
public class EvaluationMngController extends BaseController implements EvaluationMngControllerApi {

    @Autowired
    private EvaluationService evaluationService;

    @Override
    public GraceJSONResult queryEvaluationList(String serviceId, String startDate, String endDate, String level) throws ParseException {
        Date start = null;
        Date end = null;
        if (StringUtils.isNotBlank(startDate) && StringUtils.isNotBlank(endDate)) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            start = dateFormat.parse(startDate);
            end = dateFormat.parse(endDate);
        }
        Integer levelNum = null;
        if (StringUtils.isNotBlank(level)) {
            levelNum = Integer.parseInt(level);
        }
        List<EvaluationVO> evaluations = evaluationService.queryEvaluationList(serviceId, start, end, levelNum);
        return GraceJSONResult.ok(evaluations);
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

    @Override
    public GraceJSONResult getTotalEvaluationCount() {
        return GraceJSONResult.ok(evaluationService.getEvaluationCount(null));
    }

    @Override
    public GraceJSONResult getLevelRatio() {
        return GraceJSONResult.ok(evaluationService.getEvaluationRatio());
    }

    @Override
    public GraceJSONResult getAnalysisEvaluation(Integer level) {
        return GraceJSONResult.ok(evaluationService.getEvaluationAnslysisVOList(level));
    }
}
