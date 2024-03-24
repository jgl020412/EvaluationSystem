package com.evaluation.user.controller;

import com.evaluation.api.controller.user.PassportControllerApi;
import com.evaluation.grace.result.GraceJSONResult;
import com.evaluation.util.SMSUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 小亮
 **/
@RestController
public class PassportController implements PassportControllerApi {

    final static Logger logger = LoggerFactory.getLogger(PassportController.class);

    @Autowired
    private SMSUtils smsUtils;

    @Override
    public GraceJSONResult getSMSCode(String mobile, HttpServletRequest request) {
        // 生成随机验证码并且发送短信
        String random = (int) ((Math.random() * 9 + 1) * 100000) + "";
        smsUtils.sendSMS(mobile, random);
        return GraceJSONResult.ok();
    }

    @Override
    public GraceJSONResult logout(String userId, HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
