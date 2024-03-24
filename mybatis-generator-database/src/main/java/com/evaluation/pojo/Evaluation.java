package com.evaluation.pojo;

import java.util.Date;
import javax.persistence.*;

public class Evaluation {
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 服务ID
     */
    @Column(name = "SERVICE_ID")
    private String serviceId;

    /**
     * 用户ID
     */
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 内容
     */
    @Column(name = "CONTENT")
    private String content;

    /**
     * 星级
     */
    @Column(name = "LEVEL")
    private Integer level;

    /**
     * 时间
     */
    @Column(name = "TIME")
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