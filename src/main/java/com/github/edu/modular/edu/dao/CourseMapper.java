package com.github.edu.modular.edu.dao;

import com.github.edu.modular.edu.model.Course;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 课程管理 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2020-05-27
 */
@Transactional
@Component
public interface CourseMapper extends BaseMapper<Course> {

}
