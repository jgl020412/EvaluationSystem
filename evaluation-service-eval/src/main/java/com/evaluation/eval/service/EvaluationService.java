package com.evaluation.eval.service;

import com.evaluation.pojo.Evaluation;
import com.evaluation.pojo.bo.NewEvaluationBO;
import com.evaluation.pojo.vo.EvaluationAnalysisVO;
import com.evaluation.pojo.vo.EvaluationVO;
import com.evaluation.pojo.vo.LevelRatioVO;
import com.evaluation.util.PagedGridResult;

import java.util.Date;
import java.util.List;

/**
 * @author 小亮
 **/
public interface EvaluationService {

    /**
     * 创建评价
     * @param newEvaluationBO
     */
    public void createEvaluation(NewEvaluationBO newEvaluationBO);

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
     * 根据条件查询评价列表
     *
     * @param serviceId
     * @param startDate
     * @param endDate
     * @param level
     * @return
     */
    public List<EvaluationVO> queryEvaluationList(String serviceId, Date startDate, Date endDate, Integer level);

    /**
     * 删除评论
     * @param id
     */
    public void deleteEvaluation(String id);

    /**
     * 查询指定id的评论
     * @param id
     * @return
     */
    public Evaluation queryEvaluation(String id);

    /**
     * 获取评价数量
     * @param evaluation
     * @return
     */
    public Integer getEvaluationCount(Evaluation evaluation);

    /**
     * 获取评价级别的分布情况
     * @return
     */
    public List<LevelRatioVO> getEvaluationRatio();

    /**
     * 获取满意度分析的数据
     * @param level
     * @return
     */
    public List<EvaluationAnalysisVO> getEvaluationAnslysisVOList(Integer level);

}
