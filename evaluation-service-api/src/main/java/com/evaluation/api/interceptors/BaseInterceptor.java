package com.evaluation.api.interceptors;

import com.evaluation.exception.GraceException;
import com.evaluation.grace.result.ResponseStatusEnum;
import com.evaluation.util.RedisOperator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class BaseInterceptor {

    @Autowired
    public RedisOperator redis;

    public static final String MOBILE_SMSCODE = "mobile:smscode";
    public static final String REDIS_USER_INFO = "redis_user_info";

}