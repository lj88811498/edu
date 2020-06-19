package com.github.edu.modular.edu.model.vo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.github.edu.modular.edu.model.SubjectsAnswer;
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
public class SubjectsVo extends Model<SubjectsVo> {

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
	 * 题型:1单选2多选3判断4填空5问答
	 */
	private String subjectsType;


	private String paperSubjectsGrade;

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

	public String getSubjectsType() {
		return subjectsType;
	}

	public void setSubjectsType(String subjectsType) {
		this.subjectsType = subjectsType;
	}

	public String getPaperSubjectsGrade() {
		return paperSubjectsGrade;
	}

	public void setPaperSubjectsGrade(String paperSubjectsGrade) {
		this.paperSubjectsGrade = paperSubjectsGrade;
	}

	@Override
	public String toString() {
		return "SubjectsVo{" +
				"subjectsId=" + subjectsId +
				", subjectsBankId=" + subjectsBankId +
				", subjectsName=" + subjectsName +
				", subjectsType=" + subjectsType +
				", paperSubjectsGrade=" + paperSubjectsGrade +
				'}';
	}

	@Override
	protected Serializable pkVal() {
		return this.subjectsId;
	}
}
