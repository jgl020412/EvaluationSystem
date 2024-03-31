package com.evaluation.admin.service;

import com.evaluation.pojo.Admin;

/**
 * @author 小亮
 **/
public interface AdminService {

    /**
     * 根据管理员姓名查找管理员信息
     * @param name
     * @return
     */
    public Admin queryAdminByName(String name);

}
