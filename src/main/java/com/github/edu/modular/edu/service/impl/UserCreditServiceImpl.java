package com.github.edu.modular.edu.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.github.edu.modular.edu.model.UserCredit;
import org.springframework.stereotype.Service;
import com.github.edu.modular.edu.service.IUserCreditService;


/**
 * user_creditService
 *
 * @author monkey
 * @Date 2020-05-18 23:10:55
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class UserCreditServiceImpl extends ServiceImpl<BaseMapper<UserCredit>,UserCredit> implements IUserCreditService {
}
