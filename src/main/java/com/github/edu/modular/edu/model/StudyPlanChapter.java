package com.github.edu.modular.edu.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 学习计划章节
 * </p>
 *
 * @author Monkey
 * @since 2020-05-23
 */
@ApiModel
public class StudyPlanChapter extends Model<StudyPlanChapter> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String studyPlanChapterName;
    /**
     * 学习计划id
     */
    private Integer studyPlanId;
    /**
     * 创建时间
     */
    private Date studyPlanChapterCreateTime;
    /**
     * 修改时间
     */
    private Date studyPlanChapterUpdateTime;
    /**
     * 创建人
     */
    private Integer studyPlanChapterCreateBy;
    /**
     * 修改人
     */
    private Integer studyPlanChapterUpdateBy;
    /**
     * 是否删除：0否1是
     */
    private Integer studyPlanChapterIsDelete;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudyPlanChapterName() {
        return studyPlanChapterName;
    }

    public void setStudyPlanChapterName(String studyPlanChapterName) {
        this.studyPlanChapterName = studyPlanChapterName;
    }

    public Integer getStudyPlanId() {
        return studyPlanId;
    }

    public void setStudyPlanId(Integer studyPlanId) {
        this.studyPlanId = studyPlanId;
    }

    public Date getStudyPlanChapterCreateTime() {
        return studyPlanChapterCreateTime;
    }

    public void setStudyPlanChapterCreateTime(Date studyPlanChapterCreateTime) {
        this.studyPlanChapterCreateTime = studyPlanChapterCreateTime;
    }

    public Date getStudyPlanChapterUpdateTime() {
        return studyPlanChapterUpdateTime;
    }

    public void setStudyPlanChapterUpdateTime(Date studyPlanChapterUpdateTime) {
        this.studyPlanChapterUpdateTime = studyPlanChapterUpdateTime;
    }

    public Integer getStudyPlanChapterCreateBy() {
        return studyPlanChapterCreateBy;
    }

    public void setStudyPlanChapterCreateBy(Integer studyPlanChapterCreateBy) {
        this.studyPlanChapterCreateBy = studyPlanChapterCreateBy;
    }

    public Integer getStudyPlanChapterUpdateBy() {
        return studyPlanChapterUpdateBy;
    }

    public void setStudyPlanChapterUpdateBy(Integer studyPlanChapterUpdateBy) {
        this.studyPlanChapterUpdateBy = studyPlanChapterUpdateBy;
    }

    public Integer getStudyPlanChapterIsDelete() {
        return studyPlanChapterIsDelete;
    }

    public void setStudyPlanChapterIsDelete(Integer studyPlanChapterIsDelete) {
        this.studyPlanChapterIsDelete = studyPlanChapterIsDelete;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "StudyPlanChapter{" +
        "id=" + id +
        ", studyPlanChapterName=" + studyPlanChapterName +
        ", studyPlanId=" + studyPlanId +
        ", studyPlanChapterCreateTime=" + studyPlanChapterCreateTime +
        ", studyPlanChapterUpdateTime=" + studyPlanChapterUpdateTime +
        ", studyPlanChapterCreateBy=" + studyPlanChapterCreateBy +
        ", studyPlanChapterUpdateBy=" + studyPlanChapterUpdateBy +
        ", studyPlanChapterIsDelete=" + studyPlanChapterIsDelete +
        "}";
    }
}
