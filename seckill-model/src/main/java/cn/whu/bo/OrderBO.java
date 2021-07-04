package cn.whu.bo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author snow
 * @className OrderBO
 * @date 2021/6/30
 **/
public class OrderBO implements Serializable {
    private String tradeId;

    @NotBlank(message = "用户ID不能为空")
    private String userId;

    private String activityId;

    @NotBlank(message = "货物ID不能为空")
    private String goodId;

    @NotNull(message = "商品数量为空")
    private Integer goodCount;

    @NotNull(message = "订单金额不能为空")
    private BigDecimal money;

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public Integer getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
