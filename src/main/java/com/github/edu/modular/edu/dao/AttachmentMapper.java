package com.github.edu.modular.edu.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.edu.modular.edu.model.Attachment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 附件 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2020-04-19
 */
@Transactional
@Component
public interface AttachmentMapper extends BaseMapper<Attachment> {

}
