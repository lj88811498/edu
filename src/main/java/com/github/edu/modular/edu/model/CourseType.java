package com.github.edu.modular.edu.model;

import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author Monkey
 * @since 2020-05-20
 */
@ApiModel
public class CourseType extends Model<CourseType> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "course_type_id", type = IdType.AUTO)
    private Integer courseTypeId;
    /**
     * 上级分类
     */
    @ApiModelProperty("上级分类ID")
    private Integer courseTypeParentId;
    /**
     * 分类名称
     */
    @ApiModelProperty("分类名称")
    private String courseTypeName;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date courseTypeCreateTime;
    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date courseTypeUpdateTime;
    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private Integer courseTypeCreateBy;
    /**
     * 修改人
     */
    @ApiModelProperty("修改人")
    private Integer courseTypeUpdateBy;
    /**
     * 是否删除：0否1是
     */
    @ApiModelProperty("是否删除：0否1是")
    private Integer courseTypeIsDelete;
    @TableField(exist = false)
    private List<CourseType> courseTypeList;


    public Integer getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(Integer courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public Integer getCourseTypeParentId() {
        return courseTypeParentId;
    }

    public void setCourseTypeParentId(Integer courseTypeParentId) {
        this.courseTypeParentId = courseTypeParentId;
    }

    public String getCourseTypeName() {
        return courseTypeName;
    }

    public void setCourseTypeName(String courseTypeName) {
        this.courseTypeName = courseTypeName;
    }

    public Date getCourseTypeCreateTime() {
        return courseTypeCreateTime;
    }

    public void setCourseTypeCreateTime(Date courseTypeCreateTime) {
        this.courseTypeCreateTime = courseTypeCreateTime;
    }

    public Date getCourseTypeUpdateTime() {
        return courseTypeUpdateTime;
    }

    public void setCourseTypeUpdateTime(Date courseTypeUpdateTime) {
        this.courseTypeUpdateTime = courseTypeUpdateTime;
    }

    public Integer getCourseTypeCreateBy() {
        return courseTypeCreateBy;
    }

    public void setCourseTypeCreateBy(Integer courseTypeCreateBy) {
        this.courseTypeCreateBy = courseTypeCreateBy;
    }

    public Integer getCourseTypeUpdateBy() {
        return courseTypeUpdateBy;
    }

    public void setCourseTypeUpdateBy(Integer courseTypeUpdateBy) {
        this.courseTypeUpdateBy = courseTypeUpdateBy;
    }

    public Integer getCourseTypeIsDelete() {
        return courseTypeIsDelete;
    }

    public void setCourseTypeIsDelete(Integer courseTypeIsDelete) {
        this.courseTypeIsDelete = courseTypeIsDelete;
    }

    @Override
    protected Serializable pkVal() {
        return this.courseTypeId;
    }

    public List<CourseType> getCourseTypeList() {
        return courseTypeList;
    }

    public void setCourseTypeList(List<CourseType> courseTypeList) {
        this.courseTypeList = courseTypeList;
    }

    @Override
    public String toString() {
        return "CourseType{" +
        "courseTypeId=" + courseTypeId +
        ", courseTypeParentId=" + courseTypeParentId +
        ", courseTypeName=" + courseTypeName +
        ", courseTypeCreateTime=" + courseTypeCreateTime +
        ", courseTypeUpdateTime=" + courseTypeUpdateTime +
        ", courseTypeCreateBy=" + courseTypeCreateBy +
        ", courseTypeUpdateBy=" + courseTypeUpdateBy +
        ", courseTypeIsDelete=" + courseTypeIsDelete +
        "}";
    }
}
