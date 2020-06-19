package com.github.edu.modular.edu.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.edu.modular.edu.model.UserAnswer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <li>文件名称: 题目名称</li>
 * <li>文件描述: 用户答案 Mapper 接口</li>
 * <li>版权所有: 版权所有© 2005-2017</li>
 * <li>公 司: 贝奇达</li>
 * <li>内容摘要: 无</li>
 * <li>其他说明:无</li>
 * <li>完成日期： 2020-05-10</li>
 * <li>修改记录: 无</li>
 * @version 产品版本
 * @author monkey
 */
@Repository
public interface UserAnswerMapper extends BaseMapper<UserAnswer> {


    /**
     * 查询批量用户
     * @param list
     * @return
     */
    List<Map> selectUsers(@Param("list") List<Integer> list);
}