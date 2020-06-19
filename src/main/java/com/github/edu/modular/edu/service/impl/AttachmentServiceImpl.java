package com.github.edu.modular.edu.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.edu.modular.edu.model.Attachment;
import com.github.edu.modular.edu.service.IAttachmentService;
import com.luhuiguo.fastdfs.domain.StorePath;
import com.luhuiguo.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.UUID;


/**
 * attachmentService
 *
 * @author Monkey
 * @Date 2020-04-19 13:20:14
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AttachmentServiceImpl extends ServiceImpl<BaseMapper<Attachment>,Attachment> implements IAttachmentService {

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @Override
    public Attachment fileSave(File f, String code) throws Exception {
        String fileCode = UUID.randomUUID().toString();
        String newFilename = fileCode + "." + FilenameUtils.getExtension(f.getName());
        StorePath storePath = fastFileStorageClient.uploadFile(FileUtils.readFileToByteArray(f), newFilename);

        Attachment attachment1 = new Attachment();
        attachment1.setAttachmentUrl(storePath.getFullPath());
        attachment1.setAttachmentCode(code);
        attachment1.setAttachmentFileCode(fileCode.replaceAll("-", ""));
        attachment1.setAttachmentDownloadUrl(("attachment/play/download/filecode/" + fileCode).replaceAll("-", ""));
        attachment1.setAttachmentName(f.getName());
        attachment1.setAttachmentType("1");

        return attachment1;
    }
}
