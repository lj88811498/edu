package com.github.edu.modular.edu.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.edu.core.base.controller.BaseController;
import com.github.edu.modular.edu.model.Attachment;
import com.github.edu.modular.edu.service.IAttachmentService;
import com.github.edu.modular.edu.util.ExceptionUtil;
import com.github.edu.modular.edu.util.FileUtil;
import com.github.edu.modular.edu.util.MultipartFileUtil;
import com.github.edu.modular.edu.util.R;
import com.luhuiguo.fastdfs.service.FastFileStorageClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;

/**
 * attachment控制器
 *
 * @author Monkey
 * @Date 2020-04-19 13:20:14
 */
@RestController
@RequestMapping("/attachment")
@Api(value = "Attachment-controller", description = "附件（完成）")
public class AttachmentController extends BaseController {


    @Autowired
    private IAttachmentService attachmentService;

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    /**
     * 下载，只支持小文件,适合播放类接口
     * @param response
     * @param filecode
     * @throws Exception
     */
    @GetMapping("/play/download/filecode/{filecode}")
    @ApiOperation(value = "下载附件（完成）", notes = "下载附件（完成）")
    public void downloadAttachment(HttpServletResponse response, @PathVariable String filecode) throws Exception{
        Attachment attachment = attachmentService.selectOne(new EntityWrapper<Attachment>()
                .eq("attachment_file_code", filecode)
        );
        if(Objects.isNull(attachment)){
            throw new Exception("不是有效的文件地址");
        }
        String attachmentUrl = attachment.getAttachmentUrl();
        String group = attachmentUrl.substring(0, attachmentUrl.indexOf("/"));
        String path = attachmentUrl.substring(attachmentUrl.indexOf("/") + 1);
        //通过直接下载（大文件会导致超时）
        FileUtil.downloadFile(response, attachment.getAttachmentName(), fastFileStorageClient.downloadFile(group, path));
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "上传工单附件（完成）", notes = "上传工单附件（完成）")
    public Object uploadFile( @ApiParam("工单附件") MultipartFile file,
                              @ApiParam(value = "附件类型：1.工单 2.题目")@RequestParam(value = "attachmentType", defaultValue = "2", required = false)String attachmentType){
        R r = new R();
        try {
            if (file != null) {

                List<Attachment> attachments = new ArrayList<>();
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                File file1 = MultipartFileUtil.multipartFileToFile(file);
                Attachment attachment = attachmentService.fileSave(file1, uuid);
                attachment.setAttachmentType(attachmentType);
                attachments.add(attachment);
                //删除临时文件
                MultipartFileUtil.delteTempFile(file1);

                attachmentService.insertBatch(attachments);
                Map map = new HashMap<>();
                map.put("attachmentCode", uuid);
                r.setData(map);

            } else {
                r = new R(null,"附件不能为空！", R.FAIL);
            }

        } catch (Exception e) {
            r = ExceptionUtil.getException(e);
        }

        return r;
    }
}
