package com.github.edu.modular.edu.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <li>文件名称: 题目名称</li>
 * <li>文件描述: 考试</li>
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
public class Exam extends Model<Exam> {

    private static final long serialVersionUID = 1L;

	@TableId("exam_id")
	private Integer examId;
    /**
     * 卷子id
     */
	@TableField("paper_id")
	private Integer paperId;
    /**
     * 考试名称
     */
	@TableField("exam_name")
	private String examName;
    /**
     * 考试状态：1未发布2已发布未开始3进行中4已结束
     */
	@TableField("exam_status")
	private String examStatus;

	@TableField("exam_version")
	private String examVersion;
    /**
     * 考试开始时间
     */
	@TableField("exam_start_time")
	private Date examStartTime;
    /**
     * 考试结束时间
     */
	@TableField("exam_end_time")
	private Date examEndTime;
    /**
     * 答题时间（分钟）
     */
	@TableField("exam_time")
	private String examTime;
    /**
     * 答题次数
     */
	@TableField("exam_times")
	private String examTimes;
    /**
     * 考试须知
     */
	@TableField("exam_desc")
	private String examDesc;
    /**
     * 封面图片
     */
	@TableField("exam_index_img_url")
	private String examIndexImgUrl;
    /**
     * 通过学分
     */
	@TableField("exam_credit")
	private String examCredit;
    /**
     * 是否打乱试题顺序：0否1是
     */
	@TableField("exam_is_order")
	private String examIsOrder;
    /**
     * 是否打乱选择题选项顺序：0否1是
     */
	@TableField("exam_is_order_choice")
	private String examIsOrderChoice;
    /**
     * 重连次数，-1时表示不限制
     */
	@TableField("exam_reconnect")
	private String examReconnect;
    /**
     * 允许查看已提交答卷：1交卷后显示正确答案2考试结束后显示正确答案3手动公布正确答案
     */
	@TableField("exam_submit")
	private String examSubmit;
    /**
     * 及格分数
     */
	@TableField("exam_grade")
	private String examGrade;
    /**
     * 学员集合
     */
	@TableField("exam_users")
	private String examUsers;
    /**
     * 阅卷人集合
     */
	@TableField("exam_checkers")
	private String examCheckers;
    /**
     * 是否显示考生姓名：0否1是
     */
	@TableField("exam_show_user")
	private String examShowUser;
    /**
     * 是否填空题自动批阅时精准匹配答案：0否1是
     */
	@TableField("exam_auto_pack")
	private String examAutoPack;
    /**
     * 创建时间
     */
	@TableField("exam_create_time")
	private Date examCreateTime;
    /**
     * 修改时间
     */
	@TableField("exam_update_time")
	private Date examUpdateTime;
    /**
     * 创建人
     */
	@TableField("exam_create_by")
	private Integer examCreateBy;
    /**
     * 修改人
     */
	@TableField("exam_update_by")
	private Integer examUpdateBy;
    /**
     * 是否删除：0否1是
     */
	@TableField("exam_is_delete")
	private Integer examIsDelete;

	@TableField(exist = false)
	private String attachmentCode;

	@ApiParam("比例")
	@TableField(exist = false)
	private String proportion;

	@TableField(exist = false)
	private String accessPersonsCount;

	@TableField(exist = false)
	private String accessProportion;
	/**
	 * 创建人
	 */
	@TableField(exist = false)
	private Integer examCreateByName;

	public String getProportion() {
		return proportion;
	}

	public void setProportion(String proportion) {
		this.proportion = proportion;
	}

	public String getAccessPersonsCount() {
		return accessPersonsCount;
	}

	public void setAccessPersonsCount(String accessPersonsCount) {
		this.accessPersonsCount = accessPersonsCount;
	}

	public String getAccessProportion() {
		return accessProportion;
	}

	public void setAccessProportion(String accessProportion) {
		this.accessProportion = accessProportion;
	}

	public Integer getExamCreateByName() {
		return examCreateByName;
	}

	public void setExamCreateByName(Integer examCreateByName) {
		this.examCreateByName = examCreateByName;
	}

	@Override
	protected Serializable pkVal() {
		return this.examId;
	}

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	public Integer getPaperId() {
		return paperId;
	}

