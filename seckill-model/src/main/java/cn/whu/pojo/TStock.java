package cn.whu.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_stock")
public class TStock {
    /**
     * 库存ID
     */
    @Id
    @Column(name = "stock_id")
    private String stockId;

    /**
     * 货物ID
     */
    @Column(name = "good_id")
    private String goodId;

    /**
     * 库存数量
     */
    @Column(name = "stock_count")
    private Long stockCount;

    /**
     * 已消费库存数量
     */
    @Column(name = "stock_consume_count")
    private Long stockConsumeCount;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取库存ID
     *
     * @return stock_id - 库存ID
     */
    public String getStockId() {
        return stockId;
    }

    /**
     * 设置库存ID
     *
     * @param stockId 库存ID
     */
    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    /**
     * 获取货物ID
     *
     * @return good_id - 货物ID
     */
    public String getGoodId() {
        return goodId;
    }

    /**
     * 设置货物ID
     *
     * @param goodId 货物ID
     */
    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    /**
     * 获取库存数量
     *
     * @return stock_count - 库存数量
     */
    public Long getStockCount() {
        return stockCount;
    }

    /**
     * 设置库存数量
     *
     * @param stockCount 库存数量
     */
    public void setStockCount(Long stockCount) {
        this.stockCount = stockCount;
    }

    /**
     * 获取已消费库存数量
     *
     * @return stock_consume_count - 已消费库存数量
     */
    public Long getStockConsumeCount() {
        return stockConsumeCount;
    }

    /**
     * 设置已消费库存数量
     *
     * @param stockConsumeCount 已消费库存数量
     */
    public void setStockConsumeCount(Long stockConsumeCount) {
        this.stockConsumeCount = stockConsumeCount;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}