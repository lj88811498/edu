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
 * <li>文件描述: 答案</li>
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
@TableName("subjects_answer")
public class SubjectsAnswer extends Model<SubjectsAnswer> {

    private static final long serialVersionUID = 1L;

	@TableId("subjects_answer_id")
	private Integer subjectsAnswerId;
    /**
     * 题目id
     */
	@TableField("subjects_id")
	private Integer subjectsId;
    /**
     * 编号
     */
	@TableField("subjects_answer_code")
	private String subjectsAnswerCode;
    /**
     * 是否正确：1正确0错误
     */
	@TableField("subjects_answer_sure")
	private String subjectsAnswerSure;
    /**
     * 答案
     */
	@TableField("subjects_answer_name")
	private String subjectsAnswerName;
    /**
     * 答案图片
     */
	@TableField("subjects_answer_name_img_url")
	private String subjectsAnswerNameImgUrl;
    /**
     * 创建时间
     */
	@TableField("subjects_answer_create_time")
	private Date subjectsAnswerCreateTime;
    /**
     * 修改时间
     */
	@TableField("subjects_answer_update_time")
	private Date subjectsAnswerUpdateTime;
    /**
     * 创建人
     */
	@TableField("subjects_answer_create_by")
	private Integer subjectsAnswerCreateBy;
    /**
     * 修改人
     */
	@TableField("subjects_answer_update_by")
	private Integer subjectsAnswerUpdateBy;

	@TableField(exist = false)
	private String attachmentCode;

	@Override
	protected Serializable pkVal() {
		return this.subjectsAnswerId;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getSubjectsAnswerId() {
		return subjectsAnswerId;
	}

	public void setSubjectsAnswerId(Integer subjectsAnswerId) {
		this.subjectsAnswerId = subjectsAnswerId;
	}

	public Integer getSubjectsId() {
		return subjectsId;
	}

	public void setSubjectsId(Integer subjectsId) {
		this.subjectsId = subjectsId;
	}

	public String getSubjectsAnswerCode() {
		return subjectsAnswerCode;
	}

	public void setSubjectsAnswerCode(String subjectsAnswerCode) {
		this.subjectsAnswerCode = subjectsAnswerCode;
	}

	public String getSubjectsAnswerSure() {
		return subjectsAnswerSure;
	}

	public void setSubjectsAnswerSure(String subjectsAnswerSure) {
		this.subjectsAnswerSure = subjectsAnswerSure;
	}

	public String getSubjectsAnswerName() {
		return subjectsAnswerName;
	}

	public void setSubjectsAnswerName(String subjectsAnswerName) {
		this.subjectsAnswerName = subjectsAnswerName;
	}

	public String getSubjectsAnswerNameImgUrl() {
		return subjectsAnswerNameImgUrl;
	}

	public void setSubjectsAnswerNameImgUrl(String subjectsAnswerNameImgUrl) {
		this.subjectsAnswerNameImgUrl = subjectsAnswerNameImgUrl;
	}

	public Date getSubjectsAnswerCreateTime() {
		return subjectsAnswerCreateTime;
	}

	public void setSubjectsAnswerCreateTime(Date subjectsAnswerCreateTime) {
		this.subjectsAnswerCreateTime = subjectsAnswerCreateTime;
	}

	public Date getSubjectsAnswerUpdateTime() {
		return subjectsAnswerUpdateTime;
	}

	public void setSubjectsAnswerUpdateTime(Date subjectsAnswerUpdateTime) {
		this.subjectsAnswerUpdateTime = subjectsAnswerUpdateTime;
	}

	public Integer getSubjectsAnswerCreateBy() {
		return subjectsAnswerCreateBy;
	}

	public void setSubjectsAnswerCreateBy(Integer subjectsAnswerCreateBy) {
		this.subjectsAnswerCreateBy = subjectsAnswerCreateBy;
	}

	public Integer getSubjectsAnswerUpdateBy() {
		return subjectsAnswerUpdateBy;
	}

	public void setSubjectsAnswerUpdateBy(Integer subjectsAnswerUpdateBy) {
		this.subjectsAnswerUpdateBy = subjectsAnswerUpdateBy;
	}

	public String getAttachmentCode() {
		return attachmentCode;
	}

	public void setAttachmentCode(String attachmentCode) {
		this.attachmentCode = attachmentCode;
	}

	@Override
	public String toString() {
		return "SubjectsAnswer{" +
				"subjectsAnswerId=" + subjectsAnswerId +
				", subjectsId=" + subjectsId +
				", subjectsAnswerCode='" + subjectsAnswerCode + '\'' +
				", subjectsAnswerSure='" + subjectsAnswerSure + '\'' +
				", subjectsAnswerName='" + subjectsAnswerName + '\'' +
				", subjectsAnswerNameImgUrl='" + subjectsAnswerNameImgUrl + '\'' +
				", subjectsAnswerCreateTime=" + subjectsAnswerCreateTime +
				", subjectsAnswerUpdateTime=" + subjectsAnswerUpdateTime +
				", subjectsAnswerCreateBy=" + subjectsAnswerCreateBy +
				", subjectsAnswerUpdateBy=" + subjectsAnswerUpdateBy +
				", attachmentCode='" + attachmentCode + '\'' +
				'}';
	}
}
