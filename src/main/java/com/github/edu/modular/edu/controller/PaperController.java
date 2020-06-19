package com.github.edu.modular.edu.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import com.github.edu.core.base.controller.BaseController;
import com.github.edu.core.common.constant.factory.PageFactory;
import com.github.edu.modular.edu.model.*;
import com.github.edu.modular.edu.model.vo.PaperSubjectsBankVo;
import com.github.edu.modular.edu.model.vo.PaperVo;
import com.github.edu.modular.edu.model.vo.SubjectsVo;
import com.github.edu.modular.edu.service.*;
import com.github.edu.modular.edu.util.ExceptionUtil;
import com.github.edu.modular.edu.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <li>文件名称: 题目名称</li>
 * <li>文件描述: 卷子 前端控制器</li>
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
@RequestMapping("/paper")
@Api(value = "卷子接口", description = "卷子接口（完成）")
public class PaperController extends BaseController {


    @Autowired
    private IPaperService paperService;

    @Autowired
    private IPaperSubjectsService paperSubjectsService;

    @Autowired
    private IPaperSubjectsAnswerService paperSubjectsAnswerService;

    @Autowired
    private ISubjectsAnswerService subjectsAnswerService;

    @Autowired
    private IPaperSubjectsBankService paperSubjectsBankService;

    @Autowired
    private IUserAnswerService userAnswerService;

