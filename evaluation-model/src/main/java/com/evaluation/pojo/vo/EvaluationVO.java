package com.evaluation.pojo.vo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author 小亮
 **/
public class EvaluationVO {
    private String id;

    // 服务的名称

    private String name;;
    /**
     * 服务ID
     */
    private String serviceId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 内容
     */
    private String content;

    /**
     * 星级
     */
    private Integer level;

    /**
     * 时间
     */
    private Date time;

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取服务ID
     *
     * @return SERVICE_ID - 服务ID
     */
    public String getServiceId() {
        return serviceId;
    }

    /**
     * 设置服务ID
     *
     * @param serviceId 服务ID
     */
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * 获取用户ID
     *
     * @return USER_ID - 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取内容
     *
     * @return CONTENT - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取星级
     *
     * @return LEVEL - 星级
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置星级
     *
     * @param level 星级
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取时间
     *
     * @return TIME - 时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置时间
     *
     * @param time 时间
     */
    public void setTime(Date time) {
        this.time = time;
    }
}
