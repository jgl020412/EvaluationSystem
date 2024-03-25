package com.evaluation.api.controller.user;

import com.evaluation.grace.result.GraceJSONResult;
import com.evaluation.pojo.bo.RegisterLoginBo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Api(value = "用户注册登录", tags = {"用户注册登录的controller"})
@RequestMapping("passport")
public interface PassportControllerApi {

    @ApiOperation(value = "获得短信验证码", notes = "获得短信验证码", httpMethod = "GET")
    @GetMapping("/getSMSCode")
    public GraceJSONResult getSMSCode(@RequestParam String mobile, HttpServletRequest request);

    @ApiOperation(value = "用户进行注册", notes = "用户进行注册", httpMethod = "POST")
    @PostMapping("/doLogin")
    public GraceJSONResult doLogin(@RequestBody @Valid RegisterLoginBo registerLoginBo, HttpServletRequest request);

    @ApiOperation(value = "用户进行密码登录", notes = "用户进行密码登录", httpMethod = "POST")
    @PostMapping("/doLogonByPassWord")
    public GraceJSONResult doLogonByPassWord(@RequestParam String mobile, @RequestParam String password, HttpServletRequest request, HttpServletResponse response);

    @ApiOperation(value = "用户退出登录", notes = "用户退出登录", httpMethod = "POST")
    @PostMapping("/logout")
    public GraceJSONResult logout(@RequestParam String userId,
                                  HttpServletRequest request,
                                  HttpServletResponse response);
}
