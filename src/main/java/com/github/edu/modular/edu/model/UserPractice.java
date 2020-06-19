package com.github.edu.modular.edu.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Monkey
 * @since 2020-05-16
 */
@ApiModel
public class UserPractice extends Model<UserPractice> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_practice_id", type = IdType.AUTO)
    private Integer userPracticeId;
    /**
     * 练习id
     */
    private Integer practiceId;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 创建人
     */
    private Integer userPracticeCreateBy;
    /**
     * 创建时间
     */
    private Date userPracticeCreateTime;


    public Integer getUserPracticeId() {
        return userPracticeId;
    }

    public void setUserPracticeId(Integer userPracticeId) {
        this.userPracticeId = userPracticeId;
    }

    public Integer getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(Integer practiceId) {
        this.practiceId = practiceId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserPracticeCreateBy() {
        return userPracticeCreateBy;
    }

    public void setUserPracticeCreateBy(Integer userPracticeCreateBy) {
        this.userPracticeCreateBy = userPracticeCreateBy;
    }

    public Date getUserPracticeCreateTime() {
        return userPracticeCreateTime;
    }

    public void setUserPracticeCreateTime(Date userPracticeCreateTime) {
        this.userPracticeCreateTime = userPracticeCreateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.userPracticeId;
    }

    @Override
    public String toString() {
        return "UserPractice{" +
        "userPracticeId=" + userPracticeId +
        ", practiceId=" + practiceId +
        ", userId=" + userId +
        ", userPracticeCreateBy=" + userPracticeCreateBy +
        ", userPracticeCreateTime=" + userPracticeCreateTime +
        "}";
    }
}
