package com.github.edu.modular.edu.dao;

import com.github.edu.modular.edu.model.StudyPlanUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 学习计划--用户 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2020-05-21
 */
@Transactional
@Component
public interface StudyPlanUserMapper extends BaseMapper<StudyPlanUser> {

}
