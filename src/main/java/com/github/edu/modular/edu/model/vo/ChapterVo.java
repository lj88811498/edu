package com.github.edu.modular.edu.model.vo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 学习计划（章节）
 */
@Data
public class ChapterVo {
	@ApiModelProperty("课程id列表")
	private List<Integer> courses;
	@ApiModelProperty("考试id列表")
	private List<Integer> exams;
}
