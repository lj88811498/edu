package com.github.edu.modular.edu.model.vo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 卷子题库
 * </p>
 *
 * @author Monkey
 * @since 2020-05-15
 */
@ApiModel
public class PaperSubjectsBankVo{

    private static final long serialVersionUID = 1L;

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
     * 创建人
     */
    private Integer paperSubjectsBankCreateBy;


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

    public Integer getPaperSubjectsBankCreateBy() {
        return paperSubjectsBankCreateBy;
    }

    public void setPaperSubjectsBankCreateBy(Integer paperSubjectsBankCreateBy) {
        this.paperSubjectsBankCreateBy = paperSubjectsBankCreateBy;
    }

    @Override
    public String toString() {
        return "PaperSubjectsBank{" +
        ", subjectsBankId=" + subjectsBankId +
        ", subjectsBankName=" + subjectsBankName +
        ", paperSubjectsBankSingle=" + paperSubjectsBankSingle +
        ", paperSubjectsBankMore=" + paperSubjectsBankMore +
        ", paperSubjectsBankJudge=" + paperSubjectsBankJudge +
        ", paperSubjectsBankPack=" + paperSubjectsBankPack +
        ", paperSubjectsBankFaq=" + paperSubjectsBankFaq +
        ", paperSubjectsBankCreateBy=" + paperSubjectsBankCreateBy +
        "}";
    }
}
