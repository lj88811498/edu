package com.github.edu.modular.edu.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 学习计划--课程
 * </p>
 *
 * @author Monkey
 * @since 2020-05-21
 */
@ApiModel
public class StudyPlanCourse extends Model<StudyPlanCourse> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 课程id
     */
    private Integer studyPlanCourseId;
    /**
     * 学习计划id
     */
    private Integer studyPlanId;
    /**
     * 创建时间
     */
    private Date studyPlanCourseCreateTime;
    /**
     * 修改时间
     */
    private Date studyPlanCourseUpdateTime;
    /**
     * 创建人
     */
    private Integer studyPlanCourseCreateBy;
    /**
     * 修改人
     */
    private Integer studyPlanCourseUpdateBy;
    /**
     * 是否删除：0否1是
     */
    private Integer studyPlanCourseIsDelete;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudyPlanCourseId() {
        return studyPlanCourseId;
    }

    public void setStudyPlanCourseId(Integer studyPlanCourseId) {
        this.studyPlanCourseId = studyPlanCourseId;
    }

    public Integer getStudyPlanId() {
        return studyPlanId;
    }

    public void setStudyPlanId(Integer studyPlanId) {
        this.studyPlanId = studyPlanId;
    }

    public Date getStudyPlanCourseCreateTime() {
        return studyPlanCourseCreateTime;
    }

    public void setStudyPlanCourseCreateTime(Date studyPlanCourseCreateTime) {
        this.studyPlanCourseCreateTime = studyPlanCourseCreateTime;
    }

    public Date getStudyPlanCourseUpdateTime() {
        return studyPlanCourseUpdateTime;
    }

    public void setStudyPlanCourseUpdateTime(Date studyPlanCourseUpdateTime) {
        this.studyPlanCourseUpdateTime = studyPlanCourseUpdateTime;
    }

    public Integer getStudyPlanCourseCreateBy() {
        return studyPlanCourseCreateBy;
    }

    public void setStudyPlanCourseCreateBy(Integer studyPlanCourseCreateBy) {
        this.studyPlanCourseCreateBy = studyPlanCourseCreateBy;
    }

    public Integer getStudyPlanCourseUpdateBy() {
        return studyPlanCourseUpdateBy;
    }

    public void setStudyPlanCourseUpdateBy(Integer studyPlanCourseUpdateBy) {
        this.studyPlanCourseUpdateBy = studyPlanCourseUpdateBy;
    }

    public Integer getStudyPlanCourseIsDelete() {
        return studyPlanCourseIsDelete;
    }

    public void setStudyPlanCourseIsDelete(Integer studyPlanCourseIsDelete) {
        this.studyPlanCourseIsDelete = studyPlanCourseIsDelete;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "StudyPlanCourse{" +
        "id=" + id +
        ", studyPlanCourseId=" + studyPlanCourseId +
        ", studyPlanId=" + studyPlanId +
        ", studyPlanCourseCreateTime=" + studyPlanCourseCreateTime +
        ", studyPlanCourseUpdateTime=" + studyPlanCourseUpdateTime +
        ", studyPlanCourseCreateBy=" + studyPlanCourseCreateBy +
        ", studyPlanCourseUpdateBy=" + studyPlanCourseUpdateBy +
        ", studyPlanCourseIsDelete=" + studyPlanCourseIsDelete +
        "}";
    }
}
