package cn.whu.pojo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_good")
public class TGood {
    /**
     * 货物ID
     */
    @Id
    @Column(name = "good_id")
    private String goodId;

    /**
     * 货物名称，<48
     */
    @Column(name = "good_name")
    private String goodName;

    /**
     * 货物金额
     */
    @Column(name = "good_price")
    private BigDecimal goodPrice;

    /**
     * 货物简要描述
     */
    @Column(name = "good_desc")
    private String goodDesc;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

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
     * 获取货物名称，<48
     *
     * @return good_name - 货物名称，<48
     */
    public String getGoodName() {
        return goodName;
    }

    /**
     * 设置货物名称，<48
     *
     * @param goodName 货物名称，<48
     */
    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    /**
     * 获取货物金额
     *
     * @return good_price - 货物金额
     */
    public BigDecimal getGoodPrice() {
        return goodPrice;
    }

    /**
     * 设置货物金额
     *
     * @param goodPrice 货物金额
     */
    public void setGoodPrice(BigDecimal goodPrice) {
        this.goodPrice = goodPrice;
    }

    /**
     * 获取货物简要描述
     *
     * @return good_desc - 货物简要描述
     */
    public String getGoodDesc() {
        return goodDesc;
    }

    /**
     * 设置货物简要描述
     *
     * @param goodDesc 货物简要描述
     */
    public void setGoodDesc(String goodDesc) {
        this.goodDesc = goodDesc;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
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