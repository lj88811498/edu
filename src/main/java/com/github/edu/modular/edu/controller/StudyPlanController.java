package com.github.edu.modular.edu.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.edu.core.base.controller.BaseController;
import com.github.edu.core.util.DateUtil;
import com.github.edu.modular.edu.model.*;
import com.github.edu.modular.edu.model.vo.ChapterDetailVo;
import com.github.edu.modular.edu.model.vo.ChapterVo;
import com.github.edu.modular.edu.model.vo.StudyPlanVo;
import com.github.edu.modular.edu.service.*;
import com.github.edu.modular.edu.util.ExceptionUtil;
import com.github.edu.modular.edu.util.R;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.edu.core.log.LogObjectHolder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * study_plan控制器
 *
 * @author lzq
 * @Date 2020-05-21 22:41:16
 */
@Controller
@RequestMapping("/studyPlan")
@Api(value = "学习计划", description = "学习计划")
public class StudyPlanController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(StudyPlanController.class);
    @Autowired
    private IStudyPlanService studyPlanService;
    @Autowired
    private IUserAnswerService userAnswerService;
    @Autowired
    private IStudyPlanChapterService studyPlanChapterService;
    @Autowired
    private IStudyPlanCourseService studyPlanCourseService;
    @Autowired
    private IStudyPlanExamService studyPlanExamService;
    @Autowired
    private ICourseService courseService;
    @Autowired
    private IExamService examService;

    /**
     * 获取学习计划列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取学习计划列表", notes = "获取学习计划列表")
    public R<StudyPlan> list(@ApiParam(value = "每页条数")@RequestParam(value = "size", defaultValue = "10", required = false) int size,
                       @ApiParam(value = "当前页")@RequestParam(value = "curPage", defaultValue = "1", required = false) int curPage,
                       @ApiParam(value = "学习名称")@RequestParam(value = "studyPlanName", required = false) String studyPlanName,
                       @ApiParam(value = "类型")@RequestParam(value = "studyPlanType", required = false) Integer studyPlanType,
                       @ApiParam(value = "状态")@RequestParam(value = "studyPlanStatus", required = false) Integer studyPlanStatus) {
        R r = new R();
        try {
            EntityWrapper<StudyPlan> wrapper = new EntityWrapper();
            if(StringUtils.isNotBlank(studyPlanName)){
                wrapper.like("study_plan_name",studyPlanName);
            }
            if(null != studyPlanType){
                wrapper.eq("study_plan_type",studyPlanType);
            }
            if(null != studyPlanStatus){
                wrapper.eq("study_plan_status",studyPlanStatus);
            }
            List<StudyPlan> studyPlans = studyPlanService.selectList(wrapper);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            if(studyPlans.isEmpty()){
                for (StudyPlan studyPlan : studyPlans) {
                    if(null != studyPlan.getStudyPlanPushTime()){
                        long daySub = DateUtil.getDaySub(format.format(studyPlan.getStudyPlanPushTime()), format.format(new Date()));
                        studyPlan.setStudyDay(daySub);
                    }else{
                        studyPlan.setStudyDay(0L);
                    }
                    if(null != studyPlan.getStudyPlanCreateBy()){
                        String userName = userAnswerService.selectUsers(studyPlan.getStudyPlanCreateBy().toString());
                        studyPlan.setStudyPlanCreateByName(userName);
                    }
                }
            }
            r.setData(studyPlans);
        }catch (Exception e){
            logger.error("获取学习计划列表失败",e);
            r = ExceptionUtil.getException(e);
        }
        return r;
    }

    /**
     * 新增学习计划
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增学习计划", notes = "新增学习计划")
    public R add(@RequestBody StudyPlan studyPlan) {
        R r = new R();
        r.setCode(R.FAIL);
        try {
            studyPlanService.insert(studyPlan);
            logger.info("保存章节");
            List<ChapterVo> chapters = studyPlan.getChapters();
            if (CollectionUtil.isEmpty(chapters)) {
                r.setMsg("请选择章节");
            }
            for (int i=0;i<chapters.size();i++) {
                StudyPlanChapter studyPlanChapter = new StudyPlanChapter();
                studyPlanChapter.setStudyPlanChapterName(i+"章节");
                studyPlanChapter.setStudyPlanId(studyPlan.getStudyPlanId());
                studyPlanChapterService.insert(studyPlanChapter);
                List<Integer> courses = chapters.get(i).getCourses();
                if(CollectionUtil.isNotEmpty(courses)){
                    for (Integer courseId : courses) {
                        StudyPlanCourse studyPlanCourse = new StudyPlanCourse();
                        studyPlanCourse.setStudyPlanCourseId(courseId);
                        studyPlanCourse.setStudyPlanId(studyPlanChapter.getId());
                        studyPlanCourseService.insert(studyPlanCourse);
                    }
                }
                List<Integer> exams = chapters.get(i).getExams();
                if(CollectionUtil.isNotEmpty(exams)){
                    for (Integer examId : exams) {
                        StudyPlanExam studyPlanExam = new StudyPlanExam();
                        studyPlanExam.setStudyPlanExamId(examId);
                        studyPlanExam.setStudyPlanId(studyPlanChapter.getId());
                        studyPlanExamService.insert(studyPlanExam);
                    }
                }
            }
            r.setCode(R.SUCCESS);
        }catch (Exception e){
            logger.error("新增学习计划列表失败",e);
            r = ExceptionUtil.getException(e);
        }
        return r;
    }

    /**
     * 删除学习计划
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除学习计划", notes = "删除学习计划")
    public R delete(@RequestParam(value = "ids",required = true) List<Integer> ids) {
        R r = new R();
        try {
            if(null == ids || ids.isEmpty()){
                r.setCode(R.FAIL);
                r.setMsg("请选择需要删除的数据");
                return r;
            }
            studyPlanService.deleteBatchIds(ids);
        }catch (Exception e){
            logger.error("删除练习失败:",e);
            r = ExceptionUtil.getException(e);
        }
        return r;
    }

    /**
     * 修改学习计划
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改学习计划", notes = "修改学习计划")
    public R update(StudyPlan studyPlan) {
        R r = new R();
        r.setCode(R.FAIL);
        try {
            studyPlanService.updateById(studyPlan);
            logger.info("保存章节");
            List<ChapterVo> chapters = studyPlan.getChapters();
            if (CollectionUtil.isEmpty(chapters)) {
                r.setMsg("请选择章节");
            }
            //查询章节
            EntityWrapper<StudyPlanChapter> chapterWrapper = new EntityWrapper<>();
            chapterWrapper.eq("study_plan_id",studyPlan.getStudyPlanId());
            List<StudyPlanChapter> studyPlanChapters = studyPlanChapterService.selectList(chapterWrapper);
            if(CollectionUtil.isNotEmpty(studyPlanChapters)){
                for (StudyPlanChapter studyPlanChapter : studyPlanChapters) {
                    EntityWrapper<StudyPlanCourse> courseWrapper = new EntityWrapper<>();
                    courseWrapper.eq("study_plan_id",studyPlanChapter.getId());
                    studyPlanCourseService.delete(courseWrapper);
                    EntityWrapper<StudyPlanExam> examWrapper= new EntityWrapper<>();
                    examWrapper.eq("study_plan_id",studyPlanChapter.getId());
                    studyPlanExamService.delete(examWrapper);
                    studyPlanChapterService.deleteById(studyPlanChapter.getId());
                }
            }
            //添加章节信息
            for (int i=0;i<chapters.size();i++) {
                StudyPlanChapter studyPlanChapter = new StudyPlanChapter();
                studyPlanChapter.setStudyPlanChapterName(i+"章节");
                studyPlanChapter.setStudyPlanId(studyPlan.getStudyPlanId());
                studyPlanChapterService.insert(studyPlanChapter);
                List<Integer> courses = chapters.get(i).getCourses();
                if(CollectionUtil.isNotEmpty(courses)){
                    for (Integer courseId : courses) {
                        StudyPlanCourse studyPlanCourse = new StudyPlanCourse();
                        studyPlanCourse.setStudyPlanCourseId(courseId);
                        studyPlanCourse.setStudyPlanId(studyPlanChapter.getId());
                        studyPlanCourseService.insert(studyPlanCourse);
                    }
                }
                List<Integer> exams = chapters.get(i).getExams();
                if(CollectionUtil.isNotEmpty(exams)){
                    for (Integer examId : exams) {
                        StudyPlanExam studyPlanExam = new StudyPlanExam();
                        studyPlanExam.setStudyPlanExamId(examId);
                        studyPlanExam.setStudyPlanId(studyPlanChapter.getId());
                        studyPlanExamService.insert(studyPlanExam);
                    }
                }
            }
            r.setCode(R.SUCCESS);
        }catch (Exception e){
            logger.error("修改学习计划失败",e);
            r = ExceptionUtil.getException(e);
        }
        return r;
    }

    /**
     * 学习计划详情
     */
    @RequestMapping(value = "/detail/{studyPlanId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "学习计划详情", notes = "学习计划详情")
    public R<StudyPlanVo> detail(@PathVariable("studyPlanId") Integer studyPlanId) {
        R r = new R();
        try {
            StudyPlanVo studyPlanVo = new StudyPlanVo();
            StudyPlan studyPlan = studyPlanService.selectById(studyPlanId);
            studyPlanVo.setStudyPlan(studyPlan);
            //查询章节
            EntityWrapper<StudyPlanChapter> chapterWrapper = new EntityWrapper<>();
            chapterWrapper.eq("study_plan_id",studyPlan.getStudyPlanId());
            List<StudyPlanChapter> studyPlanChapters = studyPlanChapterService.selectList(chapterWrapper);
            if(CollectionUtil.isEmpty(studyPlanChapters)){
                r.setData(studyPlanVo);
                return r;
            }
            for (StudyPlanChapter studyPlanChapter : studyPlanChapters) {
                ChapterDetailVo chapterDetailVo = new ChapterDetailVo();
                EntityWrapper<StudyPlanCourse> courseWrapper = new EntityWrapper<>();
                courseWrapper.eq("study_plan_id",studyPlanChapter.getId());
                List<StudyPlanCourse> studyPlanCourses = studyPlanCourseService.selectList(courseWrapper);
                if(CollectionUtil.isNotEmpty(studyPlanCourses)){
                    List<Course> courses = new ArrayList<>();
                    for (StudyPlanCourse studyPlanCours : studyPlanCourses) {
                        Course course = courseService.selectById(studyPlanCours.getId());
                        courses.add(course);
                    }
                    chapterDetailVo.setCourses(courses);
                }
                EntityWrapper<StudyPlanExam> examWrapper= new EntityWrapper<>();
                examWrapper.eq("study_plan_id",studyPlanChapter.getId());
                List<StudyPlanExam> studyPlanExams = studyPlanExamService.selectList(examWrapper);
                if(CollectionUtil.isNotEmpty(studyPlanExams)){
                    List<Exam> exams = new ArrayList<>();
                    for (StudyPlanExam studyPlanExam : studyPlanExams) {
                        Exam exam = examService.selectById(studyPlanExam.getId());
                        exams.add(exam);
                    }
                    chapterDetailVo.setExams(exams);
                }
            }
        } catch (Exception e) {
            logger.error("修改学习计划失败", e);
            r = ExceptionUtil.getException(e);
        }
        return r;
    }
}
