package com.github.edu.modular.edu.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class PracticeStatistics {
	//题目数量
	private Integer totalNum;
	//作对数量
	private Integer correctNum;
	//一次性作对数量
	private Integer onceCorrectNum;
	//已坐人数
	private Integer doPeopleNum;
}
