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
import com.github.edu.modular.edu.model.PaperSubjectsAnswer;
import com.github.edu.modular.edu.service.IPaperSubjectsAnswerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * paper_subjects_answer控制器
 *
 * @author Monkey
 * @Date 2020-05-15 10:39:30
 */
@Controller
@RequestMapping("/paperSubjectsAnswer")
@Api(value = "PaperSubjectsAnswer-controller", description = "卷子题目答案（完成）")
public class PaperSubjectsAnswerController extends BaseController {

    private String PREFIX = "/edu/paperSubjectsAnswer/";

    @Autowired
    private IPaperSubjectsAnswerService paperSubjectsAnswerService;

    /**
     * 获取paper_subjects_answer列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
//    @ApiOperation(value = "获取paper_subjects_answer列表", notes = "获取paper_subjects_answer列表")
    public Object list(String condition) {
        return paperSubjectsAnswerService.selectList(null);
    }

    /**
     * 新增paper_subjects_answer
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
//    @ApiOperation(value = "新增paper_subjects_answer", notes = "新增paper_subjects_answer")
    public Object add(PaperSubjectsAnswer paperSubjectsAnswer) {
        paperSubjectsAnswerService.insert(paperSubjectsAnswer);
        return SUCCESS_TIP;
    }

    /**
     * 删除paper_subjects_answer
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
//    @ApiOperation(value = "删除paper_subjects_answer", notes = "删除paper_subjects_answer")
    public Object delete(@RequestParam Integer paperSubjectsAnswerId) {
        paperSubjectsAnswerService.deleteById(paperSubjectsAnswerId);
        return SUCCESS_TIP;
    }

    /**
     * 修改paper_subjects_answer
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
//    @ApiOperation(value = "修改paper_subjects_answer", notes = "修改paper_subjects_answer")
    public Object update(PaperSubjectsAnswer paperSubjectsAnswer) {
        paperSubjectsAnswerService.updateById(paperSubjectsAnswer);
        return SUCCESS_TIP;
    }

    /**
     * paper_subjects_answer详情
     */
    @RequestMapping(value = "/detail/{paperSubjectsAnswerId}", method = RequestMethod.GET)
    @ResponseBody
//    @ApiOperation(value = "paper_subjects_answer详情", notes = "paper_subjects_answer详情")
    public Object detail(@PathVariable("paperSubjectsAnswerId") Integer paperSubjectsAnswerId) {
        return paperSubjectsAnswerService.selectById(paperSubjectsAnswerId);
    }
}
