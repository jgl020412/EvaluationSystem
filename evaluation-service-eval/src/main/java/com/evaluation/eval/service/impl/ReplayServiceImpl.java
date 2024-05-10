package com.evaluation.eval.service.impl;

import com.evaluation.api.service.BaseService;
import com.evaluation.eval.mapper.ReplyMapper;
import com.evaluation.eval.mapper.ReplyMapperCustom;
import com.evaluation.eval.service.ReplyService;
import com.evaluation.pojo.Reply;
import com.evaluation.pojo.bo.NewReplyBO;
import com.evaluation.pojo.vo.ReplyVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 小亮
 **/
@Service
public class ReplayServiceImpl extends BaseService implements ReplyService {

    @Autowired
    private ReplyMapper replyMapper;

    @Autowired
    private ReplyMapperCustom replyMapperCustom;

    @Override
    public void createReply(NewReplyBO newReplyBO) {
        String id = sid.nextShort();
        Reply reply = new Reply();

        BeanUtils.copyProperties(newReplyBO, reply);

        reply.setId(id);
        reply.setTime(new Date());

        replyMapper.insert(reply);
    }

    @Override
    public void deleteReply(String id) {
        replyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<ReplyVO> getReplyList(String evaluationId) {
        Map<String, Object> map = new HashMap<>();
        map.put("evaluationId", evaluationId);
        return replyMapperCustom.getReplyVOList(map);
    }
}
