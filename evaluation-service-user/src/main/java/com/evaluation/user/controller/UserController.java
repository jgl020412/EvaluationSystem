package com.evaluation.user.controller;

import com.evaluation.api.controller.BaseController;
import com.evaluation.api.controller.user.UserControllerApi;
import com.evaluation.grace.result.GraceJSONResult;
import com.evaluation.grace.result.ResponseStatusEnum;
import com.evaluation.pojo.User;
import com.evaluation.pojo.bo.UpdateUserInfoBO;
import com.evaluation.pojo.vo.UserInfoVO;
import com.evaluation.user.service.UserService;
import com.evaluation.util.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小亮
 **/
@RestController
public class UserController extends BaseController implements UserControllerApi {

    @Autowired
    private UserService userService;

    @Override
    public GraceJSONResult getAccountInfo(String userId) {
        // 1. 判断参数不能为空
        if (StringUtils.isBlank(userId)) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.UN_LOGIN);
        }

        // 2. 根据userId查询用户的信息
        User user = getUser(userId);
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(user, userInfoVO);

        return GraceJSONResult.ok(userInfoVO);
    }

    private User getUser(String userId) {
        // 查询判断redis中是否包含用户信息，如果包含，则查询后直接返回，就不去查询数据库了
        String userJson = redisOperator.get(REDIS_USER_INFO + ":" + userId);
        User user = null;
        if (StringUtils.isNoneBlank(userJson)) {
            user = JsonUtils.jsonToPojo(userJson, User.class);
        } else {
            user = userService.queryUserById(userId);
            // 由于用户的信息不怎么变动，对于一些千万级的网站来说，这类信息不会直接去查询数据库
            // 那么完全依赖redis，直接把查询后的数据存入到redis当中
            redisOperator.set(REDIS_USER_INFO + ":" + userId, JsonUtils.objectToJson(user));
        }
        return user;
    }

    @Override
    public GraceJSONResult updateUserInfo(UpdateUserInfoBO updateUserInfoBO) {
        User user = userService.updateUserInfo(updateUserInfoBO);
        redisOperator.set(REDIS_USER_INFO + ":" + updateUserInfoBO.getId(), JsonUtils.objectToJson(user));
        return GraceJSONResult.ok();
    }

    @Override
    public GraceJSONResult deleteUser(String userId) {
        userService.deleteUser(userId);
        redisOperator.del(REDIS_USER_INFO + ":" + userId);
        redisOperator.del(REDIS_USER_TOKEN + ":" + userId);
        return GraceJSONResult.ok();
    }
}
