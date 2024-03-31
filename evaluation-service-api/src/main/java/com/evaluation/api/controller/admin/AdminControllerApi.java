package com.evaluation.api.controller.admin;

import com.evaluation.grace.result.GraceJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 小亮
 **/
@Api(value = "管理员相关操作", tags = {"管理员相关操作"})
@RequestMapping("admin")
public interface AdminControllerApi {

    @ApiOperation(value = "管理员进行密码登录", notes = "管理员进行密码登录", httpMethod = "POST")
    @PostMapping("/doLogonByPassword")
    public GraceJSONResult doLogonByPassword(@RequestParam String name, @RequestParam String password,
                                             HttpServletRequest request, HttpServletResponse response);

    @ApiOperation(value = "admin退出登录", notes = "admin退出登录", httpMethod = "POST")
    @PostMapping("/adminLogout")
    public GraceJSONResult adminLogout(@RequestParam String adminId,
                                       HttpServletRequest request,
                                       HttpServletResponse response);

}
