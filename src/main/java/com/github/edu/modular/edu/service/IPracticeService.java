package com.github.edu.modular.edu.service;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.github.edu.modular.edu.model.Practice;
import com.github.edu.modular.edu.model.PracticeStatistics;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <li>文件名称: 题目名称</li>
 * <li>文件描述: 练习库 服务接口</li>
 * <li>版权所有: 版权所有© 2005-2017</li>
 * <li>公 司: 贝奇达</li>
 * <li>内容摘要: 无</li>
 * <li>其他说明:无</li>
 * <li>完成日期： 2020-05-10</li>
 * <li>修改记录: 无</li>
 * @version 产品版本
 * @author monkey
 */
public interface IPracticeService extends IService<Practice> {
    //查询练习的用户答题情况
    List<Practice> queryPracticeByUser(Page page, Integer practiceId,String userName,Integer deptId);
    //查询练习的答题情况
    List<PracticeStatistics> queryPracticeStatistics(Integer practiceId,Integer subjectsBankId,String subjectsType);
}
