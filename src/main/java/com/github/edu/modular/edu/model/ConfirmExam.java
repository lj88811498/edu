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
 * <li>文件描述: 确认考试</li>
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
@TableName("confirm_exam")
public class ConfirmExam extends Model<ConfirmExam> {

    private static final long serialVersionUID = 1L;

	@TableId("confirm_exam_id")
	private Integer confirmExamId;

	/**
	 * 卷子id
	 */
	@TableField("exam_id")
	private Integer examId;

	@TableField("confirm_exam_status")
	private String confirmExamStatus;

	@TableField("confirm_exam_version")
	private String confirmExamVersion;

    /**
     * 卷子id
     */
	@TableField("paper_id")
	private Integer paperId;
    /**
     * 练习库id
     */
	@TableField("practice_id")
	private Integer practiceId;
    /**
     * 用户id
     */
	@TableField("user_id")
	private Integer userId;
    /**
     * 创建时间
     */
	@TableField("confirm_exam_create_time")
	private Date confirmExamCreateTime;
    /**
     * 修改时间
     */
	@TableField("confirm_exam_update_time")
	private Date confirmExamUpdateTime;
    /**
     * 创建人
     */
	@TableField("confirm_exam_create_by")
	private Integer confirmExamCreateBy;
    /**
     * 修改人
     */
	@TableField("confirm_exam_update_by")
	private Integer confirmExamUpdateBy;
    /**
     * 是否删除：0否1是
     */
	@TableField("confirm_exam_is_delete")
	private Integer confirmExamIsDelete;

	@Override
	protected Serializable pkVal() {
		return this.confirmExamId;
	}

	public Integer getConfirmExamId() {
		return confirmExamId;
	}

	public void setConfirmExamId(Integer confirmExamId) {
		this.confirmExamId = confirmExamId;
	}

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	public String getConfirmExamStatus() {
		return confirmExamStatus;
	}

	public void setConfirmExamStatus(String confirmExamStatus) {
		this.confirmExamStatus = confirmExamStatus;
	}

	public Integer getPaperId() {
		return paperId;
	}

	public void setPaperId(Integer paperId) {
		this.paperId = paperId;
	}

	public Integer getPracticeId() {
		return practiceId;
	}

	public void setPracticeId(Integer practiceId) {
		this.practiceId = practiceId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getConfirmExamCreateTime() {
		return confirmExamCreateTime;
	}

	public void setConfirmExamCreateTime(Date confirmExamCreateTime) {
		this.confirmExamCreateTime = confirmExamCreateTime;
	}

	public Date getConfirmExamUpdateTime() {
		return confirmExamUpdateTime;
	}

	public void setConfirmExamUpdateTime(Date confirmExamUpdateTime) {
		this.confirmExamUpdateTime = confirmExamUpdateTime;
	}

	public Integer getConfirmExamCreateBy() {
		return confirmExamCreateBy;
	}

	public void setConfirmExamCreateBy(Integer confirmExamCreateBy) {
		this.confirmExamCreateBy = confirmExamCreateBy;
	}

	public Integer getConfirmExamUpdateBy() {
		return confirmExamUpdateBy;
	}

	public void setConfirmExamUpdateBy(Integer confirmExamUpdateBy) {
		this.confirmExamUpdateBy = confirmExamUpdateBy;
	}

	public Integer getConfirmExamIsDelete() {
		return confirmExamIsDelete;
	}

	public void setConfirmExamIsDelete(Integer confirmExamIsDelete) {
		this.confirmExamIsDelete = confirmExamIsDelete;
	}

	public String getConfirmExamVersion() {
		return confirmExamVersion;
	}

	public void setConfirmExamVersion(String confirmExamVersion) {
		this.confirmExamVersion = confirmExamVersion;
	}

	@Override
	public String toString() {
		return "ConfirmExam{" +
				"confirmExamId=" + confirmExamId +
				", examId=" + examId +
				", confirmExamStatus=" + confirmExamStatus +
				", paperId=" + paperId +
				", practiceId=" + practiceId +
				", userId=" + userId +
				", confirmExamVersion=" + confirmExamVersion +
				", confirmExamStatus=" + confirmExamStatus +
				", confirmExamCreateTime=" + confirmExamCreateTime +
				", confirmExamUpdateTime=" + confirmExamUpdateTime +
				", confirmExamCreateBy=" + confirmExamCreateBy +
				", confirmExamUpdateBy=" + confirmExamUpdateBy +
				", confirmExamIsDelete=" + confirmExamIsDelete +
				'}';
	}
}
