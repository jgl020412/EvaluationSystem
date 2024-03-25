package com.evaluation.user.service;

import com.evaluation.api.service.BaseService;
import com.evaluation.pojo.User;
import com.evaluation.pojo.bo.RegisterLoginBo;
import com.evaluation.pojo.bo.UpdateUserInfoBO;
import org.springframework.stereotype.Service;

/**
 * @author 小亮
 **/
public interface UserService {

    /**
     * 根据手机号查询用户是否存在
     * @param mobile
     * @return 存在则返回用户信息，不存在返回null
     */
    public User queryMobileIsExist(String mobile);

    /**
     * 根据注册信息创建用户
     * @param registerLoginBo
     * @return 返回创建的用户信息
     */
    public User createUser(RegisterLoginBo registerLoginBo);

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return 用户信息对象
     */
    public User queryUserById(String userId);

    /**
     * 更新用户信息
     * @param updateUserInfoBO
     * @return 更新后的用户对象
     */
    public User updateUserInfo(UpdateUserInfoBO updateUserInfoBO);

    /**
     * 删除用户信息
     * @param userId
     * @return 返回删除的用户数量
     */
    public Integer deleteUser(String userId);
}
