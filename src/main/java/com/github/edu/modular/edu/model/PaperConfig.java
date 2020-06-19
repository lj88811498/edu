package com.github.edu.modular.edu.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <li>文件名称: 题目名称</li>
 * <li>文件描述: 卷子-题库</li>
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
@TableName("paper_config")
public class PaperConfig extends Model<PaperConfig> {

    private static final long serialVersionUID = 1L;

	@TableId("paper_config_id")
	private Integer paperConfigId;
    /**
     * 卷子id
     */
	@TableField("paper_id")
	private Integer paperId;
    /**
     * 题库id（随机抽题）/题目id（固定抽题）
     */
	@TableField("paper_config_obj")
	private Integer paperConfigObj;
    /**
     * 单选个数（随机抽题）
     */
	@TableField("paper_config_single")
	private String paperConfigSingle;
    /**
     * 多选个数（随机抽题）
     */
	@TableField("paper_config_more")
	private String paperConfigMore;
    /**
     * 判断题个数（随机抽题）
     */
	@TableField("paper_config_judge")
	private String paperConfigJudge;
    /**
     * 填空题个数（随机抽题）
     */
	@TableField("paper_config_pack")
	private String paperConfigPack;
    /**
     * 问答个数（随机抽题）
     */
	@TableField("paper_config_faq")
	private String paperConfigFaq;
    /**
     * 创建时间
     */
	@TableField("paper_config_create_time")
	private Date paperConfigCreateTime;
    /**
     * 修改时间
     */
	@TableField("paper_config_update_time")
	private Date paperConfigUpdateTime;
    /**
     * 创建人
     */
	@TableField("paper_config_create_by")
	private Integer paperConfigCreateBy;
    /**
     * 修改人
     */
	@TableField("paper_config_update_by")
	private Integer paperConfigUpdateBy;

	@Override
	protected Serializable pkVal() {
		return this.paperConfigId;
	}

}
