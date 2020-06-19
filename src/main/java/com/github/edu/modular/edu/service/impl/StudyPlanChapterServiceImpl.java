package com.github.edu.modular.edu.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.github.edu.modular.edu.model.StudyPlanChapter;
import org.springframework.stereotype.Service;
import com.github.edu.modular.edu.service.IStudyPlanChapterService;


/**
 * study_plan_chapterService
 *
 * @author lzq
 * @Date 2020-05-23 22:32:30
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class StudyPlanChapterServiceImpl extends ServiceImpl<BaseMapper<StudyPlanChapter>,StudyPlanChapter> implements IStudyPlanChapterService {
}
