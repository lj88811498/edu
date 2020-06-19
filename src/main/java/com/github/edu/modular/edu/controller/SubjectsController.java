package com.github.edu.modular.edu.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.github.edu.core.base.controller.BaseController;
import com.github.edu.core.common.constant.factory.PageFactory;
import com.github.edu.modular.edu.model.Attachment;
import com.github.edu.modular.edu.model.Subjects;
import com.github.edu.modular.edu.model.SubjectsAnswer;
import com.github.edu.modular.edu.service.IAttachmentService;
import com.github.edu.modular.edu.service.ISubjectsAnswerService;
import com.github.edu.modular.edu.service.ISubjectsService;
import com.github.edu.modular.edu.util.ExceptionUtil;
import com.github.edu.modular.edu.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <li>文件名称: 题目名称</li>
 * <li>文件描述: 题目 前端控制器</li>
 * <li>版权所有: 版权所有© 2005-2017</li>
 * <li>公 司: 贝奇达</li>
 * <li>内容摘要: 无</li>
 * <li>其他说明:无</li>
 * <li>完成日期： 2020-05-10</li>
 * <li>修改记录: 无</li>
 *
 * @author monkey
 * @version 版本号
 */
@RestController
@RequestMapping("/subjects")
@Api(value = "题目接口(完成)", description = "题目接口(完成)")
public class SubjectsController extends BaseController {

    @Autowired
    private ISubjectsService subjectsService;

    @Autowired
    private ISubjectsAnswerService subjectsAnswerService;

    @Autowired
    private IAttachmentService attachmentService;

