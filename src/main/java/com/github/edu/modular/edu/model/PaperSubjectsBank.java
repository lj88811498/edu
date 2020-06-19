package com.github.edu.modular.edu.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 卷子题库
 * </p>
 *
 * @author Monkey
 * @since 2020-05-15
 */
@ApiModel
public class PaperSubjectsBank extends Model<PaperSubjectsBank> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "paper_subjects_bank_id", type = IdType.AUTO)
    private Integer paperSubjectsBankId;

    private Integer paperId;
    /**
     * 题库id
     */
    private Integer subjectsBankId;
    /**
     * 题库名称
     */
    private String subjectsBankName;
    /**
     * 单选题个数
     */
    private String paperSubjectsBankSingle;
    /**
     * 多选个数
     */
    private String paperSubjectsBankMore;
    /**
     * 判断题个数
     */
    private String paperSubjectsBankJudge;
    /**
     * 填空题个数
     */
    private String paperSubjectsBankPack;
    /**
     * 问答个数
     */
    private String paperSubjectsBankFaq;
    /**
     * 创建时间
     */
    private Date paperSubjectsBankCreateTime;
    /**
     * 修改时间
     */
    private Date paperSubjectsBankUpdateTime;
    /**
     * 创建人
     */
    private Integer paperSubjectsBankCreateBy;
    /**
     * 修改人
     */
    private Integer paperSubjectsBankUpdateBy;
    /**
     * 是否删除：0否1是
     */
    private Integer paperSubjectsBankIsDelete;


    public Integer getPaperSubjectsBankId() {
        return paperSubjectsBankId;
    }

    public void setPaperSubjectsBankId(Integer paperSubjectsBankId) {
        this.paperSubjectsBankId = paperSubjectsBankId;
    }

    public Integer getSubjectsBankId() {
        return subjectsBankId;
    }

    public void setSubjectsBankId(Integer subjectsBankId) {
        this.subjectsBankId = subjectsBankId;
    }

    public String getSubjectsBankName() {
        return subjectsBankName;
    }

    public void setSubjectsBankName(String subjectsBankName) {
        this.subjectsBankName = subjectsBankName;
    }

    public String getPaperSubjectsBankSingle() {
        return paperSubjectsBankSingle;
    }

    public void setPaperSubjectsBankSingle(String paperSubjectsBankSingle) {
        this.paperSubjectsBankSingle = paperSubjectsBankSingle;
    }

    public String getPaperSubjectsBankMore() {
        return paperSubjectsBankMore;
    }

    public void setPaperSubjectsBankMore(String paperSubjectsBankMore) {
        this.paperSubjectsBankMore = paperSubjectsBankMore;
    }

    public String getPaperSubjectsBankJudge() {
        return paperSubjectsBankJudge;
    }

    public void setPaperSubjectsBankJudge(String paperSubjectsBankJudge) {
        this.paperSubjectsBankJudge = paperSubjectsBankJudge;
    }

    public String getPaperSubjectsBankPack() {
        return paperSubjectsBankPack;
    }

    public void setPaperSubjectsBankPack(String paperSubjectsBankPack) {
        this.paperSubjectsBankPack = paperSubjectsBankPack;
    }

    public String getPaperSubjectsBankFaq() {
        return paperSubjectsBankFaq;
    }

    public void setPaperSubjectsBankFaq(String paperSubjectsBankFaq) {
        this.paperSubjectsBankFaq = paperSubjectsBankFaq;
    }

    public Date getPaperSubjectsBankCreateTime() {
        return paperSubjectsBankCreateTime;
    }

    public void setPaperSubjectsBankCreateTime(Date paperSubjectsBankCreateTime) {
        this.paperSubjectsBankCreateTime = paperSubjectsBankCreateTime;
    }

    public Date getPaperSubjectsBankUpdateTime() {
        return paperSubjectsBankUpdateTime;
    }

    public void setPaperSubjectsBankUpdateTime(Date paperSubjectsBankUpdateTime) {
        this.paperSubjectsBankUpdateTime = paperSubjectsBankUpdateTime;
    }

    public Integer getPaperSubjectsBankCreateBy() {
        return paperSubjectsBankCreateBy;
    }

    public void setPaperSubjectsBankCreateBy(Integer paperSubjectsBankCreateBy) {
        this.paperSubjectsBankCreateBy = paperSubjectsBankCreateBy;
    }

    public Integer getPaperSubjectsBankUpdateBy() {
        return paperSubjectsBankUpdateBy;
    }

    public void setPaperSubjectsBankUpdateBy(Integer paperSubjectsBankUpdateBy) {
        this.paperSubjectsBankUpdateBy = paperSubjectsBankUpdateBy;
    }

    public Integer getPaperSubjectsBankIsDelete() {
        return paperSubjectsBankIsDelete;
    }

    public void setPaperSubjectsBankIsDelete(Integer paperSubjectsBankIsDelete) {
        this.paperSubjectsBankIsDelete = paperSubjectsBankIsDelete;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    @Override
    protected Serializable pkVal() {
        return this.paperSubjectsBankId;
    }

    @Override
    public String toString() {
        return "PaperSubjectsBank{" +
        "paperSubjectsBankId=" + paperSubjectsBankId +
        ", paperId=" + paperId +
        ", subjectsBankId=" + subjectsBankId +
        ", subjectsBankName=" + subjectsBankName +
        ", paperSubjectsBankSingle=" + paperSubjectsBankSingle +
        ", paperSubjectsBankMore=" + paperSubjectsBankMore +
        ", paperSubjectsBankJudge=" + paperSubjectsBankJudge +
        ", paperSubjectsBankPack=" + paperSubjectsBankPack +
        ", paperSubjectsBankFaq=" + paperSubjectsBankFaq +
        ", paperSubjectsBankCreateTime=" + paperSubjectsBankCreateTime +
        ", paperSubjectsBankUpdateTime=" + paperSubjectsBankUpdateTime +
        ", paperSubjectsBankCreateBy=" + paperSubjectsBankCreateBy +
        ", paperSubjectsBankUpdateBy=" + paperSubjectsBankUpdateBy +
        ", paperSubjectsBankIsDelete=" + paperSubjectsBankIsDelete +
        "}";
    }
}
