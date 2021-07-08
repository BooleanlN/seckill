package cn.whu.bo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author snow
 * @className BuyBO
 * @date 2021/6/27
 **/
public class BuyBO implements Serializable {
    @NotBlank(message = "用户未登录")
    private String userId;

    @NotBlank(message = "未选择商品")
    private String goodId;

    private String activityId;

    @NotBlank(message = "商品数量不能为空")
    @Min(value = 1,message = "最少选择一件商品")
    private Long goodCount;

    @NotBlank(message = "商品价格不能为空")
    @Min(value = 0)
    private BigDecimal money;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public Long getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Long goodCount) {
        this.goodCount = goodCount;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
