package com.evaluation.eval.service;

import com.evaluation.pojo.Service;
import com.evaluation.pojo.bo.NewEvaluationBO;
import com.evaluation.util.PagedGridResult;

/**
 * @author 小亮
 **/
public interface EvaluationService {

    /**
     * 创建评价
     * @param newEvaluationBO
     * @param service
     */
    public void createEvaluation(NewEvaluationBO newEvaluationBO, Service service);

    /**
     * 查询我的评价
     * @param userId
     * @param date
     * @param serviceId
     * @param level
     * @param page
     * @param pageSize
     */
    public PagedGridResult queryMyList(String userId, String date, String serviceId, Integer level, Integer page, Integer pageSize);

    /**
     * 查询指定服务的评价列表
     * @param serviceId
     * @param date
     * @param level
     * @param page
     * @param pageSize
     * @return
     */
    public PagedGridResult queryEvaluationListOfService(String serviceId, String date, Integer level, Integer page, Integer pageSize);

}
