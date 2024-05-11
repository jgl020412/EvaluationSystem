package com.evaluation.admin.service.Impl;

import com.evaluation.admin.mapper.ServiceMapper;
import com.evaluation.admin.service.ServService;
import com.evaluation.api.service.BaseService;
import com.evaluation.exception.GraceException;
import com.evaluation.grace.result.ResponseStatusEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author 小亮
 **/
@Service
public class ServServiceImpl extends BaseService implements ServService {

    @Autowired
    private ServiceMapper serviceMapper;

    @Transactional
    @Override
    public void createService(com.evaluation.pojo.Service service) {

        String id = sid.nextShort();
        service.setId(id);

        int result = serviceMapper.insert(service);
        if (result != 1) {
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
        redisOperator.del(REDIS_ALL_SERVICE);
    }

    @Transactional
    @Override
    public void modifyService(com.evaluation.pojo.Service service) {
        int result = serviceMapper.updateByPrimaryKey(service);
        if (result != 1) {
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
        redisOperator.del(REDIS_ALL_SERVICE);
    }

    @Override
    public boolean queryServiceIsExist(String name) {
        Example example = new Example(com.evaluation.pojo.Service.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", name);

        List<com.evaluation.pojo.Service> serviceList = serviceMapper.selectByExample(example);

        boolean isExist = false;
        if (serviceList != null && !serviceList.isEmpty() && serviceList.size() > 0) {
            isExist = true;
        }

        return isExist;
    }

    @Override
    public List<com.evaluation.pojo.Service> queryServiceList() {
        return serviceMapper.selectAll();
    }

    @Override
    public List<com.evaluation.pojo.Service> queryServiceListByName(String name) {
        Example example = new Example(com.evaluation.pojo.Service.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", name);

        List<com.evaluation.pojo.Service> serviceList = serviceMapper.selectByExample(example);
        return serviceList;
    }

    @Override
    public void deleteService(String id) {
        serviceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer getServiceCount(com.evaluation.pojo.Service service) {
        return serviceMapper.selectCount(service);
    }
}
