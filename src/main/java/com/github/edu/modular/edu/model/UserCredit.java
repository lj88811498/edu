package com.github.edu.modular.edu.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 用户学分
 * </p>
 *
 * @author Monkey
 * @since 2020-05-18
 */
@ApiModel
public class UserCredit extends Model<UserCredit> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_credit_id", type = IdType.AUTO)
    private Integer userCreditId;
    /**
     * 卷子id
     */
    private Integer paperId;
    /**
     * 考试id
     */
    private Integer examId;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 通过学分
     */
    private String userCreditAccess;
    /**
     * 状态：0未考 1已考
     */
    private String userCreditStatus;
    /**
     * 创建时间
     */
    private Date userCreditCreateTime;
    /**
     * 修改时间
     */
    private Date userCreditUpdateTime;
    /**
     * 创建人
     */
    private Integer userCreditCreateBy;
    /**
     * 修改人
     */
    private Integer userCreditUpdateBy;
    /**
     * 是否删除：0否1是
     */
    private Integer userCreditIsDelete;


    public Integer getUserCreditId() {
        return userCreditId;
    }

    public void setUserCreditId(Integer userCreditId) {
        this.userCreditId = userCreditId;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserCreditAccess() {
        return userCreditAccess;
    }

    public void setUserCreditAccess(String userCreditAccess) {
        this.userCreditAccess = userCreditAccess;
    }

    public String getUserCreditStatus() {
        return userCreditStatus;
    }

    public void setUserCreditStatus(String userCreditStatus) {
        this.userCreditStatus = userCreditStatus;
    }

    public Date getUserCreditCreateTime() {
        return userCreditCreateTime;
    }

    public void setUserCreditCreateTime(Date userCreditCreateTime) {
        this.userCreditCreateTime = userCreditCreateTime;
    }

    public Date getUserCreditUpdateTime() {
        return userCreditUpdateTime;
    }

    public void setUserCreditUpdateTime(Date userCreditUpdateTime) {
        this.userCreditUpdateTime = userCreditUpdateTime;
    }

    public Integer getUserCreditCreateBy() {
        return userCreditCreateBy;
    }

    public void setUserCreditCreateBy(Integer userCreditCreateBy) {
        this.userCreditCreateBy = userCreditCreateBy;
    }

    public Integer getUserCreditUpdateBy() {
        return userCreditUpdateBy;
    }

    public void setUserCreditUpdateBy(Integer userCreditUpdateBy) {
        this.userCreditUpdateBy = userCreditUpdateBy;
    }

    public Integer getUserCreditIsDelete() {
        return userCreditIsDelete;
    }

    public void setUserCreditIsDelete(Integer userCreditIsDelete) {
        this.userCreditIsDelete = userCreditIsDelete;
    }

    @Override
    protected Serializable pkVal() {
        return this.userCreditId;
    }

    @Override
    public String toString() {
        return "UserCredit{" +
        "userCreditId=" + userCreditId +
        ", paperId=" + paperId +
        ", examId=" + examId +
        ", userId=" + userId +
        ", userCreditAccess=" + userCreditAccess +
        ", userCreditStatus=" + userCreditStatus +
        ", userCreditCreateTime=" + userCreditCreateTime +
        ", userCreditUpdateTime=" + userCreditUpdateTime +
        ", userCreditCreateBy=" + userCreditCreateBy +
        ", userCreditUpdateBy=" + userCreditUpdateBy +
        ", userCreditIsDelete=" + userCreditIsDelete +
        "}";
    }
}
