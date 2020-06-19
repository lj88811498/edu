package com.github.edu.modular.edu.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <li>文件名称: 题目名称</li>
 * <li>文件描述: 卷子题目</li>
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
@TableName("paper_subjects")
public class PaperSubjects extends Model<PaperSubjects> {

    private static final long serialVersionUID = 1L;

	@TableId("paper_subjects_id")
	private Integer paperSubjectsId;
    /**
     * 卷子id
     */
	@TableField("paper_id")
	private Integer paperId;
    /**
     * 题目id
     */
	@TableField("subjects_id")
	private Integer subjectsId;

	@TableField("subjects_name")
	private String subjectsName;
    /**
     * 题型:1单选2多选3判断4填空5问答
     */
	@TableField("subjects_type")
	private String subjectsType;
    /**
     * 随机排序
     */
	@TableField("paper_subjects_order")
	private String paperSubjectsOrder;
    /**
     * 创建时间
     */
	@TableField("paper_subjects_create_time")
	private Date paperSubjectsCreateTime;
    /**
     * 修改时间
     */
	@TableField("paper_subjects_update_time")
	private Date paperSubjectsUpdateTime;
    /**
     * 创建人
     */
	@TableField("paper_subjects_create_by")
	private Integer paperSubjectsCreateBy;
    /**
     * 修改人
     */
	@TableField("paper_subjects_update_by")
	private Integer paperSubjectsUpdateBy;
    /**
     * 是否删除：0否1是
     */
	@TableField("paper_subjects_is_delete")
	private Integer paperSubjectsIsDelete;

	@TableField("paper_subjects_grade")
	private String paperSubjectsGrade;

	@TableField("paper_subjects_version")
	private String paperSubjectsVersion;

	@Override
	protected Serializable pkVal() {
		return this.paperSubjectsId;
	}

	public Integer getPaperSubjectsId() {
		return paperSubjectsId;
	}

	public void setPaperSubjectsId(Integer paperSubjectsId) {
		this.paperSubjectsId = paperSubjectsId;
	}

	public Integer getPaperId() {
		return paperId;
	}

	public void setPaperId(Integer paperId) {
		this.paperId = paperId;
	}

	public Integer getSubjectsId() {
		return subjectsId;
	}

	public void setSubjectsId(Integer subjectsId) {
		this.subjectsId = subjectsId;
	}

	public String getSubjectsType() {
		return subjectsType;
	}

	public void setSubjectsType(String subjectsType) {
		this.subjectsType = subjectsType;
	}

	public String getPaperSubjectsOrder() {
		return paperSubjectsOrder;
	}

	public void setPaperSubjectsOrder(String paperSubjectsOrder) {
		this.paperSubjectsOrder = paperSubjectsOrder;
	}

	public Date getPaperSubjectsCreateTime() {
		return paperSubjectsCreateTime;
	}

	public void setPaperSubjectsCreateTime(Date paperSubjectsCreateTime) {
		this.paperSubjectsCreateTime = paperSubjectsCreateTime;
	}

	public Date getPaperSubjectsUpdateTime() {
		return paperSubjectsUpdateTime;
	}

	public void setPaperSubjectsUpdateTime(Date paperSubjectsUpdateTime) {
		this.paperSubjectsUpdateTime = paperSubjectsUpdateTime;
	}

	public Integer getPaperSubjectsCreateBy() {
		return paperSubjectsCreateBy;
	}

	public void setPaperSubjectsCreateBy(Integer paperSubjectsCreateBy) {
		this.paperSubjectsCreateBy = paperSubjectsCreateBy;
	}

	public Integer getPaperSubjectsUpdateBy() {
		return paperSubjectsUpdateBy;
	}

	public void setPaperSubjectsUpdateBy(Integer paperSubjectsUpdateBy) {
		this.paperSubjectsUpdateBy = paperSubjectsUpdateBy;
	}

	public Integer getPaperSubjectsIsDelete() {
		return paperSubjectsIsDelete;
	}

	public void setPaperSubjectsIsDelete(Integer paperSubjectsIsDelete) {
		this.paperSubjectsIsDelete = paperSubjectsIsDelete;
	}

	public String getPaperSubjectsGrade() {
		return paperSubjectsGrade;
	}

	public void setPaperSubjectsGrade(String paperSubjectsGrade) {
		this.paperSubjectsGrade = paperSubjectsGrade;
	}

	public String getPaperSubjectsVersion() {
		return paperSubjectsVersion;
	}

	public void setPaperSubjectsVersion(String paperSubjectsVersion) {
		this.paperSubjectsVersion = paperSubjectsVersion;
	}

	public String getSubjectsName() {
		return subjectsName;
	}

	public void setSubjectsName(String subjectsName) {
		this.subjectsName = subjectsName;
	}

	@Override
	public String toString() {
		return "PaperSubjects{" +
				"paperSubjectsId=" + paperSubjectsId +
				", paperId=" + paperId +
				", subjectsId=" + subjectsId +
				", subjectsName=" + subjectsName +
				", subjectsType" + subjectsType +
				", paperSubjectsOrder=" + paperSubjectsOrder +
				", paperSubjectsCreateTime=" + paperSubjectsCreateTime +
				", paperSubjectsUpdateTime=" + paperSubjectsUpdateTime +
				", paperSubjectsCreateBy=" + paperSubjectsCreateBy +
				", paperSubjectsUpdateBy=" + paperSubjectsUpdateBy +
				", paperSubjectsIsDelete=" + paperSubjectsIsDelete +
				", paperSubjectsGrade=" + paperSubjectsGrade +
				", paperSubjectsVersion=" + paperSubjectsVersion +
				'}';
	}
}
