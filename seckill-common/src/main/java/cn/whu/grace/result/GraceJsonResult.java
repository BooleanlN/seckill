package cn.whu.grace.result;

import cn.whu.enums.STATUS;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

/**
 * @author snow
 * @className GraceJsonResult
 * @date 2021/6/27
 **/
@Data
@Builder
@ToString
public class GraceJsonResult {
    private Integer code;
    private String message;
    private Object data;
    private String requestId;

    public static class GraceJsonResultBuilder{
        public GraceJsonResultBuilder status(STATUS status){
            this.code=status.getCode();
            this.message=status.getMessage();
            return this;
        }
    }
    @Override
    public String toString() {
        String builder = "{'code':" +
                getCode() +
                ",'message': '" +
                getMessage() +
                "'}";
        return builder;
    }

    /**
     * 请求成功，返回数据
     * @return
     */
    public static GraceJsonResult ok(){
        return GraceJsonResult.builder().status(STATUS.SUCCESS).build();
    }
    public static GraceJsonResult ok(Object data){
        return GraceJsonResult.builder().status(STATUS.SUCCESS).data(data).build();
    }

    /**
     * 失败响应
     * @return
     */
    public static GraceJsonResult error(){
        return GraceJsonResult.builder().status(STATUS.INTERNAL_SERVER_ERROR).build();
    }
    public static GraceJsonResult errorMap(Map map){
        return GraceJsonResult.builder().status(STATUS.INTERNAL_SERVER_ERROR).data(map).build();
    }

    /**
     * 自定义状态
     * @param status
     * @return
     */
    public static GraceJsonResult errorCustom(STATUS status){
        return GraceJsonResult.builder().code(status.getCode()).message(status.getMessage()).build();
    }

    public static GraceJsonResult exception(STATUS status){
        return GraceJsonResult.builder().code(status.getCode()).message(status.getMessage()).build();
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
