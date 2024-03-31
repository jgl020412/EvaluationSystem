package com.evaluation.pojo.bo;

import javax.validation.constraints.NotBlank;

/**
 * @author 小亮
 **/
public class SaveServiceBO {

    private String id;

    /**
     * 名字
     */
    @NotBlank(message = "名字不能为空")
    private String name;

    /**
     * 部门
     */
    @NotBlank(message = "部门不能为空")
    private String department;

    /**
     * 详情
     */
    private String details;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
