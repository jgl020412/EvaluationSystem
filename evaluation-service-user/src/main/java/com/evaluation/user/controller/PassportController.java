package com.evaluation.user.controller;

import com.evaluation.api.controller.BaseController;
import com.evaluation.api.controller.user.PassportControllerApi;
import com.evaluation.enums.UserStatus;
import com.evaluation.grace.result.GraceJSONResult;
import com.evaluation.grace.result.ResponseStatusEnum;
import com.evaluation.pojo.User;
import com.evaluation.pojo.bo.RegisterLoginBo;
import com.evaluation.user.service.UserService;
import com.evaluation.util.IPUtil;
import com.evaluation.util.JsonUtils;
import com.evaluation.util.SMSUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author 小亮
 **/
@RestController
public class PassportController extends BaseController implements PassportControllerApi {

    @Autowired
    private SMSUtils smsUtils;

    @Autowired
    private UserService userService;


    @Override
    public GraceJSONResult getSMSCode(String mobile, HttpServletRequest request) {
        // 获取用户Ip
        String userIp = IPUtil.getRequestIp(request);

        // 根据用户IP进行限制，限制用户60秒之内之呢个获取依次验证码
        redisOperator.setnx60s(MOBILE_SMSCODE + ":" + userIp, userIp);

        // 生成最随机证码并且发送短信
        String random = (int) ((Math.random() * 9 + 1) * 10000) + "";
        try {
            smsUtils.sendSMS(mobile, random);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 将验证码存入redis当中，用于后续验证
        redisOperator.set(MOBILE_SMSCODE + ":" + mobile, random, 30 * 60);
        System.out.println(random);

        return GraceJSONResult.ok();
    }

    @Override
    public GraceJSONResult doLogin(RegisterLoginBo registerLoginBo, HttpServletRequest request) {

        String mobile = registerLoginBo.getPhoneNum();
        String smsCode = registerLoginBo.getSmsCode();

        // 1. 校验验证码是否正确
        String redisSmsCode = redisOperator.get(MOBILE_SMSCODE + ":" + mobile);
        if (StringUtils.isBlank(redisSmsCode) || !redisSmsCode.equalsIgnoreCase(smsCode)) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.SMS_CODE_ERROR);
        }

        // 2. 查询数据库，判断该用户是否已经注册
        User user = userService.queryMobileIsExist(mobile);
        if (user != null && user.getStatus() == UserStatus.FROZEN.type) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.USER_FROZEN);
        } else if (user != null) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.USER_IS_EXIST_ERROR);
        } else {
            user = userService.createUser(registerLoginBo);
        }

        return GraceJSONResult.ok(user);

    }


    @Override
    public GraceJSONResult doLogonByPassword(String mobile, String password, HttpServletRequest request, HttpServletResponse response) {
        User user = userService.queryMobileIsExist(mobile);

        // 1. 对登录的信息进行校验
        if (user == null) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.USER_NOT_EXIST_ERROR);
        } else if (!user.getPassword().equals(password)) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.USER_PASSWORD_ERROR);
        } else if (user.getStatus() == UserStatus.FROZEN.type) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.USER_FROZEN);
        }

        // 2. 信息校验成功，执行登录逻辑，保存分布式会话
        // 保存token到redis
        String uToken = UUID.randomUUID().toString();
        redisOperator.set(REDIS_USER_TOKEN + ":" + user.getId(), uToken);
        redisOperator.set(REDIS_USER_INFO + ":" + user.getId(), JsonUtils.objectToJson(user));

        // 保存用户id和token到cookie中
        setCookie(request, response, "utoken", uToken, COOKIE_MONTH);
        setCookie(request, response, "uid", user.getId(), COOKIE_MONTH);

        return GraceJSONResult.ok();
    }

    @Override
    public GraceJSONResult logout(String userId, HttpServletRequest request, HttpServletResponse response) {

        redisOperator.del(REDIS_USER_TOKEN + ":" + userId);

        setCookie(request, response, "utoken", "", COOKIE_DELETE);
        setCookie(request, response, "uid", "", COOKIE_DELETE);

        return GraceJSONResult.ok();
    }

    @Override
    public GraceJSONResult isExit(String mobile, String smsCode, HttpServletRequest request, HttpServletResponse response) {
        User user = userService.queryMobileIsExist(mobile);
        // 1. 校验验证码是否正确
        String redisSmsCode = redisOperator.get(MOBILE_SMSCODE + ":" + mobile);
        if (StringUtils.isBlank(redisSmsCode) || !redisSmsCode.equalsIgnoreCase(smsCode)) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.SMS_CODE_ERROR);
        }
        if (user == null) {
            user = new User();
            user.setPhoneNum(mobile);
        }
        return GraceJSONResult.ok(user);
    }
}
