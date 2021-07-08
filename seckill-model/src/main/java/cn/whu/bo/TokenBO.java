package cn.whu.bo;

import javax.validation.constraints.NotBlank;

/**
 * @author snow
 * @className TokenBO
 * @date 2021/7/8
 **/
public class TokenBO {
    @NotBlank(message = "商品ID不能为空")
    private String goodId;

    @NotBlank(message = "活动ID不能为空")
    private String activityId;

    private String userId;

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
