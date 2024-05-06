package com.evaluation.api.controller.user;

import com.evaluation.grace.result.GraceJSONResult;
import com.evaluation.pojo.bo.SearchUserBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 小亮
 **/
@Api(value = "有关用户管理的接口定义", tags = {"有关用户管理的接口定义"})
@RequestMapping("userMng")
public interface UserMngControllerApi {

    @ApiOperation(value = "获得用户列表", notes = "获得用户列表", httpMethod = "POST")
    @PostMapping("/getUserList")
    public GraceJSONResult getUserList(@RequestParam Integer page,
                                       @RequestParam Integer pageSize);


    @ApiOperation(value = "根据条件获取用户列表", notes = "根据条件获取用户列表", httpMethod = "POST")
    @PostMapping("/getUserListByCondition")
    public GraceJSONResult getUserListByCondition(@RequestBody SearchUserBO searchUserBO, Integer page,
                                                  Integer pageSize);

    @ApiOperation(value = "冻结或解冻用户", notes = "冻结或解冻用户", httpMethod = "POST")
    @PostMapping("/freezeUserOrNot")
    public GraceJSONResult freezeUserOrNot(@RequestParam String userId, @RequestParam Integer status);

    @ApiOperation(value = "查看用户详情", notes = "查看用户详情", httpMethod = "POST")
    @PostMapping("/userDetail")
    public GraceJSONResult userDetail(@RequestParam String userId);
}
