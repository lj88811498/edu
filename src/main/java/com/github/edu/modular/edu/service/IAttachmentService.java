package com.github.edu.modular.edu.service;
import com.baomidou.mybatisplus.service.IService;
import com.github.edu.modular.edu.model.Attachment;

import java.io.File;

/**
 * attachmentService
 *
 * @author Monkey
 * @Date 2020-04-19 13:20:14
 */
public interface IAttachmentService extends IService<Attachment> {

    /**
     * 通过文件保存
     * @param f
     * @return
     */
    Attachment fileSave(File f, String code) throws Exception;
}
