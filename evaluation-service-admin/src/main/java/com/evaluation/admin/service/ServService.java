package com.evaluation.admin.service;

import com.evaluation.pojo.Service;

import java.util.List;

/**
 * @author 小亮
 **/
public interface ServService {

    /**
     * 创建一个服务
     * @param service
     */
    public void createService(Service service);

    /**
     * 修改服务信息
     * @param service
     */
    public void modifyService(Service service);

    /**
     * 查看服务是否存在
     * @param name
     * @return
     */
    public boolean queryServiceIsExist(String name);

    /**
     * 查询服务列表
     * @return
     */
    public List<Service> queryServiceList();

    /**
     * 根据名字查询服务列表
     */
    public List<Service> queryServiceListByName(String name);

    /**
     * 删除指定服务
     * @param id
     */
    public void deleteService(String id);

    /**
     * 获取服务数量
     * @param service
     * @return
     */
    public Integer getServiceCount(Service service);

}
