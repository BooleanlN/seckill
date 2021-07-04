package cn.whu.exception;

import cn.whu.enums.STATUS;

import java.io.Serializable;

/**
 * @author snow
 * @className MyCustomException,自定义异常，统一处理，便于解耦
 * @date 2021/5/23
 **/
public class MyCustomException extends RuntimeException implements Serializable {
    private STATUS statusEnum;
    public MyCustomException(STATUS statusEnum){
        super("异常状态码" + statusEnum.getCode()
                +"; 具体异常信息为："+ statusEnum.getMessage());
        this.statusEnum = statusEnum;
    }

    public STATUS getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(STATUS statusEnum) {
        this.statusEnum = statusEnum;
    }
}
