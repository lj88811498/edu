package com.github.edu.modular.edu.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.github.edu.modular.edu.model.StudyPlanUser;
import org.springframework.stereotype.Service;
import com.github.edu.modular.edu.service.IStudyPlanUserService;


/**
 * study_plan_userService
 *
 * @author lzq
 * @Date 2020-05-21 22:41:16
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class StudyPlanUserServiceImpl extends ServiceImpl<BaseMapper<StudyPlanUser>,StudyPlanUser> implements IStudyPlanUserService {
}
