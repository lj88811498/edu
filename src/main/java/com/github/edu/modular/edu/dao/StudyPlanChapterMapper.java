package com.github.edu.modular.edu.dao;

import com.github.edu.modular.edu.model.StudyPlanChapter;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 学习计划章节 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2020-05-23
 */
@Transactional
@Component
public interface StudyPlanChapterMapper extends BaseMapper<StudyPlanChapter> {

}