    /**
     * 新增试卷
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增试卷（完成）",
            notes = "新增试卷（完成）、\n\r" +
                    "paperName: 试卷名称\n\r" +
                    "paperType: 出题方式:1固定出题2随机出题\n\r" +
                    "paperSingle: 单选分值\n\r" +
                    "paperMore: 多选分值\n\r" +
                    "paperJudge: 判断题分值\n\r" +
                    "paperPack: 填空题分值\n\r" +
                    "paperFaq: 问答分值\n\r" +
                    "paperCreateBy: 创建人\n\r"+
                    "subjectsVo: 题目集（固定出题方式才有）\n\r" +
                    "paperSubjectsBankVo: 题库集（随机出题方式才有）\n\r"
    )
    public Object add(@RequestBody PaperVo paperVo){

        R r = new R();
        try {
            String paperType = paperVo.getPaperType();
            Paper paper = new Paper();
            BeanUtils.copyProperties(paperVo, paper);
            paper.insert();
            int peperId = paper.getPaperId();
            if (paperType.equals("1")) {
                List<SubjectsVo> subjectsVo = paperVo.getSubjectsVo();
                List<PaperSubjects> paperSubjects = new ArrayList<>();
                List<PaperSubjectsAnswer> paperSubjectsAnswers = new ArrayList<>();
                subjectsVo.forEach(s -> {
                    PaperSubjects paperSubjects1 = new PaperSubjects();
                    paperSubjects1.setPaperId(peperId);
                    paperSubjects1.setSubjectsId(s.getSubjectsId());
                    paperSubjects1.setSubjectsType(s.getSubjectsType());
                    paperSubjects1.setPaperSubjectsGrade(s.getPaperSubjectsGrade());
                    paperSubjects1.setSubjectsName(s.getSubjectsName());
                    paperSubjects.add(paperSubjects1);

                    //添加题目答案
                    List<SubjectsAnswer> answers = subjectsAnswerService.selectList(new EntityWrapper<SubjectsAnswer>()
                            .eq("subjects_id", s.getSubjectsId()));
                    answers.forEach(a -> {
                        PaperSubjectsAnswer paperSubjectsAnswer = new PaperSubjectsAnswer();
                        paperSubjectsAnswer.setSubjectsId(a.getSubjectsId());
                        paperSubjectsAnswer.setPaperId(peperId);
                        paperSubjectsAnswer.setPaperSubjectsAnswerCode(a.getSubjectsAnswerCode());
                        paperSubjectsAnswer.setPaperSubjectsAnswerSure(a.getSubjectsAnswerSure());
                        paperSubjectsAnswer.setPaperSubjectsAnswerName(a.getSubjectsAnswerName());
                        paperSubjectsAnswer.setPaperSubjectsAnswerNameImgUrl(a.getSubjectsAnswerNameImgUrl());
                        paperSubjectsAnswers.add(paperSubjectsAnswer);
                    });

                });

                paperSubjectsService.insertBatch(paperSubjects);
                paperSubjectsAnswerService.insertBatch(paperSubjectsAnswers);
            } else if (paperType.equals("2")) {
                List<PaperSubjectsBankVo> paperSubjectsBankVo = paperVo.getPaperSubjectsBankVo();
                List<PaperSubjectsBank> paperSubjectsBanks = getPaperSubjectsBanks(paperSubjectsBankVo, peperId);
                paperSubjectsBankService.insertBatch(paperSubjectsBanks);
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
    public Object update(@RequestBody PaperVo paperVo){

        R r = new R();
        try {
            String paperType = paperVo.getPaperType();
            Paper paper = null;
            if (paperVo != null && paperVo.getPaperId() != null) {
                paper = paperService.selectById(paperVo.getPaperId());
            } else {
                return new R(null, "主键不能为空！", R.FAIL);
            }
            Paper paper2 = new Paper();
            BeanUtils.copyProperties(paperVo, paper2);
            String nextVersion = Integer.parseInt(paper.getPaperVersion()) + 1 + "";
            paper2.setPaperVersion(nextVersion);
            paper2.updateById();

            int peperId = paper.getPaperId();
            if (paperType.equals("1")) {
                List<SubjectsVo> subjectsVo = paperVo.getSubjectsVo();
                List<PaperSubjects> paperSubjects = new ArrayList<>();
                List<PaperSubjectsAnswer> paperSubjectsAnswers = new ArrayList<>();
                subjectsVo.forEach(s -> {
                    PaperSubjects paperSubjects1 = new PaperSubjects();
                    paperSubjects1.setPaperSubjectsVersion(nextVersion);
                    paperSubjects1.setPaperId(peperId);
                    paperSubjects1.setSubjectsId(s.getSubjectsId());
                    paperSubjects1.setSubjectsType(s.getSubjectsType());
                    paperSubjects1.setPaperSubjectsGrade(s.getPaperSubjectsGrade());
                    paperSubjects1.setSubjectsName(s.getSubjectsName());
                    paperSubjects.add(paperSubjects1);

                    //添加题目答案
                    List<SubjectsAnswer> answers = subjectsAnswerService.selectList(new EntityWrapper<SubjectsAnswer>()
                            .eq("subjects_id", s.getSubjectsId()));
                    answers.forEach(a -> {
                        PaperSubjectsAnswer paperSubjectsAnswer = new PaperSubjectsAnswer();
                        paperSubjectsAnswer.setSubjectsId(a.getSubjectsId());
                        paperSubjectsAnswer.setPaperId(peperId);
                        paperSubjectsAnswer.setPaperSubjectsAnswerSure(a.getSubjectsAnswerSure());
                        paperSubjectsAnswer.setPaperSubjectsAnswerCode(a.getSubjectsAnswerCode());
                        paperSubjectsAnswer.setPaperSubjectsAnswerName(a.getSubjectsAnswerName());
                        paperSubjectsAnswer.setPaperSubjectsAnswerNameImgUrl(a.getSubjectsAnswerNameImgUrl());
                        paperSubjectsAnswer.setPaperSubjectsAnswerVersion(nextVersion);
                        paperSubjectsAnswers.add(paperSubjectsAnswer);
                    });
                });

                paperSubjectsService.insertBatch(paperSubjects);
                paperSubjectsAnswerService.insertBatch(paperSubjectsAnswers);
            } else if (paperType.equals("2")) {
                List<PaperSubjectsBankVo> paperSubjectsBankVo = paperVo.getPaperSubjectsBankVo();
                List<PaperSubjectsBank> paperSubjectsBanks = getPaperSubjectsBanks(paperSubjectsBankVo, peperId);
                paperSubjectsBankService.insertBatch(paperSubjectsBanks);
            }
        } catch (Exception e) {
            r = ExceptionUtil.getException(e);
        }

        return r;
    }


    /**
     * 删除卷子
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value = "删除卷子（完成）", notes = "删除卷子（完成）")
    public Object delete(@ApiParam(value = "卷子id", required = true)
                         @RequestParam(value = "paperId") Integer paperId) {

        R r = new R();
        try {
            Paper paper = new Paper();
            paper.setPaperId(paperId);
            paper.setPaperIsDelete(1);
            paper.updateById();

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
                       @ApiParam(value = "卷子名称")@RequestParam(value = "paperName", defaultValue = "", required = false) String paperName) {

        R r = new R();
        try {
            Page<Paper> page = new PageFactory<Paper>().defaultPage2(size, curPage);
            Page<Paper> page1 = paperService.selectPage(page, new EntityWrapper<Paper>().like("paper_name", paperName));
            List<Paper> papers = page1.getRecords();
            if (papers.size() > 0) {
                papers.forEach(paperVo -> {
                    //设置分数
                    String paperType = paperVo.getPaperType();
                    Integer createBy = paperVo.getPaperCreateBy();
                    String userName = userAnswerService.selectUsers(createBy + "");
                    paperVo.setPaperCreateByName(userName);
                    if (paperType.equals("1")) {
                        paperVo.setPaperTotalGrade(100);
                        List<PaperSubjects> paperSubjects = paperSubjectsService.selectList(new EntityWrapper<PaperSubjects>()
                                .eq("paper_id", paperVo.getPaperId()));
                        paperVo.setSubjectCount(paperSubjects.size());
                    } else if (paperType.equals("2")){
                        List<PaperSubjectsBank> paperSubjectsBanks = paperSubjectsBankService.selectList(new EntityWrapper<PaperSubjectsBank>()
                                .eq("paper_id", paperVo.getPaperId()));
                        String single = paperVo.getPaperSingle();
                        String more = paperVo.getPaperMore();
                        String judge = paperVo.getPaperJudge();
                        String pack = paperVo.getPaperPack();
                        String faq = paperVo.getPaperFaq();
                        paperVo.setSubjectCount(0);
                        paperVo.setPaperTotalGrade(0);
                        paperSubjectsBanks.forEach(ps -> {
                            int singleCount = Integer.parseInt(StringUtils.isNotBlank(ps.getPaperSubjectsBankSingle())? ps.getPaperSubjectsBankSingle() : "0");
                            int moreCount = Integer.parseInt(StringUtils.isNotBlank(ps.getPaperSubjectsBankMore())? ps.getPaperSubjectsBankMore() : "0");
                            int judgeCount = Integer.parseInt(StringUtils.isNotBlank(ps.getPaperSubjectsBankJudge())?ps.getPaperSubjectsBankJudge(): "0");
                            int packCount = Integer.parseInt(StringUtils.isNotBlank(ps.getPaperSubjectsBankPack())?ps.getPaperSubjectsBankPack(): "0");
                            int faqCount = Integer.parseInt(StringUtils.isNotBlank(ps.getPaperSubjectsBankFaq())?ps.getPaperSubjectsBankFaq(): "0");

                            int totoal = singleCount + moreCount + judgeCount + packCount + faqCount;

                            paperVo.setSubjectCount(paperVo.getSubjectCount() + totoal);
//
                            int totalGrade = singleCount * Integer.parseInt(single)
                                            + moreCount * Integer.parseInt(more)
                                            + judgeCount * Integer.parseInt(judge)
                                            + packCount * Integer.parseInt(pack)
                                            + faqCount * Integer.parseInt(faq);

                            paperVo.setPaperTotalGrade(paperVo.getPaperTotalGrade() + totalGrade);
//
                        });
                    }

                });
            }
            r.setData(page1);
        } catch (Exception e) {
            r = ExceptionUtil.getException(e);
        }

        return r;
    }

    /**
     * 封装随机题库数据
     * @param paperSubjectsBankVo
     * @param peperId
     * @return
     */
    private  List<PaperSubjectsBank> getPaperSubjectsBanks(List<PaperSubjectsBankVo> paperSubjectsBankVo, Integer peperId) {
        List<PaperSubjectsBank> paperSubjectsBanks = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(paperSubjectsBankVo) && paperSubjectsBankVo.size() > 0) {
            paperSubjectsBankVo.forEach(p -> {
                PaperSubjectsBank paperSubjectsBank = new PaperSubjectsBank();
                BeanUtils.copyProperties(p, paperSubjectsBank);
                paperSubjectsBank.setPaperId(peperId);
                paperSubjectsBanks.add(paperSubjectsBank);
            });
        }
        return paperSubjectsBanks;
    }

}
