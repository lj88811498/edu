package com.github.edu.modular.edu.dao;

import com.github.edu.modular.edu.model.SysMenu;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2020-05-28
 */
@Transactional
@Component
public interface SysMenuMapper extends BaseMapper<SysMenu> {

}
