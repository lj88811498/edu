package com.github.edu.modular.edu.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.github.edu.modular.edu.model.vo.ChapterVo;
import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 学习计划
 * </p>
 *
 * @author Monkey
 * @since 2020-05-21
 */
@ApiModel
@Data
public class StudyPlan extends Model<StudyPlan> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "study_plan_id", type = IdType.AUTO)
    private Integer studyPlanId;
    /**
     * 学习计划名称
     */
    @ApiModelProperty("学习计划名称")
    private String studyPlanName;
    /**
     * 学习计划完成时间
     */
    @ApiModelProperty("学习计划完成时间")
    private Date studyPlanFinishTime;
    /**
     * 学习计划描述
     */
    @ApiModelProperty("学习计划描述")
    private String studyPlanDesc;
    /**
     * 学习计划封面图片
     */
    @ApiModelProperty("学习计划封面图片")
    private String studyPlanImg;
    /**
     * 学习计划学分
     */
    @ApiModelProperty("学习计划学分")
    private Integer studyPlanCredit;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date studyPlanCreateTime;
    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date studyPlanUpdateTime;
    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private Integer studyPlanCreateBy;
    /**
     * 修改人
     */
    @ApiModelProperty("修改人")
    private Integer studyPlanUpdateBy;
    /**
     * 是否删除：0否1是
     */
    @ApiModelProperty("是否删除：0否1是")
    private Integer studyPlanIsDelete;
    /**
     * 达到课程学时：学员达到学习时长 0 否 1 是
     */
    @ApiModelProperty("达到课程学时：学员达到学习时长 0 否 1 是")
    private Integer studyPlanAchieveHours;
    /**
     * 通过课程考试：学员达到学习时长，并通过课程考试 0 否 1 是
     */
    @ApiModelProperty("通过课程考试：学员达到学习时长，并通过课程考试 0 否 1 是")
    private Integer studyPlanAdoptHours;
    /**
     * 课程学习进度从零开始计算，已学过课程需在本计划中重新学习 0 否 1 是
     */
    @ApiModelProperty("课程学习进度从零开始计算，已学过课程需在本计划中重新学习 0 否 1 是")
    private Integer studyPlanRelearn;
    /**
     * 消息提醒cron表达式
     */
    @ApiModelProperty("消息提醒cron表达式")
    private String studyPlanRemindCron;
    /**
     * 章节
     */
    @ApiModelProperty("章节")
    private String studyPlanChapter;
    /**
     * 1 待发布 2进行中 3 已完成
     */
    @ApiModelProperty("1 待发布 2进行中 3 已完成")
    private String studyPlanStatus;
    /**
     * 发布时间
     */
    @ApiModelProperty("发布时间")
    private Date studyPlanPushTime;
    /**
     * 类型 0 普通学习计划 1自动分发计划
     */
    @ApiModelProperty("类型 0 普通学习计划 1自动分发计划")
    private Integer studyPlanType;
    /**
     * 学习天数
     */
    @ApiModelProperty("学习天数")
    @TableField(exist = false)
    private Long studyDay;
    /**
     * 创建人名称
     */
    @ApiModelProperty("创建人名称")
    @TableField(exist = false)
    private String studyPlanCreateByName;
    @ApiModelProperty("学员id列表")
    @TableField(exist = false)
    private List<Integer> userIds;
    @ApiModelProperty("章节列表")
    @TableField(exist = false)
    private List<ChapterVo>  chapters;

    @Override
    protected Serializable pkVal() {
        return this.studyPlanId;
    }
}
