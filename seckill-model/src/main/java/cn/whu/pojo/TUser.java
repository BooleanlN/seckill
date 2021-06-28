package cn.whu.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_user")
public class TUser {
    /**
     * 用户唯一ID
     */
    @Id
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户昵称
     */
    private String nikename;

    /**
     * 用户性别
     */
    private Integer sex;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户状态，1代表激活，2代表注销
     */
    @Column(name = "active_status")
    private Integer activeStatus;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取用户唯一ID
     *
     * @return user_id - 用户唯一ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户唯一ID
     *
     * @param userId 用户唯一ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取用户昵称
     *
     * @return nikename - 用户昵称
     */
    public String getNikename() {
        return nikename;
    }

    /**
     * 设置用户昵称
     *
     * @param nikename 用户昵称
     */
    public void setNikename(String nikename) {
        this.nikename = nikename;
    }

    /**
     * 获取用户性别
     *
     * @return sex - 用户性别
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置用户性别
     *
     * @param sex 用户性别
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取用户邮箱
     *
     * @return email - 用户邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置用户邮箱
     *
     * @param email 用户邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取用户状态，1代表激活，2代表注销
     *
     * @return active_status - 用户状态，1代表激活，2代表注销
     */
    public Integer getActiveStatus() {
        return activeStatus;
    }

    /**
     * 设置用户状态，1代表激活，2代表注销
     *
     * @param activeStatus 用户状态，1代表激活，2代表注销
     */
    public void setActiveStatus(Integer activeStatus) {
        this.activeStatus = activeStatus;
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
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}