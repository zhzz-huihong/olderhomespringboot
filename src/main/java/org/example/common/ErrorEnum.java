package org.example.common;

/**
 * @author haoren
 * @date 2024/06/01 14:10
 **/
public enum ErrorEnum implements ErrorCode {

    SUCCESS(200, "请求处理成功"),
    UNAUTHORIZED(401, "用户认证失败"),
    FORBIDDEN(403, "权限不足"),
    SERVICE_ERROR(500, "服务器去旅行了，请稍后重试"),
    PARAM_INVALID(1000, "无效的参数"),
    ;

    private int code;
    private String msg;

    ErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