    /**
     * 新增题库名称
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增题库名称（完成）",
            notes = "新增题库名称（完成）、\n\r" +
                    "subjectsName: 题目名称\n\r" +
                    "subjectsAttachmentCode: 题目对应附件code\n\r" +
                    "subjectsType: 题型:1单选2多选3判断4填空5问答\n\r" +
                    "subjectsSureAnswer: 答案（判断题时：1正确0错误，其他为空）\n\r" +
                    "subjectsAnalysis: 题干解析\n\r" +
                    "subjectsCreateBy: 创建人id\n\r" +
                    "analysisAttachmentCode: 题干解析对应附件code\n\r" +
                    "============================================\n\r" +
                    "============================================\n\r" +
                    "subjectsAnswerCode: 答案编号（ABCD）\n\r" +
                    "subjectsAnswerSure: 是否正确：1正确0错误\n\r" +
                    "subjectsAnswerName: 答案\n\r" +
                    "attachmentCode: 附件code\n\r"
    )
    public Object add(@RequestBody Subjects subjects){

        R r = new R();
        try {
            if (StringUtils.isNotBlank(subjects.getSubjectsAttachmentCode())) {
                Attachment attachment = attachmentService.selectOne(new EntityWrapper<Attachment>()
                        .eq("attachment_code", subjects.getSubjectsAttachmentCode()));
                if (attachment != null) {
                    subjects.setSubjectsNameImgUrl(attachment.getAttachmentDownloadUrl());
                }
            }
            if (StringUtils.isNotBlank(subjects.getAnalysisAttachmentCode())) {
                Attachment attachment = attachmentService.selectOne(new EntityWrapper<Attachment>()
                        .eq("attachment_code", subjects.getAnalysisAttachmentCode()));
                if (attachment != null) {
                    subjects.setSubjectsAnalysisImgUrl(attachment.getAttachmentDownloadUrl());
                }
            }
            subjects.insert();
            Integer subjectsId = subjects.getSubjectsId();
            List<SubjectsAnswer> subjectsAnswers = subjects.getSubjectsAnswers();
            if (subjectsAnswers.size() > 0) {
                subjectsAnswers.forEach(s -> {
                    s.setSubjectsId(subjectsId);
                    if (StringUtils.isNotBlank(s.getAttachmentCode())) {
                        Attachment attachment = attachmentService.selectOne(new EntityWrapper<Attachment>()
                                .eq("attachment_code", s.getAttachmentCode()));
                        if (attachment != null) {
                            s.setSubjectsAnswerNameImgUrl(attachment.getAttachmentDownloadUrl());
                        }
                    }
                });
                subjectsAnswerService.insertBatch(subjectsAnswers);
            }

        } catch (Exception e) {
            r = ExceptionUtil.getException(e);
        }

        return r;
    }

    /**
     * 修改题库名称
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改题库名称（完成）",
            notes = "修改题库名称（完成）、\n\r\n" +
                    "subjectsId: 题目id\n\r\n" +
                    "subjectsName: 题目名称\n\r\n" +
                    "subjectsAttachmentCode: 题目对应附件code\n\r\n" +
                    "subjectsType: 题型:1单选2多选3判断4填空5问答\n\r\n" +
                    "subjectsSureAnswer: 答案（判断题时：1正确0错误，其他为空）\n\r\n" +
                    "subjectsAnalysis: 题干解析\n\r\n" +
                    "subjectsCreateBy: 创建人id\n\r\n" +
                    "analysisAttachmentCode: 题干解析对应附件code\n\r\n" +
                    "============================================\n\r\n" +
                    "============================================\n\r\n" +
                    "subjectsAnswerCode: 答案编号（ABCD）\n\r\n" +
                    "subjectsAnswerSure: 是否正确：1正确0错误\n\r\n" +
                    "subjectsAnswerName: 答案\n\r\n" +
                    "attachmentCode: 附件code\n\r\n"
    )
    public Object update(@RequestBody Subjects subjects){

        R r = new R();
        try {
            if (subjects.getSubjectsId() != null) {
                subjects.setSubjectsUpdateTime(new Date());

                if (StringUtils.isNotBlank(subjects.getSubjectsAttachmentCode())) {
                    Attachment attachment = attachmentService.selectOne(new EntityWrapper<Attachment>()
                            .eq("attachment_code", subjects.getSubjectsAttachmentCode()));
                    if (attachment != null) {
                        subjects.setSubjectsNameImgUrl(attachment.getAttachmentDownloadUrl());
                    }
                }
                if (StringUtils.isNotBlank(subjects.getAnalysisAttachmentCode())) {
                    Attachment attachment = attachmentService.selectOne(new EntityWrapper<Attachment>()
                            .eq("attachment_code", subjects.getAnalysisAttachmentCode()));
                    if (attachment != null) {
                        subjects.setSubjectsAnalysisImgUrl(attachment.getAttachmentDownloadUrl());
                    }
                }
                subjects.updateById();

                List<SubjectsAnswer> subjectsAnswers = subjects.getSubjectsAnswers();
                if (subjectsAnswers.size() > 0) {
                    subjectsAnswers.forEach(s -> {
                        if (StringUtils.isNotBlank(s.getAttachmentCode())) {
                            Attachment attachment = attachmentService.selectOne(new EntityWrapper<Attachment>()
                                    .eq("attachment_code", s.getAttachmentCode()));
                            if (attachment != null) {
                                s.setSubjectsAnswerNameImgUrl(attachment.getAttachmentDownloadUrl());
                            }
                        }
                        s.updateById();
                    });
                }

            } else {
                r = new R(null, "主键不能为空！", R.FAIL);
            }

        } catch (Exception e) {
            r = ExceptionUtil.getException(e);
        }

        return r;
    }


    /**
     * 删除题目
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value = "删除题目（完成）", notes = "删除题目（完成）")
    public Object delete(@ApiParam(value = "题目id", required = true)
                         @RequestParam(value = "subjectsId") Integer subjectsId) {

        R r = new R();
        try {

            Subjects sb = new Subjects();
            sb.setSubjectsBankId(subjectsId);
            sb.setSubjectsIsDelete(1);
            sb.updateById();
        } catch (Exception e) {
            r = ExceptionUtil.getException(e);
        }

        return r;
    }


    /**
     * 获取题目列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取题目列表（完成）", notes = "获取题目列表（完成）")
    public Object list(@ApiParam(value = "每页条数")@RequestParam(value = "size", defaultValue = "10", required = false) int size,
                       @ApiParam(value = "当前页")@RequestParam(value = "curPage", defaultValue = "1", required = false) int curPage,
                       @ApiParam(value = "题目名称")@RequestParam(value = "subjectsName", defaultValue = "", required = false) String subjectsName) {

        R r = new R();
        try {
            EntityWrapper<Subjects> ew = new EntityWrapper<>();
            if (StringUtils.isNotBlank(subjectsName)) {
                ew.like("subjects_name", subjectsName);
            }
            ew.eq("subjects_is_delete", 0);

            Page<Subjects> page = new PageFactory<Subjects>().defaultPage2(size, curPage);
            Page<Subjects> mapPage = subjectsService.selectPage(page, ew);
            List<Subjects> records = mapPage.getRecords();
            records.forEach(s -> {

                List<SubjectsAnswer> subjectsAnswers = subjectsAnswerService.selectList(new EntityWrapper<SubjectsAnswer>()
                        .eq("subjects_id", s.getSubjectsId()));

                s.setSubjectsAnswers(subjectsAnswers);
            });

            r.setData(mapPage);
        } catch (Exception e) {
            r = ExceptionUtil.getException(e);
        }

        return r;

    }

    /**
     * 获取题目列表
     */
    @RequestMapping(value = "/listByType", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据题库id获取题目列表（完成）", notes = "根据题库id获取题目列表（完成）")
    public Object list(@ApiParam(value = "题库id")@RequestParam(value = "subjectsBankId", defaultValue = "", required = false) String subjectsBankId) {

        R r = new R();
        try {
            EntityWrapper<Subjects> ew = new EntityWrapper<>();
            if (StringUtils.isNotBlank(subjectsBankId)) {
                ew.eq("subjects_bank_id", subjectsBankId);
            }
            ew.eq("subjects_is_delete", 0);

            List<Subjects> list = subjectsService.selectList(ew);
//            list.forEach(s -> {
//
//                List<SubjectsAnswer> subjectsAnswers = subjectsAnswerService.selectList(new EntityWrapper<SubjectsAnswer>()
//                        .eq("subjects_id", s.getSubjectsId()));
//
//                s.setSubjectsAnswers(subjectsAnswers);
//            });

            r.setData(list);
        } catch (Exception e) {
            r = ExceptionUtil.getException(e);
        }

        return r;

    }
}
