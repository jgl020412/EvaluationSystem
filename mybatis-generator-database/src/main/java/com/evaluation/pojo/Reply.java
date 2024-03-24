package com.evaluation.pojo;

import java.util.Date;
import javax.persistence.*;

public class Reply {
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 用户ID
     */
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 父评论ID
     */
    @Column(name = "FATHER_ID")
    private String fatherId;

    /**
     * 评价ID
     */
    @Column(name = "EVALUATION_ID")
    private String evaluationId;

    /**
     * 内容
     */
    @Column(name = "CONTENT")
    private String content;

    /**
     * 时间
     */
    @Column(name = "TIME")
    private Date time;

    /**
     * 是否是管理员发表
     */
    @Column(name = "IS_ADMIN")
    private Integer isAdmin;

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
     * 获取父评论ID
     *
     * @return FATHER_ID - 父评论ID
     */
    public String getFatherId() {
        return fatherId;
    }

    /**
     * 设置父评论ID
     *
     * @param fatherId 父评论ID
     */
    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }

    /**
     * 获取评价ID
     *
     * @return EVALUATION_ID - 评价ID
     */
    public String getEvaluationId() {
        return evaluationId;
    }

    /**
     * 设置评价ID
     *
     * @param evaluationId 评价ID
     */
    public void setEvaluationId(String evaluationId) {
        this.evaluationId = evaluationId;
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

    /**
     * 获取是否是管理员发表
     *
     * @return IS_ADMIN - 是否是管理员发表
     */
    public Integer getIsAdmin() {
        return isAdmin;
    }

    /**
     * 设置是否是管理员发表
     *
     * @param isAdmin 是否是管理员发表
     */
    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }
}