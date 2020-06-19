package com.github.edu.modular.edu.service.impl;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.edu.modular.edu.dao.PracticeMapper;
import com.github.edu.modular.edu.model.Practice;
import com.github.edu.modular.edu.model.PracticeStatistics;
import com.github.edu.modular.edu.service.IPracticeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <li>文件名称: 题目名称</li>
 * <li>文件描述: 练习库 服务接口实现类</li>
 * <li>版权所有: 版权所有© 2005-2017</li>
 * <li>公 司: 贝奇达</li>
 * <li>内容摘要: 无</li>
 * <li>其他说明:无</li>
 * <li>完成日期： 2020-05-10</li>
 * <li>修改记录: 无</li>
 * @version 产品版本
 * @author monkey
 */
@Service
@Transactional
public class PracticeServiceImpl extends ServiceImpl<PracticeMapper, Practice> implements IPracticeService {

        @Autowired
        private PracticeMapper practiceMapper;

        /**
         * 查询练习的用户答题情况
         * @param practiceId
         * @return
         */
        @Override
        public List<Practice> queryPracticeByUser(Page page, Integer practiceId,String userName,Integer deptId) {
                return practiceMapper.queryPracticeByUser(page,practiceId,userName,deptId);
        }

        /**
         * 查询练习的答题情况
         * @param practiceId
         * @return
         */
        @Override
        public List<PracticeStatistics> queryPracticeStatistics(Integer practiceId,Integer subjectsBankId,String subjectsType) {
                List<PracticeStatistics> list = new ArrayList<>();
                List<Integer> ids = null;
                if(null != subjectsBankId){
                        ids = new ArrayList<>();
                        ids.add(subjectsBankId);
                }
                if(StringUtils.isNotBlank(subjectsType)){
                        PracticeStatistics singleChoice = practiceMapper.queryPracticeInfo(practiceId, subjectsType, ids);
                        list.add(singleChoice);
                        return list;
                }
                PracticeStatistics singleChoice = practiceMapper.queryPracticeInfo(practiceId, "1", ids);
                PracticeStatistics multipleChoice = practiceMapper.queryPracticeInfo(practiceId, "2", ids);
                PracticeStatistics judge = practiceMapper.queryPracticeInfo(practiceId, "3", ids);
                PracticeStatistics fillBlanks = practiceMapper.queryPracticeInfo(practiceId, "4", ids);
                list.add(singleChoice);
                list.add(multipleChoice);
                list.add(judge);
                list.add(fillBlanks);
                return list;
        }


}
