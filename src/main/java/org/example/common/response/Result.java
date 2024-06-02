package org.example.common.response;

import lombok.Data;
import org.example.common.ErrorEnum;

/**
 * @author haoren
 * @date 2024/06/01 14:06
 **/
@Data
public class Result<T> {
    private int code;
    private String msg;

    private T data;

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(ErrorEnum errorEnum, T data) {
        this.code = errorEnum.getCode();
        this.msg = errorEnum.getMessage();
        this.data = data;
    }

    public Result() {
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", data);
    }

    public static <T> Result<T> success(String msg, T data) {
        return new Result<>(200, msg, data);
    }

    public static <T> Result<T> error(ErrorEnum errorEnum, T data) {
        return new Result<>(errorEnum, data);
    }
    public static <T> Result<T> error(int code, String msg) {
        return new Result<>(code, msg);
    }
}
