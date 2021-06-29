package cn.whu.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "t_trade")
public class TTrade {
    /**
     * 订单号
     */
    @Id
    @Column(name = "trade_id")
    private String tradeId;

    /**
     * 订单所属用户
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 涉及活动ID
     */
    @Column(name = "activity_id")
    private String activityId;

    /**
     * 货物ID
     */
    @Column(name = "good_id")
    private String goodId;

    /**
     * 商品数量
     */
    @Column(name = "good_count")
    private Integer goodCount;

    /**
     * 涉及金额
     */
    private BigDecimal money;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最近一次修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取订单号
     *
     * @return trade_id - 订单号
     */
    public String getTradeId() {
        return tradeId;
    }

    /**
     * 设置订单号
     *
     * @param tradeId 订单号
     */
    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    /**
     * 获取订单所属用户
     *
     * @return user_id - 订单所属用户
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置订单所属用户
     *
     * @param userId 订单所属用户
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取涉及活动ID
     *
     * @return activity_id - 涉及活动ID
     */
    public String getActivityId() {
        return activityId;
    }

    /**
     * 设置涉及活动ID
     *
     * @param activityId 涉及活动ID
     */
    public void setActivityId(String activityId) {
        this.activityId = activityId;
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
     * 获取商品数量
     *
     * @return good_count - 商品数量
     */
    public Integer getGoodCount() {
        return goodCount;
    }

    /**
     * 设置商品数量
     *
     * @param goodCount 商品数量
     */
    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }

    /**
     * 获取涉及金额
     *
     * @return money - 涉及金额
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * 设置涉及金额
     *
     * @param money 涉及金额
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
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
     * 获取最近一次修改时间
     *
     * @return update_time - 最近一次修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置最近一次修改时间
     *
     * @param updateTime 最近一次修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}