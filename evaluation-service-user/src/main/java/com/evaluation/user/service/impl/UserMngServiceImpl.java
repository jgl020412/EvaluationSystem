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

import java.util.Date;
import java.util.List;

/**
 * @author 小亮
 **/
@Service
public class UserMngServiceImpl extends BaseService implements UserMngService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PagedGridResult queryAllUserList(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<User> list = userMapper.selectAll();
        return setterPagedGrid(list, page);
    }

    @Override
    public PagedGridResult queryAllUserList(User user, Integer page, Integer pageSize) {
        Example userExample = new Example(User.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        String mail = user.getMail();
        String id = user.getId();
        String phoneNum = user.getPhoneNum();
        String job = user.getJob();
        Date birthday = user.getBirthday();
        String province = user.getProvince();
        String city = user.getCity();
        String district = user.getDistrict();
        Integer sex = user.getSex();
        Integer status = user.getStatus();
        if (StringUtils.isNotBlank(mail)) {
            userCriteria.andEqualTo("mail", mail);
        }
        if (StringUtils.isNotBlank(id)) {
            userCriteria.andEqualTo("id", id);
        }
        if (StringUtils.isNotBlank(phoneNum)) {
            userCriteria.andEqualTo("phoneNum", phoneNum);
        }
        if (birthday != null) {
            userCriteria.andEqualTo("birthday", birthday);
        }
        if (StringUtils.isNotBlank(job)) {
            userCriteria.andEqualTo("job", job);
        }
        if (StringUtils.isNotBlank(province)) {
            userCriteria.andEqualTo("province", province);
        }
        if (StringUtils.isNotBlank(city)) {
            userCriteria.andEqualTo("city", city);
        }
        if (StringUtils.isNotBlank(district)) {
            userCriteria.andEqualTo("district", district);
        }
        if (sex != null) {
            userCriteria.andEqualTo("sex", sex);
        }
        if (status != null) {
            userCriteria.andEqualTo("status", status);
        }
        PageHelper.startPage(page, pageSize);
        List<User> users = userMapper.selectByExample(userExample);
        return setterPagedGrid(users, page);
    }

    @Override
    public void freezeUserOrNot(String id, Integer status) {
        User user = new User();
        user.setId(id);
        user.setStatus(status);
        userMapper.updateByPrimaryKeySelective(user);
    }

}
