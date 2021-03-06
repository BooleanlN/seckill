package cn.whu.bo;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author snow
 * @className GoodBO
 * @date 2021/6/28
 **/
public class GoodBO implements Serializable {

    private String goodId;

    @NotBlank(message = "商品名不能为空")
    private String goodName;

    @NotNull(message = "商品金额不能为空")
    @DecimalMin("0.0")
    private BigDecimal goodPrice;

    private String goodDesc;

    @NotNull(message = "商品库存不能为空")
    @Min(0)
    private Long goodStock;

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

    public BigDecimal getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(BigDecimal amount) {
        this.goodPrice = amount;
    }

    public String getGoodDesc() {
        return goodDesc;
    }

    public void setGoodDesc(String goodDesc) {
        this.goodDesc = goodDesc;
    }

    public Long getGoodStock() {
        return goodStock;
    }

    public void setGoodStock(Long goodStock) {
        this.goodStock = goodStock;
    }
}
