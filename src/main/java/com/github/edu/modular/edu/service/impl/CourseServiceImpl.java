package com.github.edu.modular.edu.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.github.edu.modular.edu.model.Course;
import org.springframework.stereotype.Service;
import com.github.edu.modular.edu.service.ICourseService;


/**
 * courseService
 *
 * @author lzq
 * @Date 2020-05-27 22:13:42
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class CourseServiceImpl extends ServiceImpl<BaseMapper<Course>,Course> implements ICourseService {
}
