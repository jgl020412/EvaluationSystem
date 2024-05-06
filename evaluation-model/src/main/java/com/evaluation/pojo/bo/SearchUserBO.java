package com.evaluation.pojo.bo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author 小亮
 **/
public class SearchUserBO {
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 姓名
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 密码
     */
    @Column(name = "PASSWORD")
    private String password;

    /**
     * 手机号
     */
    @Column(name = "PHONE_NUM")
    private String phoneNum;

    /**
     * 邮箱地址
     */
    @Column(name = "MAIL")
    private String mail;

    /**
     * 身份证号
     */
    @Column(name = "ID_NUM")
    private String idNum;

    /**
     * 职位
     */
    @Column(name = "JOB")
    private String job;

    /**
     * 性别
     */
    @Column(name = "SEX")
    private Integer sex;

    /**
     * 生日
     */
    @Column(name = "BIRTHDAY")
    private Date birthday;

    /**
     * 省份
     */
    @Column(name = "PROVINCE")
    private String province;

    /**
     * 城市
     */
    @Column(name = "CITY")
    private String city;

    /**
     * 区县
     */
    @Column(name = "DISTRICT")
    private String district;

    /**
     * 用户状态：0：未激活。1：已激活2：已冻结。
     */
    @Column(name = "STATUS")
    private Integer status;

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
     * 获取姓名
     *
     * @return NAME - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取密码
     *
     * @return PASSWORD - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取手机号
     *
     * @return PHONE_NUM - 手机号
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * 设置手机号
     *
     * @param phoneNum 手机号
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     * 获取邮箱地址
     *
     * @return MAIL - 邮箱地址
     */
    public String getMail() {
        return mail;
    }

    /**
     * 设置邮箱地址
     *
     * @param mail 邮箱地址
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * 获取身份证号
     *
     * @return ID_NUM - 身份证号
     */
    public String getIdNum() {
        return idNum;
    }

    /**
     * 设置身份证号
     *
     * @param idNum 身份证号
     */
    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    /**
     * 获取职位
     *
     * @return JOB - 职位
     */
    public String getJob() {
        return job;
    }

    /**
     * 设置职位
     *
     * @param job 职位
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * 获取性别
     *
     * @return SEX - 性别
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取生日
     *
     * @return BIRTHDAY - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取省份
     *
     * @return PROVINCE - 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份
     *
     * @param province 省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取城市
     *
     * @return CITY - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取区县
     *
     * @return DISTRICT - 区县
     */
    public String getDistrict() {
        return district;
    }

    /**
     * 设置区县
     *
     * @param district 区县
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * 获取用户状态：0：未激活。1：已激活2：已冻结。
     *
     * @return STATUS - 用户状态：0：未激活。1：已激活2：已冻结。
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置用户状态：0：未激活。1：已激活2：已冻结。
     *
     * @param status 用户状态：0：未激活。1：已激活2：已冻结。
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}