	public void setPaperId(Integer paperId) {
		this.paperId = paperId;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getExamStatus() {
		return examStatus;
	}

	public void setExamStatus(String examStatus) {
		this.examStatus = examStatus;
	}

	public Date getExamStartTime() {
		return examStartTime;
	}

	public void setExamStartTime(Date examStartTime) {
		this.examStartTime = examStartTime;
	}

	public Date getExamEndTime() {
		return examEndTime;
	}

	public void setExamEndTime(Date examEndTime) {
		this.examEndTime = examEndTime;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public String getExamTimes() {
		return examTimes;
	}

	public void setExamTimes(String examTimes) {
		this.examTimes = examTimes;
	}

	public String getExamDesc() {
		return examDesc;
	}

	public void setExamDesc(String examDesc) {
		this.examDesc = examDesc;
	}

	public String getExamIndexImgUrl() {
		return examIndexImgUrl;
	}

	public void setExamIndexImgUrl(String examIndexImgUrl) {
		this.examIndexImgUrl = examIndexImgUrl;
	}

	public String getExamCredit() {
		return examCredit;
	}

	public void setExamCredit(String examCredit) {
		this.examCredit = examCredit;
	}

	public String getExamIsOrder() {
		return examIsOrder;
	}

	public void setExamIsOrder(String examIsOrder) {
		this.examIsOrder = examIsOrder;
	}

	public String getExamIsOrderChoice() {
		return examIsOrderChoice;
	}

	public void setExamIsOrderChoice(String examIsOrderChoice) {
		this.examIsOrderChoice = examIsOrderChoice;
	}

	public String getExamReconnect() {
		return examReconnect;
	}

	public void setExamReconnect(String examReconnect) {
		this.examReconnect = examReconnect;
	}

	public String getExamSubmit() {
		return examSubmit;
	}

	public void setExamSubmit(String examSubmit) {
		this.examSubmit = examSubmit;
	}

	public String getExamGrade() {
		return examGrade;
	}

	public void setExamGrade(String examGrade) {
		this.examGrade = examGrade;
	}

	public String getExamUsers() {
		return examUsers;
	}

	public void setExamUsers(String examUsers) {
		this.examUsers = examUsers;
	}

	public String getExamCheckers() {
		return examCheckers;
	}

	public void setExamCheckers(String examCheckers) {
		this.examCheckers = examCheckers;
	}

	public String getExamShowUser() {
		return examShowUser;
	}

	public void setExamShowUser(String examShowUser) {
		this.examShowUser = examShowUser;
	}

	public String getExamAutoPack() {
		return examAutoPack;
	}

	public void setExamAutoPack(String examAutoPack) {
		this.examAutoPack = examAutoPack;
	}

	public Date getExamCreateTime() {
		return examCreateTime;
	}

	public void setExamCreateTime(Date examCreateTime) {
		this.examCreateTime = examCreateTime;
	}

	public Date getExamUpdateTime() {
		return examUpdateTime;
	}

	public void setExamUpdateTime(Date examUpdateTime) {
		this.examUpdateTime = examUpdateTime;
	}

	public Integer getExamCreateBy() {
		return examCreateBy;
	}

	public void setExamCreateBy(Integer examCreateBy) {
		this.examCreateBy = examCreateBy;
	}

	public Integer getExamUpdateBy() {
		return examUpdateBy;
	}

	public void setExamUpdateBy(Integer examUpdateBy) {
		this.examUpdateBy = examUpdateBy;
	}

	public Integer getExamIsDelete() {
		return examIsDelete;
	}

	public void setExamIsDelete(Integer examIsDelete) {
		this.examIsDelete = examIsDelete;
	}

	public String getAttachmentCode() {
		return attachmentCode;
	}

	public void setAttachmentCode(String attachmentCode) {
		this.attachmentCode = attachmentCode;
	}

	public String getExamVersion() {
		return examVersion;
	}

	public void setExamVersion(String examVersion) {
		this.examVersion = examVersion;
	}

	@Override
	public String toString() {
		return "Exam{" +
				"examId=" + examId +
				", paperId=" + paperId +
				", examName='" + examName + '\'' +
				", examStatus='" + examStatus + '\'' +
				", examVersion='" + examVersion + '\'' +
				", examStartTime=" + examStartTime +
				", examEndTime=" + examEndTime +
				", examTime='" + examTime + '\'' +
				", examTimes='" + examTimes + '\'' +
				", examDesc='" + examDesc + '\'' +
				", examIndexImgUrl='" + examIndexImgUrl + '\'' +
				", examCredit='" + examCredit + '\'' +
				", examIsOrder='" + examIsOrder + '\'' +
				", examIsOrderChoice='" + examIsOrderChoice + '\'' +
				", examReconnect='" + examReconnect + '\'' +
				", examSubmit='" + examSubmit + '\'' +
				", examGrade='" + examGrade + '\'' +
				", examUsers='" + examUsers + '\'' +
				", examCheckers='" + examCheckers + '\'' +
				", examShowUser='" + examShowUser + '\'' +
				", examAutoPack='" + examAutoPack + '\'' +
				", examCreateTime=" + examCreateTime +
				", examUpdateTime=" + examUpdateTime +
				", examCreateBy=" + examCreateBy +
				", examCreateByName=" + examCreateByName +
				", examUpdateBy=" + examUpdateBy +
				", examIsDelete=" + examIsDelete +
				", attachmentCode=" + attachmentCode +
				", proportion=" + proportion +
				", accessProportion=" + accessProportion  +
				", accessPersonsCount=" + accessPersonsCount  +
				'}';
	}
}
