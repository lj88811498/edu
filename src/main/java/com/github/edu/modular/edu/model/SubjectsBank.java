package com.github.edu.modular.edu.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <li>文件名称: 题目名称</li>
 * <li>文件描述: 题库</li>
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
@TableName("subjects_bank")
public class SubjectsBank extends Model<SubjectsBank> {

    private static final long serialVersionUID = 1L;

	@ApiParam("主键id，新增时为空，修改删除时必填")
	@TableId("subjects_bank_id")
	private Integer subjectsBankId;
    /**
     * 题库分类id
     */
	@TableField("subjects_bank_type_id")
	private Integer subjectsBankTypeId;

	/**
	 * 题库分类id
	 */
	@TableField(exist = false)
	private String subjectsBankTypeName;
    /**
     * 题库名称
     */
	@TableField("subjects_bank_name")
	private String subjectsBankName;
    /**
     * 创建时间
     */
	@TableField("subjects_bank_create_time")
	private Date subjectsBankCreateTime;
    /**
     * 修改时间
     */
	@TableField("subjects_bank_update_time")
	private Date subjectsBankUpdateTime;
    /**
     * 创建人
     */
	@TableField("subjects_bank_create_by")
	private Integer subjectsBankCreateBy;

	/**
	 * 创建人
	 */
	@TableField(exist = false)
	private String subjectsBankCreateByName;
    /**
     * 修改人
     */
	@TableField("subjects_bank_update_by")
	private Integer subjectsBankUpdateBy;
    /**
     * 是否删除：0否1是
     */
	@TableField("subjects_bank_is_delete")
	private Integer subjectsBankIsDelete;

	@Override
	protected Serializable pkVal() {
		return this.subjectsBankId;
	}

	public Integer getSubjectsBankId() {
		return subjectsBankId;
	}

	public void setSubjectsBankId(Integer subjectsBankId) {
		this.subjectsBankId = subjectsBankId;
	}

	public Integer getSubjectsBankTypeId() {
		return subjectsBankTypeId;
	}

	public void setSubjectsBankTypeId(Integer subjectsBankTypeId) {
		this.subjectsBankTypeId = subjectsBankTypeId;
	}

	public String getSubjectsBankName() {
		return subjectsBankName;
	}

	public void setSubjectsBankName(String subjectsBankName) {
		this.subjectsBankName = subjectsBankName;
	}

	public Date getSubjectsBankCreateTime() {
		return subjectsBankCreateTime;
	}

	public void setSubjectsBankCreateTime(Date subjectsBankCreateTime) {
		this.subjectsBankCreateTime = subjectsBankCreateTime;
	}

	public Date getSubjectsBankUpdateTime() {
		return subjectsBankUpdateTime;
	}

	public void setSubjectsBankUpdateTime(Date subjectsBankUpdateTime) {
		this.subjectsBankUpdateTime = subjectsBankUpdateTime;
	}

	public Integer getSubjectsBankCreateBy() {
		return subjectsBankCreateBy;
	}

	public void setSubjectsBankCreateBy(Integer subjectsBankCreateBy) {
		this.subjectsBankCreateBy = subjectsBankCreateBy;
	}

	public Integer getSubjectsBankUpdateBy() {
		return subjectsBankUpdateBy;
	}

	public void setSubjectsBankUpdateBy(Integer subjectsBankUpdateBy) {
		this.subjectsBankUpdateBy = subjectsBankUpdateBy;
	}

	public Integer getSubjectsBankIsDelete() {
		return subjectsBankIsDelete;
	}

	public void setSubjectsBankIsDelete(Integer subjectsBankIsDelete) {
		this.subjectsBankIsDelete = subjectsBankIsDelete;
	}

	public String getSubjectsBankCreateByName() {
		return subjectsBankCreateByName;
	}

	public void setSubjectsBankCreateByName(String subjectsBankCreateByName) {
		this.subjectsBankCreateByName = subjectsBankCreateByName;
	}

	public String getSubjectsBankTypeName() {
		return subjectsBankTypeName;
	}

	public void setSubjectsBankTypeName(String subjectsBankTypeName) {
		this.subjectsBankTypeName = subjectsBankTypeName;
	}

	@Override
	public String toString() {
		return "SubjectsBank{" +
				"subjectsBankId=" + subjectsBankId +
				", subjectsBankTypeId=" + subjectsBankTypeId +
				", subjectsBankTypeName=" + subjectsBankTypeName +
				", subjectsBankName= " + subjectsBankName +
				", subjectsBankCreateTime=" + subjectsBankCreateTime +
				", subjectsBankUpdateTime=" + subjectsBankUpdateTime +
				", subjectsBankCreateBy=" + subjectsBankCreateBy +
				", subjectsBankCreateByName=" + subjectsBankCreateByName +
				", subjectsBankUpdateBy=" + subjectsBankUpdateBy +
				", subjectsBankIsDelete=" + subjectsBankIsDelete +
				'}';
	}
}
