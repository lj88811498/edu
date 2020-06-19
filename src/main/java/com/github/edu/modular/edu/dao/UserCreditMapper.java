package com.github.edu.modular.edu.dao;

import com.github.edu.modular.edu.model.UserCredit;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户学分 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2020-05-18
 */
@Transactional
@Component
public interface UserCreditMapper extends BaseMapper<UserCredit> {

}
