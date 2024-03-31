package com.evaluation.user.service;

import com.evaluation.util.PagedGridResult;

/**
 * @author 小亮
 **/
public interface UserMngService {

    /**
     * 查询用户列表
     * @param name
     * @param status
     * @param page
     * @param pageSize
     * @return
     */
    public PagedGridResult queryAllUserList(String name, Integer status, Integer page, Integer pageSize);

    /**
     * 冻结或解冻用户状态
     * @param id
     * @param status
     */
    public void freezeUserOrNot(String id, Integer status);

}
