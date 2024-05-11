package com.evaluation.pojo.vo;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author 小亮
 **/
public class ReplyVO {
    private String id;
    private String userId;
    private String fatherId;
    private String evaluationId;
    private String content;
    private Date time;
    private String fatherContent;
    private Integer isAdmin;
    private String fatherUserId;

    public String getFatherUserId() {
        return fatherUserId;
    }

    public void setFatherUserId(String fatherUserId) {
        this.fatherUserId = fatherUserId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFatherId() {
        return fatherId;
    }

    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }

    public String getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(String evaluationId) {
        this.evaluationId = evaluationId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getFatherContent() {
        return fatherContent;
    }

    public void setFatherContent(String fatherContent) {
        this.fatherContent = fatherContent;
    }

}
