package com.github.edu.modular.edu.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <li>文件名称: 题目名称</li>
 * <li>文件描述: 题库分类</li>
 * <li>版权所有: 版权所有© 2005-2017</li>
 * <li>公 司: 贝奇达</li>
 * <li>内容摘要: 无</li>
 * <li>其他说明:无</li>
 * <li>完成日期： 2020-05-10</li>
 * <li>修改记录: 无</li>
 * @version 产品版本
 * @author monkey
 */
@Data
@TableName("subjects_bank_type")
public class SubjectsBankType extends Model<SubjectsBankType> {

    private static final long serialVersionUID = 1L;

    @ApiParam("主键id，新增时为空，修改删除时必填")
	@TableId("subjects_bank_type_id")
	private Integer subjectsBankTypeId;
    /**
     * 题库分类名称
     */
	@TableField("subjects_bank_type_name")
	private String subjectsBankTypeName;
    /**
     * 题库分类树节点编号
     */
	@TableField("subjects_bank_type_parent_id")
	private Integer subjectsBankTypeParentId;
    /**
     * 创建时间
     */
	@TableField("subjects_bank_type_create_time")
	private Date subjectsBankTypeCreateTime;
    /**
     * 修改时间
     */
	@TableField("subjects_bank_type_update_time")
	private Date subjectsBankTypeUpdateTime;
    /**
     * 创建人
     */
	@TableField("subjects_bank_type_create_by")
	private Integer subjectsBankTypeCreateBy;
    /**
     * 修改人
     */
	@TableField("subjects_bank_type_update_by")
	private Integer subjectsBankTypeUpdateBy;
    /**
     * 是否删除：0否1是
     */
	@TableField("subjects_bank_type_is_delete")
	private Integer subjectsBankTypeIsDelete;

    @TableField(exist = false)
	private List<SubjectsBankType> subjectsBankTypes;

	@Override
	protected Serializable pkVal() {
		return this.subjectsBankTypeId;
	}

	public Integer getSubjectsBankTypeId() {
		return subjectsBankTypeId;
	}

	public void setSubjectsBankTypeId(Integer subjectsBankTypeId) {
		this.subjectsBankTypeId = subjectsBankTypeId;
	}

	public String getSubjectsBankTypeName() {
		return subjectsBankTypeName;
	}

	public void setSubjectsBankTypeName(String subjectsBankTypeName) {
		this.subjectsBankTypeName = subjectsBankTypeName;
	}

	public Integer getSubjectsBankTypeParentId() {
		return subjectsBankTypeParentId;
	}

	public void setSubjectsBankTypeParentId(Integer subjectsBankTypeParentId) {
		this.subjectsBankTypeParentId = subjectsBankTypeParentId;
	}

	public Date getSubjectsBankTypeCreateTime() {
		return subjectsBankTypeCreateTime;
	}

	public void setSubjectsBankTypeCreateTime(Date subjectsBankTypeCreateTime) {
		this.subjectsBankTypeCreateTime = subjectsBankTypeCreateTime;
	}

	public Date getSubjectsBankTypeUpdateTime() {
		return subjectsBankTypeUpdateTime;
	}

	public void setSubjectsBankTypeUpdateTime(Date subjectsBankTypeUpdateTime) {
		this.subjectsBankTypeUpdateTime = subjectsBankTypeUpdateTime;
	}

	public Integer getSubjectsBankTypeCreateBy() {
		return subjectsBankTypeCreateBy;
	}

	public void setSubjectsBankTypeCreateBy(Integer subjectsBankTypeCreateBy) {
		this.subjectsBankTypeCreateBy = subjectsBankTypeCreateBy;
	}

	public Integer getSubjectsBankTypeUpdateBy() {
		return subjectsBankTypeUpdateBy;
	}

	public void setSubjectsBankTypeUpdateBy(Integer subjectsBankTypeUpdateBy) {
		this.subjectsBankTypeUpdateBy = subjectsBankTypeUpdateBy;
	}

	public Integer getSubjectsBankTypeIsDelete() {
		return subjectsBankTypeIsDelete;
	}

	public void setSubjectsBankTypeIsDelete(Integer subjectsBankTypeIsDelete) {
		this.subjectsBankTypeIsDelete = subjectsBankTypeIsDelete;
	}

	public List<SubjectsBankType> getSubjectsBankTypes() {
		return subjectsBankTypes;
	}

	public void setSubjectsBankTypes(List<SubjectsBankType> subjectsBankTypes) {
		this.subjectsBankTypes = subjectsBankTypes;
	}

	@Override
	public String toString() {
		return "SubjectsBankType{" +
				"subjectsBankTypeId=" + subjectsBankTypeId +
				", subjectsBankTypeName='" + subjectsBankTypeName + '\'' +
				", subjectsBankTypeParentId=" + subjectsBankTypeParentId +
				", subjectsBankTypeCreateTime=" + subjectsBankTypeCreateTime +
				", subjectsBankTypeUpdateTime=" + subjectsBankTypeUpdateTime +
				", subjectsBankTypeCreateBy=" + subjectsBankTypeCreateBy +
				", subjectsBankTypeUpdateBy=" + subjectsBankTypeUpdateBy +
				", subjectsBankTypeIsDelete=" + subjectsBankTypeIsDelete +
				", subjectsBankTypes=" + subjectsBankTypes +
				'}';
	}
}
