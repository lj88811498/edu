package com.github.edu.modular.edu.model.vo;

import com.github.edu.modular.edu.model.Course;
import com.github.edu.modular.edu.model.Exam;
import com.github.edu.modular.edu.model.StudyPlanCourse;
import com.github.edu.modular.edu.model.StudyPlanExam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 学习计划（章节）
 */
@Data
public class ChapterDetailVo {
	@ApiModelProperty("课程id列表")
	private List<Course> courses;
	@ApiModelProperty("考试id列表")
	private List<Exam> exams;
}
