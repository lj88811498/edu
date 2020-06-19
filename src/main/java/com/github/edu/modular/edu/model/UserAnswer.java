package com.github.edu.modular.edu.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;

/**
 * <li>文件名称: 题目名称</li>
 * <li>文件描述: 用户答案</li>
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
@TableName("user_answer")
public class UserAnswer extends Model<UserAnswer> {

    private static final long serialVersionUID = 1L;

	@TableId("user_answer_id")
	private Integer userAnswerId;
    /**
     * 练习库id
     */
	@TableField("practice_id")
	private Integer practiceId;
    /**
     * 考试id
     */
	@TableField("exam_id")
	private Integer examId;
    /**
     * 题目id
     */
	@TableField("subjects_id")
	private Integer subjectsId;
    /**
     * 用户id
     */
	@TableField("user_id")
	private Integer userId;
    /**
     * 次数
     */
	@TableField("user_answer_times")
	private Integer userAnswerTimes;
    /**
     * 用户答案
     */
	@TableField("user_answer_code")
	private String userAnswerCode;
    /**
     * 创建时间
     */
	@TableField("user_answer_create_time")
	private Date userAnswerCreateTime;
    /**
     * 修改时间
     */
	@TableField("user_answer_update_time")
	private Date userAnswerUpdateTime;
    /**
     * 创建人
     */
	@TableField("user_answer_create_by")
	private Integer userAnswerCreateBy;
    /**
     * 修改人
     */
	@TableField("user_answer_update_by")
	private Integer userAnswerUpdateBy;

	@TableField("user_answer_version")
	private String userAnswerVersion;

	@TableField("user_answer_grade")
	private String userAnswerGrade;

	@TableField("user_answer_is_sure")
	private String userAnswerIsSure;
	@Override
	protected Serializable pkVal() {
		return this.userAnswerId;
	}

	public String getUserAnswerIsSure() {
		return userAnswerIsSure;
	}

	public void setUserAnswerIsSure(String userAnswerIsSure) {
		this.userAnswerIsSure = userAnswerIsSure;
	}

	public Integer getUserAnswerId() {
		return userAnswerId;
	}

	public String getUserAnswerGrade() {
		return userAnswerGrade;
	}

	public void setUserAnswerGrade(String userAnswerGrade) {
		this.userAnswerGrade = userAnswerGrade;
	}

	public void setUserAnswerId(Integer userAnswerId) {
		this.userAnswerId = userAnswerId;
	}

	public Integer getPracticeId() {
		return practiceId;
	}

	public void setPracticeId(Integer practiceId) {
		this.practiceId = practiceId;
	}

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	public Integer getSubjectsId() {
		return subjectsId;
	}

	public void setSubjectsId(Integer subjectsId) {
		this.subjectsId = subjectsId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserAnswerTimes() {
		return userAnswerTimes;
	}

	public void setUserAnswerTimes(Integer userAnswerTimes) {
		this.userAnswerTimes = userAnswerTimes;
	}

	public String getUserAnswerCode() {
		return userAnswerCode;
	}

	public void setUserAnswerCode(String userAnswerCode) {
		this.userAnswerCode = userAnswerCode;
	}

	public Date getUserAnswerCreateTime() {
		return userAnswerCreateTime;
	}

	public void setUserAnswerCreateTime(Date userAnswerCreateTime) {
		this.userAnswerCreateTime = userAnswerCreateTime;
	}

	public Date getUserAnswerUpdateTime() {
		return userAnswerUpdateTime;
	}

	public void setUserAnswerUpdateTime(Date userAnswerUpdateTime) {
		this.userAnswerUpdateTime = userAnswerUpdateTime;
	}

	public Integer getUserAnswerCreateBy() {
		return userAnswerCreateBy;
	}

	public void setUserAnswerCreateBy(Integer userAnswerCreateBy) {
		this.userAnswerCreateBy = userAnswerCreateBy;
	}

	public Integer getUserAnswerUpdateBy() {
		return userAnswerUpdateBy;
	}

	public void setUserAnswerUpdateBy(Integer userAnswerUpdateBy) {
		this.userAnswerUpdateBy = userAnswerUpdateBy;
	}

	public String getUserAnswerVersion() {
		return userAnswerVersion;
	}

	public void setUserAnswerVersion(String userAnswerVersion) {
		this.userAnswerVersion = userAnswerVersion;
	}

	@Override
	public String toString() {
		return "UserAnswer{" +
				"userAnswerId=" + userAnswerId +
				", practiceId=" + practiceId +
				", examId=" + examId +
				", subjectsId=" + subjectsId +
				", userId=" + userId +
				", userAnswerTimes=" + userAnswerTimes +
				", userAnswerCode=" + userAnswerCode +
				", userAnswerCreateTime=" + userAnswerCreateTime +
				", userAnswerUpdateTime=" + userAnswerUpdateTime +
				", userAnswerCreateBy=" + userAnswerCreateBy +
				", userAnswerUpdateBy=" + userAnswerUpdateBy +
				", userAnswerVersion=" + userAnswerVersion +
				", userAnswerGrade=" + userAnswerGrade +
				", userAnswerIsSure=" + userAnswerIsSure +
				'}';
	}
}
