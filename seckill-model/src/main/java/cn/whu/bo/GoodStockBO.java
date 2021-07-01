package cn.whu.bo;

import javax.validation.constraints.NotBlank;

/**
 * @author snow
 * @className GoodStockBO
 * @date 2021/6/30
 **/
public class GoodStockBO {
    @NotBlank(message = "货物Id不能为空")
    private String GoodId;

    @NotBlank(message = "货物削减的数额")
    private Long stockCount;

    public String getGoodId() {
        return GoodId;
    }

    public void setGoodId(String goodId) {
        GoodId = goodId;
    }

    public Long getStockCount() {
        return stockCount;
    }

    public void setStockCount(Long stockCount) {
        this.stockCount = stockCount;
    }
}
