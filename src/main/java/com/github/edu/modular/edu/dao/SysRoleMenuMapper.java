package com.github.edu.modular.edu.dao;

import com.github.edu.modular.edu.model.SysRoleMenu;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 角色菜单表 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2020-05-28
 */
@Transactional
@Component
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

}
