package com.evaluation.pojo;

import javax.persistence.*;

public class Service {
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 名字
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 部门
     */
    @Column(name = "DEPARTMENT")
    private String department;

    /**
     * 详情
     */
    @Column(name = "DETAILS")
    private String details;

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
     * 获取名字
     *
     * @return NAME - 名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名字
     *
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取部门
     *
     * @return DEPARTMENT - 部门
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 设置部门
     *
     * @param department 部门
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 获取详情
     *
     * @return DETAILS - 详情
     */
    public String getDetails() {
        return details;
    }

    /**
     * 设置详情
     *
     * @param details 详情
     */
    public void setDetails(String details) {
        this.details = details;
    }
}