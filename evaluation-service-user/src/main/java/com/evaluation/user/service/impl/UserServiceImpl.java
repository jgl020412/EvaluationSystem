package com.evaluation.user.service.impl;

import com.evaluation.api.service.BaseService;
import com.evaluation.enums.UserStatus;
import com.evaluation.exception.GraceException;
import com.evaluation.grace.result.ResponseStatusEnum;
import com.evaluation.pojo.User;
import com.evaluation.pojo.bo.RegisterLoginBo;
import com.evaluation.pojo.bo.UpdateUserInfoBO;
import com.evaluation.user.mapper.UserMapper;
import com.evaluation.user.service.UserService;
import com.evaluation.util.DateUtil;
import com.evaluation.util.JsonUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.unit.DataUnit;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

import static com.evaluation.api.controller.BaseController.REDIS_USER_INFO;

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
        String userId = updateUserInfoBO.getId();
        // 保证双写一致，先删除redis中的数据，后更新数据库
        redisOperator.del(REDIS_USER_INFO + ":" + userId);

        User userInfo = new User();
        BeanUtils.copyProperties(updateUserInfoBO, userInfo);

        int result = userMapper.updateByPrimaryKeySelective(userInfo);
        if (result != 1) {
            GraceException.display(ResponseStatusEnum.USER_UPDATE_ERROR);
        }

        // 再次查询用户的最新信息，放入redis中
        User user = queryUserById(userId);
        redisOperator.set(REDIS_USER_INFO + ":" + userId, JsonUtils.objectToJson(user));

        // 缓存双删策略
        try {
            Thread.sleep(100);
            redisOperator.del(REDIS_USER_INFO + ":" + userId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Integer deleteUser(String userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }
}
