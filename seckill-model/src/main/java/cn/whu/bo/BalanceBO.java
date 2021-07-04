package cn.whu.bo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author snow
 * @className BalanceBO
 * @date 2021/7/1
 **/
public class BalanceBO implements Serializable {
    private String balanceId;

    @NotBlank(message = "用户ID不能为空")
    private String userId;

    @NotNull(message = "扣除金额不能为空")
    @Min(value = 0,message = "金额最小不能低于0")
    private BigDecimal decrementAmount;

    public String getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(String balanceId) {
        this.balanceId = balanceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getDecrementAmount() {
        return decrementAmount;
    }

    public void setDecrementAmount(BigDecimal decrementAmount) {
        this.decrementAmount = decrementAmount;
    }
}
