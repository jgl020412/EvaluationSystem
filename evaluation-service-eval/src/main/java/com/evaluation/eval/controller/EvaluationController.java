package com.evaluation.eval.controller;

import com.evaluation.api.controller.BaseController;
import com.evaluation.api.controller.eval.EvaluationControllerApi;
import com.evaluation.eval.service.EvaluationService;
import com.evaluation.grace.result.GraceJSONResult;
import com.evaluation.grace.result.ResponseStatusEnum;
import com.evaluation.pojo.Evaluation;
import com.evaluation.pojo.Service;
import com.evaluation.pojo.bo.NewEvaluationBO;
import com.evaluation.util.JsonUtils;
import com.evaluation.util.PagedGridResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 小亮
 **/
@RestController
public class EvaluationController extends BaseController implements EvaluationControllerApi {

    @Autowired
    private EvaluationService evaluationService;

    @Override
    public GraceJSONResult createEvaluation(NewEvaluationBO newEvaluationBO) {

        String serviceId = newEvaluationBO.getServiceId();

        String allServiceJson = redisOperator.get(REDIS_ALL_SERVICE);

        Service service = null;
        if (StringUtils.isBlank(allServiceJson)) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        } else {
            List<Service> services = JsonUtils.jsonToList(allServiceJson, Service.class);
            for (Service s : services) {
                if (s.getId() == serviceId) {
                    service = s;
                    break;
                }
            }
            if (service == null) {
                return GraceJSONResult.errorCustom(ResponseStatusEnum.SERVICE_NOT_EXIST_ERROR);
            }
        }

        evaluationService.createEvaluation(newEvaluationBO, service);

        return GraceJSONResult.ok();
    }

    @Override
    public GraceJSONResult queryMyList(String userId, String date, String serviceId, Integer level, Integer page, Integer pageSize) {
        if (StringUtils.isBlank(userId)) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.EVALUATION_QUERY_PARAMS_ERROR);
        }

        if (page == null) {
            page = COMMON_START_PAGE;
        }
        if (pageSize == null) {
            pageSize = COMMON_PAGE_SIZE;
        }

        PagedGridResult pagedGridResult = evaluationService.queryMyList(userId, date, serviceId, level, page, pageSize);

        return GraceJSONResult.ok(pagedGridResult);
    }

    @Override
    public GraceJSONResult queryEvaluationListOfService(String serviceId, String date, Integer level, Integer page, Integer pageSize) {
        if (StringUtils.isBlank(serviceId)) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.EVALUATION_QUERY_PARAMS_ERROR);
        }

        if (page == null) {
            page = COMMON_START_PAGE;
        }
        if (pageSize == null) {
            pageSize = COMMON_PAGE_SIZE;
        }

        PagedGridResult pagedGridResult = evaluationService.queryEvaluationListOfService(serviceId, date, level, page, pageSize);

        return GraceJSONResult.ok(pagedGridResult);
    }

    @Override
    public GraceJSONResult deleteEvaluation(String id, String userId) {
        Evaluation evaluation = evaluationService.queryEvaluation(id);
        if (evaluation.getUserId() != userId) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.EVALUATION_DELETE_FAILD);
        }
        evaluationService.deleteEvaluation(id);
        return GraceJSONResult.ok();
    }
}
