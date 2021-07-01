package cn.whu.exception;

import cn.whu.enums.STATUS;
import cn.whu.grace.result.GraceJsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author snow
 * @className GraceExceptionHandler
 * @date 2021/5/24
 **/

/**
 * 统一异常拦截处理
 */
@ControllerAdvice
public class GraceExceptionHandler {
    final static Logger logger = LoggerFactory.getLogger(GraceExceptionHandler.class);


    @ExceptionHandler(MyCustomException.class)
    @ResponseBody
    public GraceJsonResult returnMyException(MyCustomException e){
        logger.error("【系统抛出Exception异常】 —— 异常内容如下：{}" , e);
        return GraceJsonResult.exception(e.getStatusEnum());
    }

    // 基于DO的验证错误处理
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public GraceJsonResult returnException(MethodArgumentNotValidException e){
        logger.error("【系统抛出Exception异常】 —— 异常内容如下：{}" , e);
        BindingResult bindingResult = e.getBindingResult();
        Map<String,String> results = getErrors(bindingResult);
        return GraceJsonResult.errorMap(results);
    }
    public Map<String, String> getErrors(BindingResult result) {
        Map<String, String> map = new HashMap<>();
        List<FieldError> errorList = result.getFieldErrors();
        for (FieldError error : errorList) {
            // 发送验证错误的时候所对应的某个属性
            String field = error.getField();
            // 验证的错误消息
            String msg = error.getDefaultMessage();
            map.put(field, msg);
        }
        return map;
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public GraceJsonResult returnNullPointerException(NullPointerException e){
        logger.error("【系统抛出Exception异常】 —— 异常内容如下：{}" , e);
        String message = e.getMessage();
        STATUS exce = STATUS.NULL_POINTER_EXCEPTION;
        exce.setMessage(message);
        return GraceJsonResult.errorCustom(exce);
    }
}
