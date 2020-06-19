package com.github.edu.modular.edu.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.github.edu.modular.edu.model.SysUserRole;
import org.springframework.stereotype.Service;
import com.github.edu.modular.edu.service.ISysUserRoleService;


/**
 * sys_user_roleService
 *
 * @author Monkey
 * @Date 2020-05-28 09:36:34
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class SysUserRoleServiceImpl extends ServiceImpl<BaseMapper<SysUserRole>,SysUserRole> implements ISysUserRoleService {
}
