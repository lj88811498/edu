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
import com.github.edu.modular.edu.model.StudyPlanCourse;
import com.github.edu.modular.edu.service.IStudyPlanCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * study_plan_course控制器
 *
 * @author lzq
 * @Date 2020-05-21 22:41:16
 */
@Controller
@RequestMapping("/studyPlanCourse")
@Api(value = "StudyPlanCourse-controller", description = "study_plan_course")
public class StudyPlanCourseController extends BaseController {

    private String PREFIX = "/edu/studyPlanCourse/";

    @Autowired
    private IStudyPlanCourseService studyPlanCourseService;

    /**
     * 跳转到study_plan_course首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "studyPlanCourse.html";
    }

    /**
     * 跳转到添加study_plan_course
     */
    @RequestMapping("/studyPlanCourse_add")
    public String studyPlanCourseAdd() {
        return PREFIX + "studyPlanCourse_add.html";
    }

    /**
     * 跳转到修改study_plan_course
     */
    @RequestMapping(value = "/studyPlanCourse_update/{studyPlanCourseId}", method = RequestMethod.GET)
    @ApiOperation(value = "编辑study_plan_course", notes = "编辑study_plan_course")
    public String studyPlanCourseUpdate(@PathVariable Integer studyPlanCourseId, Model model) {
        StudyPlanCourse studyPlanCourse = studyPlanCourseService.selectById(studyPlanCourseId);
        model.addAttribute("item",studyPlanCourse);
        LogObjectHolder.me().set(studyPlanCourse);
        return PREFIX + "studyPlanCourse_edit.html";
    }

    /**
     * 获取study_plan_course列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取study_plan_course列表", notes = "获取study_plan_course列表")
    public Object list(String condition) {
        return studyPlanCourseService.selectList(null);
    }

    /**
     * 新增study_plan_course
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增study_plan_course", notes = "新增study_plan_course")
    public Object add(StudyPlanCourse studyPlanCourse) {
        studyPlanCourseService.insert(studyPlanCourse);
        return SUCCESS_TIP;
    }

    /**
     * 删除study_plan_course
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除study_plan_course", notes = "删除study_plan_course")
    public Object delete(@RequestParam Integer studyPlanCourseId) {
        studyPlanCourseService.deleteById(studyPlanCourseId);
        return SUCCESS_TIP;
    }

    /**
     * 修改study_plan_course
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改study_plan_course", notes = "修改study_plan_course")
    public Object update(StudyPlanCourse studyPlanCourse) {
        studyPlanCourseService.updateById(studyPlanCourse);
        return SUCCESS_TIP;
    }

    /**
     * study_plan_course详情
     */
    @RequestMapping(value = "/detail/{studyPlanCourseId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "study_plan_course详情", notes = "study_plan_course详情")
    public Object detail(@PathVariable("studyPlanCourseId") Integer studyPlanCourseId) {
        return studyPlanCourseService.selectById(studyPlanCourseId);
    }
}
