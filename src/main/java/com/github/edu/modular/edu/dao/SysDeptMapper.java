package com.github.edu.modular.edu.dao;

import com.github.edu.modular.edu.model.SysDept;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 部门-部门管理基础信息表 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2020-05-28
 */
@Transactional
@Component
public interface SysDeptMapper extends BaseMapper<SysDept> {

}
