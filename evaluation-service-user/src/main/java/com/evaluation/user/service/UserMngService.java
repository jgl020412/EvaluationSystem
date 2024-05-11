package com.evaluation.user.service;

import com.evaluation.pojo.User;
import com.evaluation.pojo.vo.RegionRatioVO;
import com.evaluation.util.PagedGridResult;

import java.util.List;

/**
 * @author 小亮
 **/
public interface UserMngService {

    /**
     * 查询用户列表
     * @param page
     * @param pageSize
     * @return
     */
    public PagedGridResult queryAllUserList(Integer page, Integer pageSize);

    /**
     * 根据条件获取用户列表
     * @param user
     * @param page
     * @param pageSize
     * @return
     */
    public PagedGridResult queryAllUserList(User user, Integer page, Integer pageSize);

    /**
     * 冻结或解冻用户状态
     * @param id
     * @param status
     */
    public void freezeUserOrNot(String id, Integer status);


    /**
     * 获取用户数量
     * @param user
     * @return
     */
    public Integer getUserCount(User user);

    /**
     * 获取用户地区分布情况
     * @return
     */
    public List<RegionRatioVO> getRegionRatio();

}
