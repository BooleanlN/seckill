package cn.whu.bo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author snow
 * @className UpdateBalanceBO
 * @date 2021/7/1
 **/
public class UpdateBalanceBO implements Serializable {
    @NotBlank(message = "用户不能为空")
    private String userId;

    @NotNull(message = "更新的金额不能为空")
    @Min(value = 0,message = "最小值为0")
    private BigDecimal consumeAmount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getConsumeAmount() {
        return consumeAmount;
    }

    public void setConsumeAmount(BigDecimal consumeAmount) {
        this.consumeAmount = consumeAmount;
    }
}
