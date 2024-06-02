package org.example.exception;

import lombok.Data;
import org.example.common.ErrorEnum;

/**
 * @author haoren
 * @date 2024/06/01 14:19
 **/
@Data
public class BaseException extends RuntimeException {
    private Integer code;

    public BaseException(Integer code) {
        this.code = code;
    }

    public BaseException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public BaseException(String message, Throwable cause, Integer code) {
        super(message, cause);
        this.code = code;
    }

    public BaseException(ErrorEnum errorEnum) {
        super(errorEnum.getMessage());
        this.code = errorEnum.getCode();
    }
}
