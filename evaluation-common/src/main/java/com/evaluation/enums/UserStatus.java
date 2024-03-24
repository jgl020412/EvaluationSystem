package com.evaluation.enums;

/**
 * @Desc: 用户状态 枚举
 */
public enum UserStatus {

    INACTIVE(0, "未激活"),
    ACTIVE(1, "已激活"),
    FROZEN(2, "已冻结");

    public final Integer type;
    public final String value;

    UserStatus(Integer type, String value) {
        this.type = type;
        this.value = value;
    }

    public static boolean isUserStatusValid(Integer tempStatus) {
        if (tempStatus != null) {
            if (tempStatus == INACTIVE.type || tempStatus == ACTIVE.type || tempStatus == FROZEN.type) {
                return true;
            }
        }
        return false;
    }

}
