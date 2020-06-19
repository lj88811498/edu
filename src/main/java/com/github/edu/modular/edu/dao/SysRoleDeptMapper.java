package com.github.edu.modular.edu.dao;

import com.github.edu.modular.edu.model.SysRoleDept;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 角色与部门对应关系   该表作废 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2020-05-28
 */
@Transactional
@Component
public interface SysRoleDeptMapper extends BaseMapper<SysRoleDept> {

}
