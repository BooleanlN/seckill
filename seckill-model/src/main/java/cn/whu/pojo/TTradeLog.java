package cn.whu.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_trade_log")
public class TTradeLog {
    /**
     * 交易流水ID
     */
    @Id
    @Column(name = "log_id")
    private String logId;

    /**
     * 事务ID
     */
    @Column(name = "transaction_id")
    private String transactionId;

    /**
     * 本次流水订单ID
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取交易流水ID
     *
     * @return log_id - 交易流水ID
     */
    public String getLogId() {
        return logId;
    }

    /**
     * 设置交易流水ID
     *
     * @param logId 交易流水ID
     */
    public void setLogId(String logId) {
        this.logId = logId;
    }

    /**
     * 获取事务ID
     *
     * @return transaction_id - 事务ID
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * 设置事务ID
     *
     * @param transactionId 事务ID
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * 获取本次流水订单ID
     *
     * @return order_id - 本次流水订单ID
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置本次流水订单ID
     *
     * @param orderId 本次流水订单ID
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}