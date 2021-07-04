package cn.whu.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "t_balance")
public class TBalance {
    /**
     * 余额记录ID
     */
    @Id
    @Column(name = "balance_id")
    private String balanceId;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户当前余额，使用decimal进行存储，避免丢失精度
9,2表示总共9位，保留2位小数（-9999999.99到9999999.99）
     */
    @Column(name = "current_balance")
    private BigDecimal currentBalance;

    /**
     * 记录用户消费了多少金额
     */
    @Column(name = "consume_balance")
    private BigDecimal consumeBalance;

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
     * 获取余额记录ID
     *
     * @return balance_id - 余额记录ID
     */
    public String getBalanceId() {
        return balanceId;
    }

    /**
     * 设置余额记录ID
     *
     * @param balanceId 余额记录ID
     */
    public void setBalanceId(String balanceId) {
        this.balanceId = balanceId;
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
     * 获取用户当前余额，使用decimal进行存储，避免丢失精度
9,2表示总共9位，保留2位小数（-9999999.99到9999999.99）
     *
     * @return current_balance - 用户当前余额，使用decimal进行存储，避免丢失精度
9,2表示总共9位，保留2位小数（-9999999.99到9999999.99）
     */
    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    /**
     * 设置用户当前余额，使用decimal进行存储，避免丢失精度
9,2表示总共9位，保留2位小数（-9999999.99到9999999.99）
     *
     * @param currentBalance 用户当前余额，使用decimal进行存储，避免丢失精度
9,2表示总共9位，保留2位小数（-9999999.99到9999999.99）
     */
    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    /**
     * 获取记录用户消费了多少金额
     *
     * @return consume_balance - 记录用户消费了多少金额
     */
    public BigDecimal getConsumeBalance() {
        return consumeBalance;
    }

    /**
     * 设置记录用户消费了多少金额
     *
     * @param consumeBalance 记录用户消费了多少金额
     */
    public void setConsumeBalance(BigDecimal consumeBalance) {
        this.consumeBalance = consumeBalance;
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