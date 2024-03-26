package com.evaluation.eval.service;

import com.evaluation.pojo.bo.NewReplyBO;

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
}
