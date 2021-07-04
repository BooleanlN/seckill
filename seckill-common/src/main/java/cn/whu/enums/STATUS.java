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
    REQUEST_TIMEOUT(-1003,"请求超时"),
    /**
     * 冻结
     */
    FROZEN_USER(-1004,"用户账户被冻结，请联系管理员"),
    /**
     * 未注册
     */

    NOT_FOUND_USER(-1005,"未找到该用户，请先注册！"),

    UN_LOGIN(-1006,"未登录，请先登录"),

    TICKET_INVALID(-1007,"会话失效，请重新登录！"),

    NULL_POINTER_EXCEPTION(-1008,"空指针错误"),

    GOOD_CREATE_ERROR(-1009,"商品创建失败"),

    STOCK_REDUCE_FAIL(-1010,"库存更新失败"),

    STOCK_NOT_ENOUGH(-1011,"库存不足"),

    ORDER_CREATE_FAIL(-1012,"订单创建失败"),

    USER_CREATE_FAIL(-1013,"用户创建失败"),

    USER_DUPLICATED_FAIL(-1014,"用户已创建"),

    UPDATE_STORAGE_FAIL(-1015,"删减库存失败"),
    UPDATE_BALANCE_FAIL(-1016,"更新余额失败");

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

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
