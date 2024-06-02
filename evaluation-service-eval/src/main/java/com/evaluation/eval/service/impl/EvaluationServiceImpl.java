package com.evaluation.eval.service.impl;

import com.evaluation.api.service.BaseService;
import com.evaluation.eval.mapper.EvaluationCustomMapper;
import com.evaluation.eval.mapper.EvaluationMapper;
import com.evaluation.eval.service.EvaluationService;
import com.evaluation.pojo.Evaluation;
import com.evaluation.pojo.bo.NewEvaluationBO;
import com.evaluation.pojo.vo.EvaluationAnalysisVO;
import com.evaluation.pojo.vo.EvaluationVO;
import com.evaluation.pojo.vo.LevelRatioVO;
import com.evaluation.util.DateUtil;
import com.evaluation.util.PagedGridResult;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.*;
import java.util.logging.Level;

/**
 * @author 小亮
 **/
@Service
public class EvaluationServiceImpl extends BaseService implements EvaluationService {

    @Autowired
    private EvaluationMapper evaluationMapper;

    @Autowired
    private EvaluationCustomMapper evaluationCustomMapper;

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
    public List<EvaluationVO> queryEvaluationList(String serviceId, Date startDate, Date endDate, Integer level) {

        Map<String, Object> map = new HashMap<String, Object>();

        if (StringUtils.isNotBlank(serviceId)) {
            map.put("serviceId", serviceId);
        }

        if (level != null && level >= 0 && level <= 5) {
            map.put("level", level);
        }

        if (startDate != null && endDate != null) {
            map.put("startDate", startDate);
            map.put("endDate", endDate);
        }

        return evaluationCustomMapper.queryEvaluationVOList(map);
    }

    @Override
    public void deleteEvaluation(String id) {
        evaluationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Evaluation queryEvaluation(String id) {
        return evaluationMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer getEvaluationCount(Evaluation evaluation) {
        return evaluationMapper.selectCount(evaluation);
    }

    public static Map<Integer, String> levels = new HashMap<Integer, String>(){{
        put(0, "零星评价");
        put(1, "一星评价");
        put(2, "两星评价");
        put(3, "三星评价");
        put(4, "四星评价");
        put(5, "五星评价");
    }};

    @Override
    public List<LevelRatioVO> getEvaluationRatio() {
        Evaluation evaluation = new Evaluation();
        List<LevelRatioVO> result = new ArrayList<LevelRatioVO>();
        Set<Integer> integers = levels.keySet();
        for (Integer i : integers) {
            LevelRatioVO levelRatioVO = new LevelRatioVO();
            levelRatioVO.setName(levels.get(i));
            evaluation.setLevel(i);
            int count = evaluationMapper.selectCount(evaluation);
            levelRatioVO.setValue(count);
            result.add(levelRatioVO);
        }
        return result;
    }

    @Override
    public List<EvaluationAnalysisVO> getEvaluationAnslysisVOList(Integer level) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("level", level);
        return evaluationCustomMapper.queryEvaluationAnalysisVOList(map);
    }

    @Override
    public List<EvaluationVO> getMyAllEvaluation(String userId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", userId);
        return evaluationCustomMapper.queryEvaluationListOfUser(map);
    }

    @Override
    public List<EvaluationVO> getAllEvaluation() {
        return evaluationCustomMapper.queryAllEvaluationList();
    }
}
