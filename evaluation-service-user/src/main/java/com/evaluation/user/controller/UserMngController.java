package com.evaluation.user.controller;

import com.evaluation.api.controller.BaseController;
import com.evaluation.api.controller.user.UserMngControllerApi;
import com.evaluation.enums.UserStatus;
import com.evaluation.grace.result.GraceJSONResult;
import com.evaluation.grace.result.ResponseStatusEnum;
import com.evaluation.pojo.User;
import com.evaluation.pojo.bo.SearchUserBO;
import com.evaluation.user.service.UserMngService;
import com.evaluation.user.service.UserService;
import com.evaluation.util.JsonUtils;
import com.evaluation.util.PagedGridResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 小亮
 **/
@RestController
public class UserMngController extends BaseController implements UserMngControllerApi {

    @Autowired
    private UserMngService userMngService;

    @Autowired
    private UserService userService;

    @Override
    public GraceJSONResult getUserList(Integer page, Integer pageSize) {
        if (page == null) {
            page = COMMON_START_PAGE;
        }

        if (pageSize == null) {
            pageSize = COMMON_PAGE_SIZE;
        }

        PagedGridResult result = userMngService.queryAllUserList(
                page,
                pageSize);

        return GraceJSONResult.ok(result);
    }

    @Override
    public GraceJSONResult getTotalUserCount() {
        Integer userCount = userMngService.getUserCount(null);
        return GraceJSONResult.ok(userCount);
    }

    @Override
    public GraceJSONResult getUserListByCondition(SearchUserBO searchUserBO, Integer page, Integer pageSize) {
        if (page == null) {
            page = COMMON_START_PAGE;
        }

        if (pageSize == null) {
            pageSize = COMMON_PAGE_SIZE;
        }
        User user = new User();
        BeanUtils.copyProperties(searchUserBO, user);
        PagedGridResult pagedGridResult = userMngService.queryAllUserList(user, page, pageSize);
        return GraceJSONResult.ok(pagedGridResult);
    }

    @Override
    public GraceJSONResult freezeUserOrNot(String userId, Integer status) {
        if (!UserStatus.isUserStatusValid(status)) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.USER_STATUS_ERROR);
        }
        userMngService.freezeUserOrNot(userId, status);

        // 刷新用户状态：
        // 1. 删除用户会话，从而保障用户需要重新登录以后再来刷新他的会话状态
        // 2. 查询最新用户的信息，重新放入redis中，做一次更新
        redisOperator.del(REDIS_USER_INFO + ":" + userId);

        return GraceJSONResult.ok();
    }

    @Override
    public GraceJSONResult userDetail(String userId) {
        if (StringUtils.isBlank(userId)) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.USER_NOT_EXIST_ERROR);
        }

        return GraceJSONResult.ok(userService.queryUserById(userId));
    }

    @Override
    public GraceJSONResult getRegionRatioOfUser() {
        return GraceJSONResult.ok(userMngService.getRegionRatio());
    }
}
