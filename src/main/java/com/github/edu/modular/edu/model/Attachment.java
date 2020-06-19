package com.github.edu.modular.edu.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 附件
 * </p>
 *
 * @author Monkey
 * @since 2020-04-19
 */
@ApiModel
public class Attachment extends Model<Attachment> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "attachment_id", type = IdType.AUTO)
    private Integer attachmentId;
    /**
     * 问题分类id
     */
    private Integer attachmentTaskId;

    /**
     * 附件code
     */
    private String attachmentCode;


    /**
     * 附件code
     */
    private String attachmentFileCode;

    /**
     * 请求地址
     */
    private String attachmentUrl;


    /**
     * 附件下载地址
     */
    private String attachmentDownloadUrl;


    /**
     * 附件名字
     */
    private String attachmentName;
    /**
     * 附件类型：1.工单
     */
    private String attachmentType;
    /**
     * 创建时间
     */
    private Date attachmentCreateTime;
    /**
     * 修改时间
     */
    private Date attachmentUpdateTime;
    /**
     * 创建人
     */
    private Integer attachmentCreateBy;
    /**
     * 修改人
     */
    private Integer attachmentUpdateBy;


    public Integer getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Integer attachmentId) {
        this.attachmentId = attachmentId;
    }

    public Integer getAttachmentTaskId() {
        return attachmentTaskId;
    }

    public void setAttachmentTaskId(Integer attachmentTaskId) {
        this.attachmentTaskId = attachmentTaskId;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    public String getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
    }

    public Date getAttachmentCreateTime() {
        return attachmentCreateTime;
    }

    public void setAttachmentCreateTime(Date attachmentCreateTime) {
        this.attachmentCreateTime = attachmentCreateTime;
    }

    public Date getAttachmentUpdateTime() {
        return attachmentUpdateTime;
    }

    public void setAttachmentUpdateTime(Date attachmentUpdateTime) {
        this.attachmentUpdateTime = attachmentUpdateTime;
    }

    public Integer getAttachmentCreateBy() {
        return attachmentCreateBy;
    }

    public void setAttachmentCreateBy(Integer attachmentCreateBy) {
        this.attachmentCreateBy = attachmentCreateBy;
    }

    public Integer getAttachmentUpdateBy() {
        return attachmentUpdateBy;
    }

    public void setAttachmentUpdateBy(Integer attachmentUpdateBy) {
        this.attachmentUpdateBy = attachmentUpdateBy;
    }

    public String getAttachmentCode() {
        return attachmentCode;
    }

    public void setAttachmentCode(String attachmentCode) {
        this.attachmentCode = attachmentCode;
    }

    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }

    public String getAttachmentDownloadUrl() {
        return attachmentDownloadUrl;
    }

    public void setAttachmentDownloadUrl(String attachmentDownloadUrl) {
        this.attachmentDownloadUrl = attachmentDownloadUrl;
    }

    public String getAttachmentFileCode() {
        return attachmentFileCode;
    }

    public void setAttachmentFileCode(String attachmentFileCode) {
        this.attachmentFileCode = attachmentFileCode;
    }

    @Override
    protected Serializable pkVal() {
        return this.attachmentId;
    }

    @Override
    public String toString() {
        return "Attachment{" +
        "attachmentId=" + attachmentId +
        ", attachmentTaskId=" + attachmentTaskId +
        ", attachmentUrl=" + attachmentUrl +
        ", attachmentDownloadUrl=" + attachmentDownloadUrl +
        ", attachmentCode=" + attachmentCode +
        ", attachmentFileCode=" + attachmentFileCode +
        ", attachmentName=" + attachmentName +
        ", attachmentType=" + attachmentType +
        ", attachmentCreateTime=" + attachmentCreateTime +
        ", attachmentUpdateTime=" + attachmentUpdateTime +
        ", attachmentCreateBy=" + attachmentCreateBy +
        ", attachmentUpdateBy=" + attachmentUpdateBy +
        "}";
    }
}
