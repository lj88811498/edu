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
import com.github.edu.modular.edu.model.StudyPlanUser;
import com.github.edu.modular.edu.service.IStudyPlanUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * study_plan_user控制器
 *
 * @author lzq
 * @Date 2020-05-21 22:41:16
 */
@Controller
@RequestMapping("/studyPlanUser")
@Api(value = "StudyPlanUser-controller", description = "study_plan_user")
public class StudyPlanUserController extends BaseController {

    private String PREFIX = "/edu/studyPlanUser/";

    @Autowired
    private IStudyPlanUserService studyPlanUserService;

    /**
     * 跳转到study_plan_user首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "studyPlanUser.html";
    }

    /**
     * 跳转到添加study_plan_user
     */
    @RequestMapping("/studyPlanUser_add")
    public String studyPlanUserAdd() {
        return PREFIX + "studyPlanUser_add.html";
    }

    /**
     * 跳转到修改study_plan_user
     */
    @RequestMapping(value = "/studyPlanUser_update/{studyPlanUserId}", method = RequestMethod.GET)
    @ApiOperation(value = "编辑study_plan_user", notes = "编辑study_plan_user")
    public String studyPlanUserUpdate(@PathVariable Integer studyPlanUserId, Model model) {
        StudyPlanUser studyPlanUser = studyPlanUserService.selectById(studyPlanUserId);
        model.addAttribute("item",studyPlanUser);
        LogObjectHolder.me().set(studyPlanUser);
        return PREFIX + "studyPlanUser_edit.html";
    }

    /**
     * 获取study_plan_user列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取study_plan_user列表", notes = "获取study_plan_user列表")
    public Object list(String condition) {
        return studyPlanUserService.selectList(null);
    }

    /**
     * 新增study_plan_user
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增study_plan_user", notes = "新增study_plan_user")
    public Object add(StudyPlanUser studyPlanUser) {
        studyPlanUserService.insert(studyPlanUser);
        return SUCCESS_TIP;
    }

    /**
     * 删除study_plan_user
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除study_plan_user", notes = "删除study_plan_user")
    public Object delete(@RequestParam Integer studyPlanUserId) {
        studyPlanUserService.deleteById(studyPlanUserId);
        return SUCCESS_TIP;
    }

    /**
     * 修改study_plan_user
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改study_plan_user", notes = "修改study_plan_user")
    public Object update(StudyPlanUser studyPlanUser) {
        studyPlanUserService.updateById(studyPlanUser);
        return SUCCESS_TIP;
    }

    /**
     * study_plan_user详情
     */
    @RequestMapping(value = "/detail/{studyPlanUserId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "study_plan_user详情", notes = "study_plan_user详情")
    public Object detail(@PathVariable("studyPlanUserId") Integer studyPlanUserId) {
        return studyPlanUserService.selectById(studyPlanUserId);
    }
}
