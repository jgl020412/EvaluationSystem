package com.evaluation.admin.controller;

import com.evaluation.admin.service.ServService;
import com.evaluation.api.controller.BaseController;
import com.evaluation.api.controller.admin.ServiceMngControllerApi;
import com.evaluation.grace.result.GraceJSONResult;
import com.evaluation.grace.result.ResponseStatusEnum;
import com.evaluation.pojo.Service;
import com.evaluation.pojo.bo.SaveServiceBO;
import com.evaluation.util.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 小亮
 **/
@RestController
public class ServiceMngController extends BaseController implements ServiceMngControllerApi {

    @Autowired
    private ServService servService;

    @Override
    public GraceJSONResult saveOrUpdateCategory(SaveServiceBO saveServiceBO) {
        Service service = new Service();
        BeanUtils.copyProperties(saveServiceBO, service);
        // id为空新增，不为空修改
        if (saveServiceBO.getId() == null) {
            // 查询新增的分类名称不能重复存在
            boolean isExist = servService.queryServiceIsExist(service.getName());
            if (!isExist) {
                // 新增到数据库
                servService.createService(service);
            } else {
                return GraceJSONResult.errorCustom(ResponseStatusEnum.SERVICE_EXIST_ERROR);
            }
        } else {
            // 查询修改的分类名称不能重复存在
            servService.modifyService(service);
        }

        return GraceJSONResult.ok();
    }

    @Override
    public GraceJSONResult getCatList() {
        List<Service> services = servService.queryServiceList();
        return GraceJSONResult.ok(services);
    }

    @Override
    public GraceJSONResult getCats() {
        String allCatJson = redisOperator.get(REDIS_ALL_SERVICE);

        List<Service> categoryList = null;
        if (StringUtils.isBlank(allCatJson)) {
            categoryList = servService.queryServiceList();
            redisOperator.set(REDIS_ALL_SERVICE, JsonUtils.objectToJson(categoryList));
        } else {
            categoryList = JsonUtils.jsonToList(allCatJson, Service.class);
        }

        return GraceJSONResult.ok(categoryList);
    }

    @Override
    public GraceJSONResult deleteService(String id) {
        servService.deleteService(id);
        return GraceJSONResult.ok();
    }
}
