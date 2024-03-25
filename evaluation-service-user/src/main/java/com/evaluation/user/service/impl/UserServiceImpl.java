package com.evaluation.user.service.impl;

import com.evaluation.api.service.BaseService;
import com.evaluation.enums.UserStatus;
import com.evaluation.pojo.User;
import com.evaluation.pojo.bo.RegisterLoginBo;
import com.evaluation.pojo.bo.UpdateUserInfoBO;
import com.evaluation.user.mapper.UserMapper;
import com.evaluation.user.service.UserService;
import com.evaluation.util.DateUtil;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.unit.DataUnit;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @author 小亮
 **/
@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private Sid sid;

    @Override
    public User queryMobileIsExist(String mobile) {
        Example userExample = new Example(User.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("phoneNum", mobile);
        return userMapper.selectOneByExample(userExample);
    }

    @Transactional
    @Override
    public User createUser(RegisterLoginBo registerLoginBo) {

        User user = new User();

        String userId = sid.nextShort();
        user.setId(userId);

//        user.setName(registerLoginBo.getName());
//        user.setPassword(registerLoginBo.getPassword());
//        user.setPhoneNum(registerLoginBo.getPhoneNum());
//        user.setMail(registerLoginBo.getMail());
//        user.setId(registerLoginBo.getIdNum());
//        user.setJob(registerLoginBo.getJob());
//        user.setSex(registerLoginBo.getSex());
//        user.setCity(registerLoginBo.getCity());
//        user.setDistrict(registerLoginBo.getDistrict());
//        user.setProvince(registerLoginBo.getProvince());

        user.setBirthday(DateUtil.stringToDate(registerLoginBo.getBirthday()));
        BeanUtils.copyProperties(registerLoginBo, user);

        user.setStatus(UserStatus.ACTIVE.type);

        userMapper.insert(user);

        return user;
    }

    @Override
    public User queryUserById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public User updateUserInfo(UpdateUserInfoBO updateUserInfoBO) {
        return null;
    }
}
