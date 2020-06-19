package com.github.edu.modular.edu.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <li>文件名称: 题目名称</li>
 * <li>文件描述: 练习库</li>
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
public class Practice extends Model<Practice> {

    private static final long serialVersionUID = 1L;

	@ApiModelProperty("主键id")
	@TableId("practice_id")
	private Integer practiceId;
    /**
     * 练习名字
     */
	@ApiModelProperty("练习名字")
	@TableField("practice_name")
	private String practiceName;
    /**
     * 状态：1启用2禁用
     */
	@ApiModelProperty("状态：1启用2禁用")
	@TableField("practice_status")
	private String practiceStatus;
	/**
	 * 发布状态：1已创建 2已发布
	 */
	@ApiModelProperty("1创建 2发布")
	@TableField("practice_publish_status")
	private String practicePublishStatus;
    /**
     * 学员集合
     */
	@ApiModelProperty("学员id集合")
	@TableField(exist = false)
	private List<Integer> practiceUsers;
    /**
     * 题库id
     */
	@ApiModelProperty("题库id集合")
	@TableField("practice_subjects_bank_ids")
	private String practiceSubjectsBankIds;
    /**
     * 次数
     */
	@ApiModelProperty("次数")
	@TableField("practice_subjects_times")
	private Integer practiceSubjectsTimes;
	/**
	 * 题目数量
	 */
	@ApiModelProperty("题目数量")
	@TableField(exist = false)
	private Integer subjectNum;
	/**
	 * 答题数量
	 */
	@ApiModelProperty("答题数量")
	@TableField(exist = false)
	private Integer answerNum;
	/**
	 * 答对数量
	 */
	@ApiModelProperty("答对数量")
	@TableField(exist = false)
	private Integer correctNum;
	/**
	 * 正确率
	 */
	@ApiModelProperty("正确率")
	@TableField(exist = false)
	private String accuracy;
	/**
	 * 最近练习时间
	 */
	@ApiModelProperty("最近练习时间")
	@TableField(exist = false)
	private Date lastUpdateTime;
    /**
     * 创建时间
     */
	@ApiModelProperty("创建时间")
	@TableField("practice_create_time")
	private Date practiceCreateTime;
    /**
     * 修改时间
     */
	@ApiModelProperty("修改时间")
	@TableField("practice_update_time")
	private Date practiceUpdateTime;
    /**
     * 创建人
     */
	@TableField("practice_create_by")
	private Integer practiceCreateBy;
    /**
     * 修改人
     */
	@TableField("practice_update_by")
	private Integer practiceUpdateBy;
    /**
     * 是否删除：0否1是
     */
	@ApiModelProperty("是否删除：0否1是")
	@TableField("practice_is_delete")
	private Integer practiceIsDelete;

	@Override
	protected Serializable pkVal() {
		return this.practiceId;
	}

}
