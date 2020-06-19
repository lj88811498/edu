package com.github.edu.modular.edu.model.vo;

import com.github.edu.modular.edu.model.StudyPlan;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 学习计划（章节）
 */
@Data
public class StudyPlanVo {
	@ApiModelProperty("考试基本信息对象")
	private StudyPlan studyPlan;
	@ApiModelProperty("章节列表")
	private List<ChapterDetailVo> chapters;
}
