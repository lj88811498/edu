package com.github.edu.modular.edu.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.github.edu.modular.edu.model.UserPractice;
import org.springframework.stereotype.Service;
import com.github.edu.modular.edu.service.IUserPracticeService;


/**
 * user_practiceService
 *
 * @author lzq
 * @Date 2020-05-16 19:01:29
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class UserPracticeServiceImpl extends ServiceImpl<BaseMapper<UserPractice>,UserPractice> implements IUserPracticeService {
}
