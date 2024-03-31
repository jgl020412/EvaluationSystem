package com.evaluation.api.controller.admin;

import com.evaluation.grace.result.GraceJSONResult;
import com.evaluation.pojo.bo.SaveServiceBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author 小亮
 **/
@Api(value = "政务服务维护", tags = {"政务服务维护controller"})
@RequestMapping("serviceMng")
public interface ServiceMngControllerApi {

    @PostMapping("saveOrUpdateCategory")
    @ApiOperation(value = "新增或修改政务服务", notes = "新增或修改政务服务", httpMethod = "POST")
    public GraceJSONResult saveOrUpdateCategory(@RequestBody @Valid SaveServiceBO saveServiceBO);
    @PostMapping("getServiceList")
    @ApiOperation(value = "查询政务服务列表", notes = "查询政务服务列表", httpMethod = "POST")
    public GraceJSONResult getCatList();

    @GetMapping("getServices")
    @ApiOperation(value = "用户端查询政务服务列表", notes = "用户端查询政务服务列表", httpMethod = "GET")
    public GraceJSONResult getCats();

    @PostMapping("deleteService")
    @ApiOperation(value = "删除指定服务", notes = "删除指定服务", httpMethod = "POST")
    public GraceJSONResult deleteService(@RequestParam String id);

}
