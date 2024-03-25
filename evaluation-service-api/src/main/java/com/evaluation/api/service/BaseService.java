package com.evaluation.api.service;

import com.evaluation.util.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 小亮
 **/
public class BaseService {
    @Autowired
    protected RedisOperator redisOperator;
}
