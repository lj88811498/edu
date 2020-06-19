package com.github.edu.modular.edu.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <li>文件名称: 题目名称</li>
 * <li>文件描述: 题目</li>
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
public class Subjects extends Model<Subjects> {

    private static final long serialVersionUID = 1L;

	@TableId("subjects_id")
	private Integer subjectsId;
    /**
     * 题库id
     */
	@TableField("subjects_bank_id")
	private Integer subjectsBankId;
    /**
     * 题目名称
     */
	@TableField("subjects_name")
	private String subjectsName;
    /**
     * 题干图片
     */
	@TableField("subjects_name_img_url")
	private String subjectsNameImgUrl;
    /**
     * 题型:1单选2多选3判断4填空5问答
     */
	@TableField("subjects_type")
	private String subjectsType;
    /**
     * 答案（判断题时：1正确0错误）
     */
	@TableField("subjects_sure_answer")
	private String subjectsSureAnswer;
    /**
     * 题干解析
     */
	@TableField("subjects_analysis")
	private String subjectsAnalysis;
    /**
     * 题干解析图片
     */
	@TableField("subjects_analysis_img_url")
	private String subjectsAnalysisImgUrl;
    /**
     * 创建时间
     */
	@TableField("subjects_create_time")
	private Date subjectsCreateTime;
    /**
     * 修改时间
     */
	@TableField("subjects_update_time")
	private Date subjectsUpdateTime;
    /**
     * 创建人
     */
	@TableField("subjects_create_by")
	private Integer subjectsCreateBy;
    /**
     * 修改人
     */
	@TableField("subjects_update_by")
	private Integer subjectsUpdateBy;
    /**
     * 是否删除：0否1是
     */
	@TableField("subjects_is_delete")
	private Integer subjectsIsDelete;

	/**
	 * 题干
	 */
	@TableField(exist = false)
	private String subjectsAttachmentCode;

	/**
	 * 解析
	 */
	@TableField(exist = false)
	private String analysisAttachmentCode;

	@TableField(exist = false)
	private List<SubjectsAnswer> subjectsAnswers;

	public List<SubjectsAnswer> getSubjectsAnswers() {
		return subjectsAnswers;
	}

	public void setSubjectsAnswers(List<SubjectsAnswer> subjectsAnswers) {
		this.subjectsAnswers = subjectsAnswers;
	}


	@Override
	protected Serializable pkVal() {
		return this.subjectsId;
	}

	public Integer getSubjectsId() {
		return subjectsId;
	}

	public void setSubjectsId(Integer subjectsId) {
		this.subjectsId = subjectsId;
	}

	public Integer getSubjectsBankId() {
		return subjectsBankId;
	}

	public void setSubjectsBankId(Integer subjectsBankId) {
		this.subjectsBankId = subjectsBankId;
	}

	public String getSubjectsName() {
		return subjectsName;
	}

	public void setSubjectsName(String subjectsName) {
		this.subjectsName = subjectsName;
	}

	public String getSubjectsNameImgUrl() {
		return subjectsNameImgUrl;
	}

	public void setSubjectsNameImgUrl(String subjectsNameImgUrl) {
		this.subjectsNameImgUrl = subjectsNameImgUrl;
	}

	public String getSubjectsType() {
		return subjectsType;
	}

	public void setSubjectsType(String subjectsType) {
		this.subjectsType = subjectsType;
	}

	public String getSubjectsSureAnswer() {
		return subjectsSureAnswer;
	}

	public void setSubjectsSureAnswer(String subjectsSureAnswer) {
		this.subjectsSureAnswer = subjectsSureAnswer;
	}

	public String getSubjectsAnalysis() {
		return subjectsAnalysis;
	}

	public void setSubjectsAnalysis(String subjectsAnalysis) {
		this.subjectsAnalysis = subjectsAnalysis;
	}

	public String getSubjectsAnalysisImgUrl() {
		return subjectsAnalysisImgUrl;
	}

	public void setSubjectsAnalysisImgUrl(String subjectsAnalysisImgUrl) {
		this.subjectsAnalysisImgUrl = subjectsAnalysisImgUrl;
	}

	public Date getSubjectsCreateTime() {
		return subjectsCreateTime;
	}

	public void setSubjectsCreateTime(Date subjectsCreateTime) {
		this.subjectsCreateTime = subjectsCreateTime;
	}

	public Date getSubjectsUpdateTime() {
		return subjectsUpdateTime;
	}

	public void setSubjectsUpdateTime(Date subjectsUpdateTime) {
		this.subjectsUpdateTime = subjectsUpdateTime;
	}

	public Integer getSubjectsCreateBy() {
		return subjectsCreateBy;
	}

	public void setSubjectsCreateBy(Integer subjectsCreateBy) {
		this.subjectsCreateBy = subjectsCreateBy;
	}

	public Integer getSubjectsUpdateBy() {
		return subjectsUpdateBy;
	}

	public void setSubjectsUpdateBy(Integer subjectsUpdateBy) {
		this.subjectsUpdateBy = subjectsUpdateBy;
	}

	public Integer getSubjectsIsDelete() {
		return subjectsIsDelete;
	}

	public void setSubjectsIsDelete(Integer subjectsIsDelete) {
		this.subjectsIsDelete = subjectsIsDelete;
	}

	public String getSubjectsAttachmentCode() {
		return subjectsAttachmentCode;
	}

	public void setSubjectsAttachmentCode(String subjectsAttachmentCode) {
		this.subjectsAttachmentCode = subjectsAttachmentCode;
	}

	public String getAnalysisAttachmentCode() {
		return analysisAttachmentCode;
	}

	public void setAnalysisAttachmentCode(String analysisAttachmentCode) {
		this.analysisAttachmentCode = analysisAttachmentCode;
	}

	@Override
	public String toString() {
		return "Subjects{" +
				"subjectsId=" + subjectsId +
				", subjectsBankId=" + subjectsBankId +
				", subjectsName='" + subjectsName + '\'' +
				", subjectsNameImgUrl='" + subjectsNameImgUrl + '\'' +
				", subjectsType='" + subjectsType + '\'' +
				", subjectsSureAnswer='" + subjectsSureAnswer + '\'' +
				", subjectsAnalysis='" + subjectsAnalysis + '\'' +
				", subjectsAnalysisImgUrl='" + subjectsAnalysisImgUrl + '\'' +
				", subjectsCreateTime=" + subjectsCreateTime +
				", subjectsUpdateTime=" + subjectsUpdateTime +
				", subjectsCreateBy=" + subjectsCreateBy +
				", subjectsUpdateBy=" + subjectsUpdateBy +
				", subjectsIsDelete=" + subjectsIsDelete +
				", subjectsAttachmentCode=" + subjectsAttachmentCode +
				", analysisAttachmentCode=" + analysisAttachmentCode +
				", subjectsAnswers=" + subjectsAnswers +
				'}';
	}
}
