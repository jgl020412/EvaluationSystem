package com.evaluation.grace.result;

/**
 * 响应结果枚举，用于提供给GraceJSONResult返回给前端的
 * 本枚举类中包含了很多的不同的状态码供使用，可以自定义
 * 便于更优雅的对状态码进行管理，一目了然
 */
public enum ResponseStatusEnum {

    SUCCESS(200, true, "操作成功！"),
    FAILED(500, false, "操作失败！"),

    // 50x
    UN_LOGIN(501,false,"请登录后再继续操作！"),
    TICKET_INVALID(502,false,"会话失效，请重新登录！"),
    SMS_NEED_WAIT_ERROR(505,false,"短信发送太快啦~请稍后再试！"),
    SMS_CODE_ERROR(506,false,"验证码过期或不匹配，请稍后再试！"),
    USER_FROZEN(507,false,"用户已被冻结，请联系管理员！"),
    USER_UPDATE_ERROR(508,false,"用户信息更新失败，请联系管理员！"),
    USER_INACTIVE_ERROR(509,false,"请前往[账号设置]修改信息激活后再进行后续操作！"),
    EVALUATION_DELETE_FAILD(511,false,"评论删除失败"),
    FILE_MAX_SIZE_ERROR(513,false,"仅支持500kb大小以下的图片上传！"),
    USER_STATUS_ERROR(515,false,"用户状态参数出错！"),
    USER_NOT_EXIST_ERROR(516,false,"用户不存在！"),
    USER_IS_EXIST_ERROR(517,false,"用户已经存在！"),
    USER_PASSWORD_ERROR(518,false,"密码错误"),


    ADMIN_PASSWORD_NULL_ERROR(566, false, "密码不能为空！"),
    ADMIN_NOT_EXIT_ERROR(567, false, "管理员不存在或密码错误！"),
    SERVICE_EXIST_ERROR(570, false, "服务已存在，请换一个服务名！"),

    SERVICE_NOT_EXIST_ERROR(581, false, "请选择正确的服务！"),
    EVALUATION_QUERY_PARAMS_ERROR(583, false, "文章列表查询参数错误！"),
    REPLY_DELETE_ERROR(584, false, "回复删除失败！"),


    // 系统错误，未预期的错误 555
    SYSTEM_OPERATION_ERROR(556, false, "操作失败，请重试或联系管理员");

    // 响应业务状态
    private Integer status;
    // 调用是否成功
    private Boolean success;
    // 响应消息，可以为成功或者失败的消息
    private String msg;

    ResponseStatusEnum(Integer status, Boolean success, String msg) {
        this.status = status;
        this.success = success;
        this.msg = msg;
    }

    public Integer status() {
        return status;
    }
    public Boolean success() {
        return success;
    }
    public String msg() {
        return msg;
    }
}
