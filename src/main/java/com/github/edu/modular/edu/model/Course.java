package com.github.edu.modular.edu.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 课程管理
 * </p>
 *
 * @author Monkey
 * @since 2020-05-27
 */
@ApiModel
public class Course extends Model<Course> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 课程描述
     */
    private String courseDesc;
    /**
     * 课程分类id
     */
    private Integer courseTypeId;
    /**
     * 课程封面地址
     */
    private String courseCover;
    /**
     * 课程时长(分钟)
     */
    private Integer courseTime;
    /**
     * 课程学分
     */
    private Integer courseCredit;
    /**
     * 资源类型
     */
    private Integer courseType;
    /**
     * 课件资源地址
     */
    private String courseCourseware;
    /**
     * 创建时间
     */
    private Date courseCreateTime;
    /**
     * 修改时间
     */
    private Date courseUpdateTime;
    /**
     * 创建人
     */
    private Integer courseCreateBy;
    /**
     * 修改人
     */
    private Integer courseUpdateBy;
    /**
     * 是否删除：0否1是
     */
    private Integer courseIsDelete;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public Integer getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(Integer courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public String getCourseCover() {
        return courseCover;
    }

    public void setCourseCover(String courseCover) {
        this.courseCover = courseCover;
    }

    public Integer getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(Integer courseTime) {
        this.courseTime = courseTime;
    }

    public Integer getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(Integer courseCredit) {
        this.courseCredit = courseCredit;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public String getCourseCourseware() {
        return courseCourseware;
    }

    public void setCourseCourseware(String courseCourseware) {
        this.courseCourseware = courseCourseware;
    }

    public Date getCourseCreateTime() {
        return courseCreateTime;
    }

    public void setCourseCreateTime(Date courseCreateTime) {
        this.courseCreateTime = courseCreateTime;
    }

    public Date getCourseUpdateTime() {
        return courseUpdateTime;
    }

    public void setCourseUpdateTime(Date courseUpdateTime) {
        this.courseUpdateTime = courseUpdateTime;
    }

    public Integer getCourseCreateBy() {
        return courseCreateBy;
    }

    public void setCourseCreateBy(Integer courseCreateBy) {
        this.courseCreateBy = courseCreateBy;
    }

    public Integer getCourseUpdateBy() {
        return courseUpdateBy;
    }

    public void setCourseUpdateBy(Integer courseUpdateBy) {
        this.courseUpdateBy = courseUpdateBy;
    }

    public Integer getCourseIsDelete() {
        return courseIsDelete;
    }

    public void setCourseIsDelete(Integer courseIsDelete) {
        this.courseIsDelete = courseIsDelete;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Course{" +
        "id=" + id +
        ", courseName=" + courseName +
        ", courseDesc=" + courseDesc +
        ", courseTypeId=" + courseTypeId +
        ", courseCover=" + courseCover +
        ", courseTime=" + courseTime +
        ", courseCredit=" + courseCredit +
        ", courseType=" + courseType +
        ", courseCourseware=" + courseCourseware +
        ", courseCreateTime=" + courseCreateTime +
        ", courseUpdateTime=" + courseUpdateTime +
        ", courseCreateBy=" + courseCreateBy +
        ", courseUpdateBy=" + courseUpdateBy +
        ", courseIsDelete=" + courseIsDelete +
        "}";
    }
}
