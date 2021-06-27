package cn.whu.enums;

/**
 * @author snow
 * @className STATUs
 * @date 2021/6/27
 **/
public enum STATUS {
    /**
     * 成功状态
     */
    SUCCESS(200,"请求成功"),
    /**
     * 错误状态
     */
    BAD_REQUEST(400,"错误请求"),
    /**
     * 请求失败
     */
    FAIL_REQUEST(402,"失败请求"),
    /**
     * 权限禁止状态
     */
    FORBIDDEN(403,"禁止请求"),
    /**
     * 未找到
     */
    NOT_FOUND(404,"请求不存在"),
    /**
     * 程序执行错误
     */
    INTERNAL_SERVER_ERROR(500,"内部错误"),
    /**
     * 接口参数验证失败
     */
    PARAMETER_VERIFY_ERROR(-1001, "参数验证失败"),
    /**
     * 请求参数不完整
     */
    PARAMETER_INCOMPLETE(-1002, "请求参数不完整"),
    /**
     * 请求超时 > 30 s
     */
    REQUEST_TIMEOUT(-1003,"请求超时");

    STATUS(Integer value,String message) {
        this.value=value;
        this.message=message;
    }
    public int getCode(){
        return this.value;
    }
    public String  getMessage(){
        return this.message;
    }

    private Integer value;
    private String message;
}
