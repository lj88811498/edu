package com.github.edu.modular.edu.dao;

import com.github.edu.modular.edu.model.SysUserOmni;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 呼叫中心-用户座席关系表 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2020-05-28
 */
@Transactional
@Component
public interface SysUserOmniMapper extends BaseMapper<SysUserOmni> {

}
