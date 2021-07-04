package cn.whu.bo;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author snow
 * @className StockBO
 * @date 2021/6/28
 **/
public class StockBO implements Serializable {
    @NotBlank(message = "商品Id不为空")
    private String goodId;
    @NotBlank(message = "削减数量不为空")
    private Integer count;

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
