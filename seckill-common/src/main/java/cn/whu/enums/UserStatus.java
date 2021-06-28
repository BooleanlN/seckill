package cn.whu.enums;

/**
 * @author snow
 * @className UserStatus
 * @date 2021/6/28
 **/
public enum UserStatus {
    /**
     * 激活态
     */
    ACTIVE(1,"激活状态"),
    /**
     * 未激活态，可用于一些黑名单
     */
    NOT_ACTIVE(2,"未激活状态");

    UserStatus(int status,String message){
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private Integer status;
    private String message;
}
