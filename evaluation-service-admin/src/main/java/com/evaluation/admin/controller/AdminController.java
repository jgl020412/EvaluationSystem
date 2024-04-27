package com.evaluation.admin.controller;

import com.evaluation.admin.service.AdminService;
import com.evaluation.api.controller.BaseController;
import com.evaluation.api.controller.admin.AdminControllerApi;
import com.evaluation.grace.result.GraceJSONResult;
import com.evaluation.grace.result.ResponseStatusEnum;
import com.evaluation.pojo.Admin;
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
public class AdminController extends BaseController implements AdminControllerApi {

    @Autowired
    private AdminService adminService;

    @Override
    public GraceJSONResult doLogonByPassword(String name, String password, HttpServletRequest request, HttpServletResponse response) {

        // 判断名字和密码是否为空
        if (StringUtils.isBlank(name)) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.ADMIN_NOT_EXIT_ERROR);
        }
        if (StringUtils.isBlank(password)) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.ADMIN_PASSWORD_NULL_ERROR);
        }

        // 查询管理员是否存在
        Admin admin = adminService.queryAdminByName(name);
        if (admin == null || !admin.getPassword().equals(password)) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.ADMIN_NOT_EXIT_ERROR);
        }

        // 保存token放入到redis中
        String token = UUID.randomUUID().toString();
        redisOperator.set(REDIS_ADMIN_TOKEN + ":" + admin.getId(), token);

        // 保存admin登录基本token信息到cookie中
        setCookie(request, response, "atoken", token, COOKIE_MONTH);
        setCookie(request, response, "aid", admin.getId(), COOKIE_MONTH);
        setCookie(request, response, "aname", admin.getName(), COOKIE_MONTH);

        return GraceJSONResult.ok(admin);
    }

    @Override
    public GraceJSONResult adminLogout(String adminId, HttpServletRequest request, HttpServletResponse response) {
        // 从redis中删除admin的会话token
        redisOperator.del(REDIS_ADMIN_TOKEN + ":" + adminId);

        // 从cookie中清理adming登录的相关信息
        deleteCookie(request, response, "atoken");
        deleteCookie(request, response, "aid");
        deleteCookie(request, response, "aname");

        return GraceJSONResult.ok();
    }
}
