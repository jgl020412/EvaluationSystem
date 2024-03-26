package com.evaluation.pojo.bo;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author 小亮
 **/
public class NewReplyBO {
    /**
     * 用户ID
     */
    @NotBlank(message = "当前用户信息不正确，请尝试重新登陆")
    private String userId;

    /**
     * 父评论ID
     */
    @NotBlank(message = "留言对象状态不正确，请联系管理员")
    private String fatherId;

    /**
     * 评价ID
     */
    @NotBlank(message = "留言对象状态不正确，请联系管理员")
    private String evaluationId;

    /**
     * 内容
     */
    @NotBlank(message = "留言信息不完整")
    private String content;

    /**
     * 是否是管理员发表
     */
    @NotNull(message = "留言信息不完整")
    private Integer isAdmin;


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
