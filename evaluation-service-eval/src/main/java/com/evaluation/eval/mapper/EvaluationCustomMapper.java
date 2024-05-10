package com.evaluation.eval.mapper;

import com.evaluation.pojo.vo.EvaluationVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 小亮
 **/

@Repository
public interface EvaluationCustomMapper {
    /**
     * 查询服务评论
     */
    public List<EvaluationVO> queryEvaluationVOList(@Param("paramMap") Map<String, Object> map);
}
