package com.evaluation.pojo.bo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author 小亮
 **/
public class NewEvaluationBO {

    /**
     * 服务ID
     */
    @NotBlank(message = "服务id不能为空")
    private String serviceId;

    /**
     * 用户ID
     */
    @NotBlank(message = "用户id不能为空")
    private String userId;

    /**
     * 内容
     */
    @NotBlank(message = "评价内容不能为空")
    private String content;

    /**
     * 星级
     */
    @NotNull(message = "星级不能为空")
    private Integer level;



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

}
