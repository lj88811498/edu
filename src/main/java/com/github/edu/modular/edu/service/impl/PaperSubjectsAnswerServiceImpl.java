package com.github.edu.modular.edu.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.github.edu.modular.edu.model.PaperSubjectsAnswer;
import org.springframework.stereotype.Service;
import com.github.edu.modular.edu.service.IPaperSubjectsAnswerService;


/**
 * paper_subjects_answerService
 *
 * @author Monkey
 * @Date 2020-05-15 10:39:30
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class PaperSubjectsAnswerServiceImpl extends ServiceImpl<BaseMapper<PaperSubjectsAnswer>,PaperSubjectsAnswer> implements IPaperSubjectsAnswerService {
}
