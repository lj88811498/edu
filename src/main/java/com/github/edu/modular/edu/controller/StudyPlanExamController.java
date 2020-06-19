package com.github.edu.modular.edu.controller;

import com.github.edu.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.edu.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.edu.modular.edu.model.StudyPlanExam;
import com.github.edu.modular.edu.service.IStudyPlanExamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * study_plan_exam控制器
 *
 * @author lzq
 * @Date 2020-05-21 22:41:16
 */
@Controller
@RequestMapping("/studyPlanExam")
@Api(value = "StudyPlanExam-controller", description = "study_plan_exam")
public class StudyPlanExamController extends BaseController {

    private String PREFIX = "/edu/studyPlanExam/";

    @Autowired
    private IStudyPlanExamService studyPlanExamService;

    /**
     * 跳转到study_plan_exam首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "studyPlanExam.html";
    }

    /**
     * 跳转到添加study_plan_exam
     */
    @RequestMapping("/studyPlanExam_add")
    public String studyPlanExamAdd() {
        return PREFIX + "studyPlanExam_add.html";
    }

    /**
     * 跳转到修改study_plan_exam
     */
    @RequestMapping(value = "/studyPlanExam_update/{studyPlanExamId}", method = RequestMethod.GET)
    @ApiOperation(value = "编辑study_plan_exam", notes = "编辑study_plan_exam")
    public String studyPlanExamUpdate(@PathVariable Integer studyPlanExamId, Model model) {
        StudyPlanExam studyPlanExam = studyPlanExamService.selectById(studyPlanExamId);
        model.addAttribute("item",studyPlanExam);
        LogObjectHolder.me().set(studyPlanExam);
        return PREFIX + "studyPlanExam_edit.html";
    }

    /**
     * 获取study_plan_exam列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取study_plan_exam列表", notes = "获取study_plan_exam列表")
    public Object list(String condition) {
        return studyPlanExamService.selectList(null);
    }

    /**
     * 新增study_plan_exam
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增study_plan_exam", notes = "新增study_plan_exam")
    public Object add(StudyPlanExam studyPlanExam) {
        studyPlanExamService.insert(studyPlanExam);
        return SUCCESS_TIP;
    }

    /**
     * 删除study_plan_exam
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除study_plan_exam", notes = "删除study_plan_exam")
    public Object delete(@RequestParam Integer studyPlanExamId) {
        studyPlanExamService.deleteById(studyPlanExamId);
        return SUCCESS_TIP;
    }

    /**
     * 修改study_plan_exam
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改study_plan_exam", notes = "修改study_plan_exam")
    public Object update(StudyPlanExam studyPlanExam) {
        studyPlanExamService.updateById(studyPlanExam);
        return SUCCESS_TIP;
    }

    /**
     * study_plan_exam详情
     */
    @RequestMapping(value = "/detail/{studyPlanExamId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "study_plan_exam详情", notes = "study_plan_exam详情")
    public Object detail(@PathVariable("studyPlanExamId") Integer studyPlanExamId) {
        return studyPlanExamService.selectById(studyPlanExamId);
    }
}
