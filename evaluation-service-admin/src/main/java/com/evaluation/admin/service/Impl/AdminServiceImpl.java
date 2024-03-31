package com.evaluation.admin.service.Impl;

import com.evaluation.admin.mapper.AdminMapper;
import com.evaluation.admin.service.AdminService;
import com.evaluation.api.service.BaseService;
import com.evaluation.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author 小亮
 **/
@Service
public class AdminServiceImpl extends BaseService implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin queryAdminByName(String name) {
        Example adminExample = new Example(Admin.class);
        Example.Criteria criteria = adminExample.createCriteria();
        criteria.andEqualTo("name", name);

        return adminMapper.selectOneByExample(adminExample);
    }
}
