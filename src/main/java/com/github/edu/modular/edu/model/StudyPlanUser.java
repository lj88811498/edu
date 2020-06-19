package com.github.edu.modular.edu.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 学习计划--用户
 * </p>
 *
 * @author Monkey
 * @since 2020-05-21
 */
@ApiModel
public class StudyPlanUser extends Model<StudyPlanUser> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户id
     */
    private Integer studyPlanUserId;
    /**
     * 学习计划id
     */
    private Integer studyPlanId;
    /**
     * 创建时间
     */
    private Date studyPlanUserCreateTime;
    /**
     * 修改时间
     */
    private Date studyPlanUserUpdateTime;
    /**
     * 创建人
     */
    private Integer studyPlanUserCreateBy;
    /**
     * 修改人
     */
    private Integer studyPlanUserUpdateBy;
    /**
     * 是否删除：0否1是
     */
    private Integer studyPlanUserIsDelete;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudyPlanUserId() {
        return studyPlanUserId;
    }

    public void setStudyPlanUserId(Integer studyPlanUserId) {
        this.studyPlanUserId = studyPlanUserId;
    }

    public Integer getStudyPlanId() {
        return studyPlanId;
    }

    public void setStudyPlanId(Integer studyPlanId) {
        this.studyPlanId = studyPlanId;
    }

    public Date getStudyPlanUserCreateTime() {
        return studyPlanUserCreateTime;
    }

    public void setStudyPlanUserCreateTime(Date studyPlanUserCreateTime) {
        this.studyPlanUserCreateTime = studyPlanUserCreateTime;
    }

    public Date getStudyPlanUserUpdateTime() {
        return studyPlanUserUpdateTime;
    }

    public void setStudyPlanUserUpdateTime(Date studyPlanUserUpdateTime) {
        this.studyPlanUserUpdateTime = studyPlanUserUpdateTime;
    }

    public Integer getStudyPlanUserCreateBy() {
        return studyPlanUserCreateBy;
    }

    public void setStudyPlanUserCreateBy(Integer studyPlanUserCreateBy) {
        this.studyPlanUserCreateBy = studyPlanUserCreateBy;
    }

    public Integer getStudyPlanUserUpdateBy() {
        return studyPlanUserUpdateBy;
    }

    public void setStudyPlanUserUpdateBy(Integer studyPlanUserUpdateBy) {
        this.studyPlanUserUpdateBy = studyPlanUserUpdateBy;
    }

    public Integer getStudyPlanUserIsDelete() {
        return studyPlanUserIsDelete;
    }

    public void setStudyPlanUserIsDelete(Integer studyPlanUserIsDelete) {
        this.studyPlanUserIsDelete = studyPlanUserIsDelete;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "StudyPlanUser{" +
        "id=" + id +
        ", studyPlanUserId=" + studyPlanUserId +
        ", studyPlanId=" + studyPlanId +
        ", studyPlanUserCreateTime=" + studyPlanUserCreateTime +
        ", studyPlanUserUpdateTime=" + studyPlanUserUpdateTime +
        ", studyPlanUserCreateBy=" + studyPlanUserCreateBy +
        ", studyPlanUserUpdateBy=" + studyPlanUserUpdateBy +
        ", studyPlanUserIsDelete=" + studyPlanUserIsDelete +
        "}";
    }
}
