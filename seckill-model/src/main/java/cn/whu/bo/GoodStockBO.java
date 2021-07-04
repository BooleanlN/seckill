package cn.whu.bo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author snow
 * @className GoodStockBO
 * @date 2021/6/30
 **/
public class GoodStockBO implements Serializable {
    @NotBlank(message = "货物Id不能为空")
    private String goodId;

    @NotNull(message = "货物削减的数额")
    @Min(value = 0,message = "削减库存最小不能小于0")
    private Long stockCount;
//
//    @NotNull(message = "当前库存量")
//    @Min(value = 1,message = "当前库存最小不能小于1")
//    private Long currentStock;

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
}
