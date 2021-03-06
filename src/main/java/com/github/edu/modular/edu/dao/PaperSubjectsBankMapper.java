package com.github.edu.modular.edu.dao;

import com.github.edu.modular.edu.model.PaperSubjectsBank;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 卷子题库 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2020-05-15
 */
@Transactional
@Component
public interface PaperSubjectsBankMapper extends BaseMapper<PaperSubjectsBank> {

}
