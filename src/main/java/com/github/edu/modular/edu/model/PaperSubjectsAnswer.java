package com.github.edu.modular.edu.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 卷子答案
 * </p>
 *
 * @author Monkey
 * @since 2020-05-15
 */
@ApiModel
public class PaperSubjectsAnswer extends Model<PaperSubjectsAnswer> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "paper_subjects_answer_id", type = IdType.AUTO)
    private Integer paperSubjectsAnswerId;
    /**
     * 题目id
     */
    private Integer subjectsId;
    /**
     * 卷子id
     */
    private Integer paperId;
    /**
     * 随机排序
     */
    private String paperSubjectsAnswerOrder;
    /**
     * 编号
     */
    private String paperSubjectsAnswerCode;
    /**
     * 是否正确：1正确0错误
     */
    private String paperSubjectsAnswerSure;
    /**
     * 答案
     */
    private String paperSubjectsAnswerName;
    /**
     * 答案图片
     */
    private String paperSubjectsAnswerNameImgUrl;
    /**
     * 创建时间
     */
    private Date paperSubjectsAnswerCreateTime;


    private String paperSubjectsAnswerVersion;

    public String getPaperSubjectsAnswerVersion() {
        return paperSubjectsAnswerVersion;
    }

    public void setPaperSubjectsAnswerVersion(String paperSubjectsAnswerVersion) {
        this.paperSubjectsAnswerVersion = paperSubjectsAnswerVersion;
    }

    public Integer getPaperSubjectsAnswerId() {
        return paperSubjectsAnswerId;
    }

    public void setPaperSubjectsAnswerId(Integer paperSubjectsAnswerId) {
        this.paperSubjectsAnswerId = paperSubjectsAnswerId;
    }

    public Integer getSubjectsId() {
        return subjectsId;
    }

    public void setSubjectsId(Integer subjectsId) {
        this.subjectsId = subjectsId;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getPaperSubjectsAnswerOrder() {
        return paperSubjectsAnswerOrder;
    }

    public void setPaperSubjectsAnswerOrder(String paperSubjectsAnswerOrder) {
        this.paperSubjectsAnswerOrder = paperSubjectsAnswerOrder;
    }

    public String getPaperSubjectsAnswerCode() {
        return paperSubjectsAnswerCode;
    }

    public void setPaperSubjectsAnswerCode(String paperSubjectsAnswerCode) {
        this.paperSubjectsAnswerCode = paperSubjectsAnswerCode;
    }

    public String getPaperSubjectsAnswerSure() {
        return paperSubjectsAnswerSure;
    }

    public void setPaperSubjectsAnswerSure(String paperSubjectsAnswerSure) {
        this.paperSubjectsAnswerSure = paperSubjectsAnswerSure;
    }

    public String getPaperSubjectsAnswerName() {
        return paperSubjectsAnswerName;
    }

    public void setPaperSubjectsAnswerName(String paperSubjectsAnswerName) {
        this.paperSubjectsAnswerName = paperSubjectsAnswerName;
    }

    public String getPaperSubjectsAnswerNameImgUrl() {
        return paperSubjectsAnswerNameImgUrl;
    }

    public void setPaperSubjectsAnswerNameImgUrl(String paperSubjectsAnswerNameImgUrl) {
        this.paperSubjectsAnswerNameImgUrl = paperSubjectsAnswerNameImgUrl;
    }

    public Date getPaperSubjectsAnswerCreateTime() {
        return paperSubjectsAnswerCreateTime;
    }

    public void setPaperSubjectsAnswerCreateTime(Date paperSubjectsAnswerCreateTime) {
        this.paperSubjectsAnswerCreateTime = paperSubjectsAnswerCreateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.paperSubjectsAnswerId;
    }

    @Override
    public String toString() {
        return "PaperSubjectsAnswer{" +
        "paperSubjectsAnswerId=" + paperSubjectsAnswerId +
        ", subjectsId=" + subjectsId +
        ", paperId=" + paperId +
        ", paperSubjectsAnswerOrder=" + paperSubjectsAnswerOrder +
        ", paperSubjectsAnswerCode=" + paperSubjectsAnswerCode +
        ", paperSubjectsAnswerSure=" + paperSubjectsAnswerSure +
        ", paperSubjectsAnswerName=" + paperSubjectsAnswerName +
        ", paperSubjectsAnswerNameImgUrl=" + paperSubjectsAnswerNameImgUrl +
        ", paperSubjectsAnswerCreateTime=" + paperSubjectsAnswerCreateTime +
        ", paperSubjectsAnswerVersion=" + paperSubjectsAnswerVersion +
        "}";
    }
}
