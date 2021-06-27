package cn.whu.bo;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * @author snow
 * @className GoodBO
 * @date 2021/6/28
 **/
public class GoodBO {
    @NotBlank(message = "商品Id不能为空")
    private String goodId;

    private String goodName;

    private BigDecimal amount;

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
