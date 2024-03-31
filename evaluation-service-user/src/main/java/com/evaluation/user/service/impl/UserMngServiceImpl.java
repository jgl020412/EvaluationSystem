package com.evaluation.user.service.impl;

import com.evaluation.api.service.BaseService;
import com.evaluation.enums.UserStatus;
import com.evaluation.pojo.User;
import com.evaluation.user.mapper.UserMapper;
import com.evaluation.user.service.UserMngService;
import com.evaluation.util.PagedGridResult;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author 小亮
 **/
@Service
public class UserMngServiceImpl extends BaseService implements UserMngService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PagedGridResult queryAllUserList(String name, Integer status, Integer page, Integer pageSize) {

        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();

        if (StringUtils.isNotBlank(name)) {
            criteria.andLike("name", "%" + name + "%");
        }

        if (UserStatus.isUserStatusValid(status)) {
            criteria.andEqualTo("status", status);
        }

        PageHelper.startPage(page, pageSize);
        List<User> list = userMapper.selectByExample(example);

        return setterPagedGrid(list, page);
    }

    @Override
    public void freezeUserOrNot(String id, Integer status) {
        User user = new User();
        user.setId(id);
        user.setStatus(status);
        userMapper.updateByPrimaryKeySelective(user);
    }

}
