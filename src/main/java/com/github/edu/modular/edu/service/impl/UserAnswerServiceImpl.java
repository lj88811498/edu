package com.github.edu.modular.edu.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.edu.modular.edu.dao.UserAnswerMapper;
import com.github.edu.modular.edu.model.UserAnswer;
import com.github.edu.modular.edu.service.IUserAnswerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <li>文件名称: 题目名称</li>
 * <li>文件描述: 用户答案 服务接口实现类</li>
 * <li>版权所有: 版权所有© 2005-2017</li>
 * <li>公 司: 贝奇达</li>
 * <li>内容摘要: 无</li>
 * <li>其他说明:无</li>
 * <li>完成日期： 2020-05-10</li>
 * <li>修改记录: 无</li>
 *
 * @author monkey
 * @version 产品版本
 */
@Service
@Transactional
public class UserAnswerServiceImpl extends ServiceImpl<UserAnswerMapper, UserAnswer> implements IUserAnswerService {

    @Autowired
    private UserAnswerMapper userAnswerMapper;

    /**
     * 查询批量用户
     *
     * @param userIds
     * @return
     */
    @Override
    public String selectUsers(String userIds) {

        StringBuffer name = new StringBuffer();
        if (StringUtils.isNotBlank(userIds)) {
            List list = new ArrayList();
            String[] ids = userIds.split(",");
            for (String id : ids) {
                list.add(id);
            }
            List<Map> maps = userAnswerMapper.selectUsers(list);

            if (maps.size() > 0) {
                for (Map map : maps) {
                    if (StringUtils.isNotBlank(name.toString())) {
                        name.append(",");
                    }
                    Object username = map.get("username");
                    if (username != null) {
                        name.append(username.toString());
                    }
                }

            }
        }

        return name.toString();
    }
}
