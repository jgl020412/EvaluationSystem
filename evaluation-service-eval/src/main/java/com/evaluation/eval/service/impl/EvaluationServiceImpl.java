package com.evaluation.eval.service.impl;

import com.evaluation.api.service.BaseService;
import com.evaluation.eval.mapper.EvaluationMapper;
import com.evaluation.eval.service.EvaluationService;
import com.evaluation.pojo.Evaluation;
import com.evaluation.pojo.bo.NewEvaluationBO;
import com.evaluation.util.DateUtil;
import com.evaluation.util.PagedGridResult;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author 小亮
 **/
@Service
public class EvaluationServiceImpl extends BaseService implements EvaluationService {

    @Autowired
    private EvaluationMapper evaluationMapper;

    @Transactional
    @Override
    public void createEvaluation(NewEvaluationBO newEvaluationBO) {
        String id = sid.nextShort();
        Evaluation evaluation = new Evaluation();
        BeanUtils.copyProperties(newEvaluationBO, evaluation);
        evaluation.setId(id);
        evaluation.setTime(new Date());
        evaluationMapper.insert(evaluation);
    }

    @Override
    public PagedGridResult queryMyList(String userId, String date, String serviceId, Integer level, Integer page, Integer pageSize) {
        Example example = new Example(Evaluation.class);
        example.orderBy("time").desc();
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("userId", userId);

        if (StringUtils.isNotBlank(date)) {
            criteria.andEqualTo("time", DateUtil.stringToDate(date));
        }
        if (StringUtils.isNotBlank(serviceId)) {
            criteria.andEqualTo("serviceId", serviceId);
        }
        if (level != null) {
            criteria.andEqualTo("level", level);
        }

        PageHelper.startPage(page, pageSize);
        List<Evaluation> list = evaluationMapper.selectByExample(example);
        return setterPagedGrid(list, page);
    }

    @Override
    public PagedGridResult queryEvaluationListOfService(String serviceId, String date, Integer level, Integer page, Integer pageSize) {
        Example example = new Example(Evaluation.class);
        example.orderBy("time").desc();
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("serviceId", serviceId);

        if (StringUtils.isNotBlank(date)) {
            criteria.andEqualTo("time", DateUtil.stringToDate(date));
        }

        if (level != null) {
            criteria.andEqualTo("level", level);
        }


        PageHelper.startPage(page, pageSize);
        List<Evaluation> list = evaluationMapper.selectByExample(example);
        return setterPagedGrid(list, page);
    }

    @Override
    public void deleteEvaluation(String id) {
        evaluationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Evaluation queryEvaluation(String id) {
        return evaluationMapper.selectByPrimaryKey(id);
    }
}
