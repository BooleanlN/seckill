package cn.whu.exception;

import cn.whu.enums.STATUS;

/**
 * @author snow
 * @className GraceException
 * @date 2021/6/28
 **/
public class GraceException {
    public static void display(STATUS statusEnum){
        throw new MyCustomException(statusEnum);
    }
}
