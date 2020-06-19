package com.github.edu.modular.edu.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.github.edu.modular.edu.model.SysRoleMenu;
import org.springframework.stereotype.Service;
import com.github.edu.modular.edu.service.ISysRoleMenuService;


/**
 * sys_role_menuService
 *
 * @author Monkey
 * @Date 2020-05-28 09:36:33
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class SysRoleMenuServiceImpl extends ServiceImpl<BaseMapper<SysRoleMenu>,SysRoleMenu> implements ISysRoleMenuService {
}
