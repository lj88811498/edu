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
import com.github.edu.modular.edu.model.StudyPlanChapter;
import com.github.edu.modular.edu.service.IStudyPlanChapterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * study_plan_chapter控制器
 *
 * @author lzq
 * @Date 2020-05-23 22:32:30
 */
@Controller
@RequestMapping("/studyPlanChapter")
@Api(value = "StudyPlanChapter-controller", description = "study_plan_chapter")
public class StudyPlanChapterController extends BaseController {

    private String PREFIX = "/edu/studyPlanChapter/";

    @Autowired
    private IStudyPlanChapterService studyPlanChapterService;

    /**
     * 跳转到study_plan_chapter首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "studyPlanChapter.html";
    }

    /**
     * 跳转到添加study_plan_chapter
     */
    @RequestMapping("/studyPlanChapter_add")
    public String studyPlanChapterAdd() {
        return PREFIX + "studyPlanChapter_add.html";
    }

    /**
     * 跳转到修改study_plan_chapter
     */
    @RequestMapping(value = "/studyPlanChapter_update/{studyPlanChapterId}", method = RequestMethod.GET)
    @ApiOperation(value = "编辑study_plan_chapter", notes = "编辑study_plan_chapter")
    public String studyPlanChapterUpdate(@PathVariable Integer studyPlanChapterId, Model model) {
        StudyPlanChapter studyPlanChapter = studyPlanChapterService.selectById(studyPlanChapterId);
        model.addAttribute("item",studyPlanChapter);
        LogObjectHolder.me().set(studyPlanChapter);
        return PREFIX + "studyPlanChapter_edit.html";
    }

    /**
     * 获取study_plan_chapter列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取study_plan_chapter列表", notes = "获取study_plan_chapter列表")
    public Object list(String condition) {
        return studyPlanChapterService.selectList(null);
    }

    /**
     * 新增study_plan_chapter
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增study_plan_chapter", notes = "新增study_plan_chapter")
    public Object add(StudyPlanChapter studyPlanChapter) {
        studyPlanChapterService.insert(studyPlanChapter);
        return SUCCESS_TIP;
    }

    /**
     * 删除study_plan_chapter
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除study_plan_chapter", notes = "删除study_plan_chapter")
    public Object delete(@RequestParam Integer studyPlanChapterId) {
        studyPlanChapterService.deleteById(studyPlanChapterId);
        return SUCCESS_TIP;
    }

    /**
     * 修改study_plan_chapter
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改study_plan_chapter", notes = "修改study_plan_chapter")
    public Object update(StudyPlanChapter studyPlanChapter) {
        studyPlanChapterService.updateById(studyPlanChapter);
        return SUCCESS_TIP;
    }

    /**
     * study_plan_chapter详情
     */
    @RequestMapping(value = "/detail/{studyPlanChapterId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "study_plan_chapter详情", notes = "study_plan_chapter详情")
    public Object detail(@PathVariable("studyPlanChapterId") Integer studyPlanChapterId) {
        return studyPlanChapterService.selectById(studyPlanChapterId);
    }
}
