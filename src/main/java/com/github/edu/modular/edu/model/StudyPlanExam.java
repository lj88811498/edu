package com.github.edu.modular.edu.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 学习计划--考试
 * </p>
 *
 * @author Monkey
 * @since 2020-05-21
 */
@ApiModel
public class StudyPlanExam extends Model<StudyPlanExam> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 考试id
     */
    private Integer studyPlanExamId;
    /**
     * 学习计划id
     */
    private Integer studyPlanId;
    /**
     * 创建时间
     */
    private Date studyPlanExamCreateTime;
    /**
     * 修改时间
     */
    private Date studyPlanExamUpdateTime;
    /**
     * 创建人
     */
    private Integer studyPlanExamCreateBy;
    /**
     * 修改人
     */
    private Integer studyPlanExamUpdateBy;
    /**
     * 是否删除：0否1是
     */
    private Integer studyPlanExamIsDelete;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudyPlanExamId() {
        return studyPlanExamId;
    }

    public void setStudyPlanExamId(Integer studyPlanExamId) {
        this.studyPlanExamId = studyPlanExamId;
    }

    public Integer getStudyPlanId() {
        return studyPlanId;
    }

    public void setStudyPlanId(Integer studyPlanId) {
        this.studyPlanId = studyPlanId;
    }

    public Date getStudyPlanExamCreateTime() {
        return studyPlanExamCreateTime;
    }

    public void setStudyPlanExamCreateTime(Date studyPlanExamCreateTime) {
        this.studyPlanExamCreateTime = studyPlanExamCreateTime;
    }

    public Date getStudyPlanExamUpdateTime() {
        return studyPlanExamUpdateTime;
    }

    public void setStudyPlanExamUpdateTime(Date studyPlanExamUpdateTime) {
        this.studyPlanExamUpdateTime = studyPlanExamUpdateTime;
    }

    public Integer getStudyPlanExamCreateBy() {
        return studyPlanExamCreateBy;
    }

    public void setStudyPlanExamCreateBy(Integer studyPlanExamCreateBy) {
        this.studyPlanExamCreateBy = studyPlanExamCreateBy;
    }

    public Integer getStudyPlanExamUpdateBy() {
        return studyPlanExamUpdateBy;
    }

    public void setStudyPlanExamUpdateBy(Integer studyPlanExamUpdateBy) {
        this.studyPlanExamUpdateBy = studyPlanExamUpdateBy;
    }

    public Integer getStudyPlanExamIsDelete() {
        return studyPlanExamIsDelete;
    }

    public void setStudyPlanExamIsDelete(Integer studyPlanExamIsDelete) {
        this.studyPlanExamIsDelete = studyPlanExamIsDelete;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "StudyPlanExam{" +
        "id=" + id +
        ", studyPlanExamId=" + studyPlanExamId +
        ", studyPlanId=" + studyPlanId +
        ", studyPlanExamCreateTime=" + studyPlanExamCreateTime +
        ", studyPlanExamUpdateTime=" + studyPlanExamUpdateTime +
        ", studyPlanExamCreateBy=" + studyPlanExamCreateBy +
        ", studyPlanExamUpdateBy=" + studyPlanExamUpdateBy +
        ", studyPlanExamIsDelete=" + studyPlanExamIsDelete +
        "}";
    }
}
