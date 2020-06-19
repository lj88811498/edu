package com.github.edu.modular.edu.dao;

import com.github.edu.modular.edu.model.UserPractice;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2020-05-16
 */
@Transactional
@Component
public interface UserPracticeMapper extends BaseMapper<UserPractice> {

}
