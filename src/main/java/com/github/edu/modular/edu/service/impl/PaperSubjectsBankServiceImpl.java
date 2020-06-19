package com.github.edu.modular.edu.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.github.edu.modular.edu.model.PaperSubjectsBank;
import org.springframework.stereotype.Service;
import com.github.edu.modular.edu.service.IPaperSubjectsBankService;


/**
 * paper_subjects_bankService
 *
 * @author Monkey
 * @Date 2020-05-15 11:40:24
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class PaperSubjectsBankServiceImpl extends ServiceImpl<BaseMapper<PaperSubjectsBank>,PaperSubjectsBank> implements IPaperSubjectsBankService {
}
