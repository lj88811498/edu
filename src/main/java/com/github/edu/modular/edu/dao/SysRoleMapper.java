package com.github.edu.modular.edu.dao;

import com.github.edu.modular.edu.model.SysRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2020-05-28
 */
@Transactional
@Component
public interface SysRoleMapper extends BaseMapper<SysRole> {

}
