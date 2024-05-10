package com.evaluation.eval.mapper;

import com.evaluation.pojo.vo.ReplyVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 小亮
 **/
@Repository
public interface ReplyMapperCustom {
    public List<ReplyVO> getReplyVOList(@Param("paramMap") Map<String, Object> map);
}