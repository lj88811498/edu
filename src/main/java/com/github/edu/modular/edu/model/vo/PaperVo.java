package com.github.edu.modular.edu.model.vo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.github.edu.modular.edu.model.Subjects;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <li>文件名称: 题目名称</li>
 * <li>文件描述: 卷子</li>
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
public class PaperVo extends Model<PaperVo> {

    private static final long serialVersionUID = 1L;

	@TableId("paper_id")
	private Integer paperId;
    /**
     * 试卷名称
     */
    @ApiParam(value = "试卷名称", required = true)
	@TableField("paper_name")
	private String paperName;
    /**
     * 出题方式:1固定出题2随机出题
     */
	@ApiParam(value = "出题方式:1固定出题2随机出题", required = true, defaultValue = "1")
	@TableField("paper_type")
	private String paperType;
    /**
     * 单选分值
     */
    @ApiParam("单选分值")
	@TableField("paper_single")
	private String paperSingle;
    /**
     * 多选分值
     */
	@ApiParam("多选分值")
	@TableField("paper_more")
	private String paperMore;
    /**
     * 判断题分值
     */
    @ApiParam("判断题分值")
	@TableField("paper_judge")
	private String paperJudge;
    /**
     * 填空题分值
     */
    @ApiParam("填空题分值")
	@TableField("paper_pack")
	private String paperPack;
    /**
     * 问答分值
     */
    @ApiParam("问答分值")
	@TableField("paper_faq")
	private String paperFaq;

    /**
     * 创建人
     */
    @ApiParam("创建人")
	@TableField("paper_create_by")
	private Integer paperCreateBy;
    /**
     * 修改人
     */
	@TableField("paper_update_by")
	private Integer paperUpdateBy;


	private List<SubjectsVo> subjectsVo;


	private List<PaperSubjectsBankVo> paperSubjectsBankVo;

	@Override
	protected Serializable pkVal() {
		return this.paperId;
	}


	public Integer getPaperId() {
		return paperId;
	}

	public void setPaperId(Integer paperId) {
		this.paperId = paperId;
	}

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public String getPaperType() {
		return paperType;
	}

	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}

	public String getPaperSingle() {
		return paperSingle;
	}

	public void setPaperSingle(String paperSingle) {
		this.paperSingle = paperSingle;
	}

	public String getPaperMore() {
		return paperMore;
	}

	public void setPaperMore(String paperMore) {
		this.paperMore = paperMore;
	}

	public String getPaperJudge() {
		return paperJudge;
	}

	public void setPaperJudge(String paperJudge) {
		this.paperJudge = paperJudge;
	}

	public String getPaperPack() {
		return paperPack;
	}

	public void setPaperPack(String paperPack) {
		this.paperPack = paperPack;
	}

	public String getPaperFaq() {
		return paperFaq;
	}

	public void setPaperFaq(String paperFaq) {
		this.paperFaq = paperFaq;
	}

	public Integer getPaperCreateBy() {
		return paperCreateBy;
	}

	public void setPaperCreateBy(Integer paperCreateBy) {
		this.paperCreateBy = paperCreateBy;
	}

	public Integer getPaperUpdateBy() {
		return paperUpdateBy;
	}

	public void setPaperUpdateBy(Integer paperUpdateBy) {
		this.paperUpdateBy = paperUpdateBy;
	}

	public List<SubjectsVo> getSubjectsVo() {
		return subjectsVo;
	}

	public void setSubjectsVo(List<SubjectsVo> subjectsVo) {
		this.subjectsVo = subjectsVo;
	}

	public List<PaperSubjectsBankVo> getPaperSubjectsBankVo() {
		return paperSubjectsBankVo;
	}

	public void setPaperSubjectsBankVo(List<PaperSubjectsBankVo> paperSubjectsBankVo) {
		this.paperSubjectsBankVo = paperSubjectsBankVo;
	}

	@Override
	public String toString() {
		return "PaperVo{" +
				"paperId=" + paperId +
				", paperName='" + paperName + '\'' +
				", paperType='" + paperType + '\'' +
				", paperSingle='" + paperSingle + '\'' +
				", paperMore='" + paperMore + '\'' +
				", paperJudge='" + paperJudge + '\'' +
				", paperPack='" + paperPack + '\'' +
				", paperFaq='" + paperFaq + '\'' +
				", paperCreateBy=" + paperCreateBy +
				", paperUpdateBy=" + paperUpdateBy +
				", subjectsVo=" + subjectsVo +
				", paperSubjectsBankVo=" + paperSubjectsBankVo +
				'}';
	}
}
