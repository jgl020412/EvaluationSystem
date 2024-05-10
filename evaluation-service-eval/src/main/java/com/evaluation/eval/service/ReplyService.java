package com.evaluation.eval.service;

import com.evaluation.pojo.bo.NewReplyBO;
import com.evaluation.pojo.vo.ReplyVO;

import java.util.List;

/**
 * @author 小亮
 **/
public interface ReplyService {
    /**
     * 创建回复
     * @param newReplyBO
     */
    public void createReply(NewReplyBO newReplyBO);

    /**
     * 删除回复
     * @param id
     */
    public void deleteReply(String id);

    /**
     * 获取回复列表
     * @param evaluationId
     */
    public List<ReplyVO> getReplyList(String evaluationId);
}
