package cn.whu.vo;

import javax.validation.constraints.NotBlank;

/**
 * @author snow
 * @className GoodStorageVO
 * @date 2021/6/30
 **/
public class GoodStorageVO {
    @NotBlank(message = "货物id")
    private String goodId;

    private Long stockCount;

    private Long stockConsumeCount;

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public Long getStockCount() {
        return stockCount;
    }

    public void setStockCount(Long stockCount) {
        this.stockCount = stockCount;
    }

    public Long getStockConsumeCount() {
        return stockConsumeCount;
    }

    public void setStockConsumeCount(Long stockConsumeCount) {
        this.stockConsumeCount = stockConsumeCount;
    }
}
