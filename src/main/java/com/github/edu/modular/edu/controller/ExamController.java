package com.github.edu.modular.edu.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.github.edu.core.base.controller.BaseController;
import com.github.edu.core.common.constant.factory.PageFactory;
import com.github.edu.modular.edu.model.*;
import com.github.edu.modular.edu.service.*;
import com.github.edu.modular.edu.util.ExceptionUtil;
import com.github.edu.modular.edu.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.NumberFormat;
import java.util.*;

/**
 * <li>文件名称: 题目名称</li>
 * <li>文件描述: 考试 前端控制器</li>
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
@RequestMapping("/exam")
@Api(value = "考试接口", description = "考试接口(完成)")
public class ExamController extends BaseController {

    @Autowired
    private IExamService examService;

    @Autowired
    private IAttachmentService attachmentService;

    @Autowired
    private IConfirmExamService confirmExamService;

    @Autowired
    private IUserAnswerService userAnswerService;

    @Autowired
    private ISubjectsAnswerService subjectsAnswerService;

    @Autowired
    private ISubjectsService subjectsService;

    /**
     * 新增试卷
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增考试（完成）",
            notes = "新增考试（完成）、\n\r" +
                    "paperId: 试卷id\n\r" +
                    "examName: 考试名称\n\r" +
                    "examStatus: 考试状态：1未发布2已发布未开始3进行中4已结束\n\r" +
                    "examStartTime: 考试开始时间\n\r" +
                    "examEndTime: 考试结束时间\n\r" +
                    "examTime: 答题时间（分钟）\n\r" +
                    "examTimes: 答题次数 \n\r" +
                    "examDesc: 考试须知 \n\r" +
                    "attachmentCode: 附件code \n\r" +
                    "examCredit: 通过学分 \n\r" +
                    "examIsOrder: 是否打乱试题顺序：0否1是 \n\r" +
                    "examIsOrderChoice: 是否打乱选择题选项顺序：0否1是 \n\r" +
                    "examReconnect: 重连次数，-1时表示不限制 \n\r" +
                    "examSubmit: 允许查看已提交答卷：1交卷后显示正确答案2考试结束后显示正确答案3手动公布正确答案 \n\r" +
                    "examGrade: 及格分数 \n\r" +
                    "examUsers: 学员集合 \n\r" +
                    "examCheckers: 阅卷人集合 \n\r" +
                    "examShowUser: 是否显示考生姓名：0否1是 \n\r" +
                    "examAutoPack: 是否填空题自动批阅时精准匹配答案：0否1是 \n\r" +
                    "examCreateBy: 创建人 \n\r"
    )
    public Object add(@RequestBody Exam exam){

        R r = new R();
        try {
            exam.setExamId(null);
            exam.setExamIndexImgUrl(null);
            String attachmentCode = exam.getAttachmentCode();
            Attachment attachment = attachmentService.selectOne(new EntityWrapper<Attachment>().eq("attachment_code", attachmentCode));
            if (attachment != null) {
                exam.setExamIndexImgUrl(attachment.getAttachmentDownloadUrl());
            }
            exam.setExamVersion("1");
            exam.insert();

            if (!exam.getExamStatus().equals("1")) {
                //已经发布了
                String examUsers = exam.getExamUsers();
                if (StringUtils.isNotBlank(examUsers)) {
                    String[] users = examUsers.split(",");
                    List<ConfirmExam> confirmExams = new ArrayList<>();
                    for (String str : users) {
                        ConfirmExam ce = new ConfirmExam();
                        ce.setConfirmExamCreateBy(exam.getExamCreateBy());
                        ce.setUserId(Integer.parseInt(str));
                        ce.setExamId(exam.getExamId());
                        ce.setPaperId(exam.getPaperId());
                        confirmExams.add(ce);
                    }
                    confirmExamService.insertBatch(confirmExams);
                }
            }
        } catch (Exception e) {
            r = ExceptionUtil.getException(e);
        }

        return r;
    }

    /**
     * 修改考试
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改考试（完成）",
            notes = "修改考试（完成）、\n\r" +
                    "paperId: 试卷id\n\r" +
                    "examName: 考试名称\n\r" +
                    "examStatus: 考试状态：1未发布2已发布未开始3进行中4已结束\n\r" +
                    "examStartTime: 考试开始时间\n\r" +
                    "examEndTime: 考试结束时间\n\r" +
                    "examTime: 答题时间（分钟）\n\r" +
                    "examTimes: 答题次数 \n\r" +
                    "examDesc: 考试须知 \n\r" +
                    "attachmentCode: 附件code \n\r" +
                    "examCredit: 通过学分 \n\r" +
                    "examIsOrder: 是否打乱试题顺序：0否1是 \n\r" +
                    "examIsOrderChoice: 是否打乱选择题选项顺序：0否1是 \n\r" +
                    "examReconnect: 重连次数，-1时表示不限制 \n\r" +
                    "examSubmit: 允许查看已提交答卷：1交卷后显示正确答案2考试结束后显示正确答案3手动公布正确答案 \n\r" +
                    "examGrade: 及格分数 \n\r" +
                    "examUsers: 学员集合 \n\r" +
                    "examCheckers: 阅卷人集合 \n\r" +
                    "examShowUser: 是否显示考生姓名：0否1是 \n\r" +
                    "examAutoPack: 是否填空题自动批阅时精准匹配答案：0否1是 \n\r" +
                    "examCreateBy: 创建人 \n\r"
    )
    public Object update(@RequestBody Exam exam){

        R r = new R();
        try {
            if (exam == null || exam.getExamId() == null) {
                return new R(null, "主键不能为空！", R.FAIL);
            }
            Exam exam1 = examService.selectById(exam.getExamId());
            if (exam1 != null ) {
                String attachmentCode = exam.getAttachmentCode();
                Attachment attachment = attachmentService.selectOne(new EntityWrapper<Attachment>().eq("attachment_code", attachmentCode));
                exam.setExamIndexImgUrl(null);
                if (attachment != null) {
                    exam.setExamIndexImgUrl(attachment.getAttachmentDownloadUrl());
                }
                exam.setExamUpdateTime(new Date());

                String nextVersion = Integer.parseInt(exam1.getExamVersion()) + 1 + "";
                exam.setExamVersion(nextVersion);
                exam.updateById();

                if (!exam.getExamStatus().equals("1")) {
                    //如果版本相同，就删除原来的
                    ConfirmExam confirmExam = new ConfirmExam();
                    confirmExam.setConfirmExamIsDelete(1);
                    confirmExamService.update(confirmExam, new EntityWrapper<ConfirmExam>()
                            .eq("exam_id", exam1.getExamId())
                            .where ("confirm_exam_version <=" + exam1.getExamVersion()));

                    //已经发布了
                    String examUsers = exam.getExamUsers();
                    if (StringUtils.isNotBlank(examUsers)) {
                        String[] users = examUsers.split(",");
                        List<ConfirmExam> confirmExams = new ArrayList<>();
                        for (String str : users) {
                            ConfirmExam ce = new ConfirmExam();
                            ce.setUserId(Integer.parseInt(str));
                            ce.setConfirmExamCreateBy(exam.getExamCreateBy());
                            ce.setExamId(exam.getExamId());
                            ce.setPaperId(exam.getPaperId());
                            ce.setConfirmExamVersion(nextVersion);
                            confirmExams.add(ce);
                        }
                        confirmExamService.insertBatch(confirmExams);
                    }
                }
            }


        } catch (Exception e) {
            r = ExceptionUtil.getException(e);
        }

        return r;
    }


    /**
     * 删除考试
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value = "删除考试（完成）", notes = "删除考试（完成）")
    public Object delete(@ApiParam(value = "考试id", required = true)
                         @RequestParam(value = "examId") Integer examId) {

        R r = new R();
        try {

            Exam exam = new Exam();
            exam.setExamId(examId);
            exam.setExamIsDelete(1);
            exam.setExamUpdateTime(new Date());
            exam.updateById();

        } catch (Exception e) {
            r = ExceptionUtil.getException(e);
        }

        return r;
    }


    /**
     * 获取考试列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取考试列表（完成）", notes = "获取考试列表（完成）")
    public Object list(@ApiParam(value = "每页条数")@RequestParam(value = "size", defaultValue = "10", required = false) int size,
                       @ApiParam(value = "当前页")@RequestParam(value = "curPage", defaultValue = "1", required = false) int curPage,
                       @ApiParam(value = "考试状态：1未发布2已发布未开始3进行中4已结束 0全部")@RequestParam(value = "examStatus", defaultValue = "0", required = false) String examStatus,
                       @ApiParam(value = "卷子名称")@RequestParam(value = "examName", defaultValue = "", required = false) String examName) {

        R r = new R();
        try {
            EntityWrapper<Exam> entityWrapper = new EntityWrapper();
            entityWrapper.like("exam_name", examName);
            if (!examStatus.equals("0")) {
                entityWrapper.eq("exam_status", examStatus);
            }
            Page page = new PageFactory<Exam>().defaultPage2(size, curPage);

            Page selectPage = examService.selectPage(page, entityWrapper);
            List<Exam> records = selectPage.getRecords();
            records.forEach(e -> {
                int allCount = 0;
                String status = e.getExamStatus();
                if (status.equals("1")) {
                    e.setProportion("-");
                } else {
                    EntityWrapper<ConfirmExam> ew = new EntityWrapper<ConfirmExam>();
                    ew.eq("confirm_exam_version",  e.getExamVersion());
                    ew.eq("exam_id", e.getExamId());
                    ew.eq("confirm_exam_is_delete", 0);
                    allCount = confirmExamService.selectCount(ew);
                    int accessCount = confirmExamService.selectCount(ew.notIn("confirm_exam_status", "1"));
                    String p = accessCount + "/" + allCount;
                    e.setProportion(p);
                }
                //通过人数
                String examUsers = e.getExamUsers();
                String[] users = examUsers.split(",");
                //及格分数
                String examGrade = e.getExamGrade();
                int count = 0;
                for (String user : users) {
                    List<UserAnswer> userAnswers = userAnswerService.selectList(new EntityWrapper<UserAnswer>()
                            .eq("exam_id", e.getExamId())
                            .eq("user_answer_version", e.getExamVersion())
                            .eq("user_id", user));
                    Map<String, Integer> map = new HashMap();
                    map.put("totalGrade", 0);
                    userAnswers.forEach(u -> {
                        //答案
                        String answer = u.getUserAnswerCode();
                        Subjects subjects = subjectsService.selectOne(new EntityWrapper<Subjects>().eq("subjects_id", u.getSubjectsId()));
                        if (subjects != null) {
                            String subjectsType = subjects.getSubjectsType();
                            //单选，判断，填空
                            if (subjectsType.equals("1") || subjectsType.equals("3")) {
                                SubjectsAnswer subjectsAnswer = subjectsAnswerService.selectOne(new EntityWrapper<SubjectsAnswer>()
                                        .eq("subjects_id", u.getSubjectsId())
                                        .eq("subjects_answer_code", answer));
                                if (subjectsAnswer != null && subjectsAnswer.getSubjectsAnswerSure().equals("1")) {
                                    map.put("totalGrade", map.get("totalGrade") + Integer.parseInt(StringUtils.isNotBlank(u.getUserAnswerGrade())? u.getUserAnswerGrade(): "0"));
                                }
                            } else if (subjectsType.equals("2")) {
                                //多选
                                List<SubjectsAnswer> subjectsAnswers = subjectsAnswerService.selectList(new EntityWrapper<SubjectsAnswer>()
                                        .eq("subjects_id", u.getSubjectsId())
                                        .eq("subjects_answer_sure", 1));
                                String code = "" ;
                                for (SubjectsAnswer sa : subjectsAnswers) {
                                    if (StringUtils.isNotBlank(code)) {
                                        code += "," + sa.getSubjectsAnswerCode();
                                    } else {
                                        code = sa.getSubjectsAnswerCode();
                                    }
                                }
                                List<UserAnswer> answers = userAnswerService.selectList(new EntityWrapper<UserAnswer>()
                                        .eq("exam_id", e.getExamId())
                                        .eq("subjects_id", u.getSubjectsId())
                                        .eq("user_answer_version", e.getExamVersion())
                                        .in("user_answer_code", code));
                                if (answers.size() == subjectsAnswers.size()) {
                                    map.put("totalGrade", map.get("totalGrade") + Integer.parseInt(StringUtils.isNotBlank(u.getUserAnswerGrade())? u.getUserAnswerGrade(): "0"));
                                }

                            }else if (subjectsType.equals("4")) {
                                //问答题
                                if (u.getUserAnswerIsSure().equals("1")) {
                                    map.put("totalGrade", map.get("totalGrade") + Integer.parseInt(StringUtils.isNotBlank(u.getUserAnswerGrade())? u.getUserAnswerGrade(): "0"));
                                } else {
                                    SubjectsAnswer subjectsAnswer = subjectsAnswerService.selectOne(new EntityWrapper<SubjectsAnswer>()
                                            .eq("subjects_id", u.getSubjectsId())
                                            .eq("subjects_answer_name", answer));
                                    if (subjectsAnswer != null && subjectsAnswer.getSubjectsAnswerSure().equals("1")) {
                                        map.put("totalGrade", map.get("totalGrade") + Integer.parseInt(StringUtils.isNotBlank(u.getUserAnswerGrade())? u.getUserAnswerGrade(): "0"));
                                    }
                                }
                            }else if (subjectsType.equals("5")) {
                                //问答题
                                if (u.getUserAnswerIsSure().equals("1")) {
                                    map.put("totalGrade", map.get("totalGrade") + Integer.parseInt(StringUtils.isNotBlank(u.getUserAnswerGrade())? u.getUserAnswerGrade(): "0"));
                                }
                            }
                        }
                    });
                    //判断是否及格
                    Integer totalGrade = map.get("totalGrade");
                    if (totalGrade >= Integer.parseInt(examGrade)) {
                        count ++;
                    }

                }
                //设置通过人数
                e.setAccessPersonsCount(count + "");
                //通过率
                NumberFormat numberFormat = NumberFormat.getInstance();
                // 设置精确到小数点后2位
                numberFormat.setMaximumFractionDigits(0);
                //此处不需要小数点
                String result = allCount == 0 ? "0" : numberFormat.format(count * 100/allCount );
                //设置通过率
                e.setAccessProportion(result);
            });

            r.setData(selectPage);

        } catch (Exception e) {
            r = ExceptionUtil.getException(e);
        }

        return r;
    }

}
