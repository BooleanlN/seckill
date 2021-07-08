package cn.whu.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_activity")
public class TActivity {
    /**
     * 活动ID
     */
    @Id
    @Column(name = "activity_id")
    private String activityId;

    /**
     * 活动名称
     */
    @Column(name = "activity_name")
    private String activityName;

    /**
     * 活动开始时间
     */
    @Column(name = "activity_begin_time")
    private Date activityBeginTime;

    /**
     * 活动结束时间
     */
    @Column(name = "activity_end_time")
    private Date activityEndTime;

    /**
     * 活动减免
     */
    @Column(name = "activity_reduction")
    private Long activityReduction;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取活动ID
     *
     * @return activity_id - 活动ID
     */
    public String getActivityId() {
        return activityId;
    }

    /**
     * 设置活动ID
     *
     * @param activityId 活动ID
     */
    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    /**
     * 获取活动名称
     *
     * @return activity_name - 活动名称
     */
    public String getActivityName() {
        return activityName;
    }

    /**
     * 设置活动名称
     *
     * @param activityName 活动名称
     */
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    /**
     * 获取活动开始时间
     *
     * @return activity_begin_time - 活动开始时间
     */
    public Date getActivityBeginTime() {
        return activityBeginTime;
    }

    /**
     * 设置活动开始时间
     *
     * @param activityBeginTime 活动开始时间
     */
    public void setActivityBeginTime(Date activityBeginTime) {
        this.activityBeginTime = activityBeginTime;
    }

    /**
     * 获取活动结束时间
     *
     * @return activity_end_time - 活动结束时间
     */
    public Date getActivityEndTime() {
        return activityEndTime;
    }

    /**
     * 设置活动结束时间
     *
     * @param activityEndTime 活动结束时间
     */
    public void setActivityEndTime(Date activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    /**
     * 获取活动减免
     *
     * @return activity_reduction - 活动减免
     */
    public Long getActivityReduction() {
        return activityReduction;
    }

    /**
     * 设置活动减免
     *
     * @param activityReduction 活动减免
     */
    public void setActivityReduction(Long activityReduction) {
        this.activityReduction = activityReduction;
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