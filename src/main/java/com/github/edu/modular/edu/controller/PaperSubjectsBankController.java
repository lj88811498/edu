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
import com.github.edu.modular.edu.model.PaperSubjectsBank;
import com.github.edu.modular.edu.service.IPaperSubjectsBankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * paper_subjects_bank控制器
 *
 * @author Monkey
 * @Date 2020-05-15 11:40:24
 */
@Controller
@RequestMapping("/paperSubjectsBank")
@Api(value = "PaperSubjectsBank-controller", description = "卷子题库（完成）")
public class PaperSubjectsBankController extends BaseController {

    private String PREFIX = "/edu/paperSubjectsBank/";

    @Autowired
    private IPaperSubjectsBankService paperSubjectsBankService;


    /**
     * 获取paper_subjects_bank列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
//    @ApiOperation(value = "获取paper_subjects_bank列表", notes = "获取paper_subjects_bank列表")
    public Object list(String condition) {
        return paperSubjectsBankService.selectList(null);
    }

    /**
     * 新增paper_subjects_bank
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
//    @ApiOperation(value = "新增paper_subjects_bank", notes = "新增paper_subjects_bank")
    public Object add(PaperSubjectsBank paperSubjectsBank) {
        paperSubjectsBankService.insert(paperSubjectsBank);
        return SUCCESS_TIP;
    }

    /**
     * 删除paper_subjects_bank
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
//    @ApiOperation(value = "删除paper_subjects_bank", notes = "删除paper_subjects_bank")
    public Object delete(@RequestParam Integer paperSubjectsBankId) {
        paperSubjectsBankService.deleteById(paperSubjectsBankId);
        return SUCCESS_TIP;
    }

    /**
     * 修改paper_subjects_bank
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
//    @ApiOperation(value = "修改paper_subjects_bank", notes = "修改paper_subjects_bank")
    public Object update(PaperSubjectsBank paperSubjectsBank) {
        paperSubjectsBankService.updateById(paperSubjectsBank);
        return SUCCESS_TIP;
    }

    /**
     * paper_subjects_bank详情
     */
    @RequestMapping(value = "/detail/{paperSubjectsBankId}", method = RequestMethod.GET)
    @ResponseBody
//    @ApiOperation(value = "paper_subjects_bank详情", notes = "paper_subjects_bank详情")
    public Object detail(@PathVariable("paperSubjectsBankId") Integer paperSubjectsBankId) {
        return paperSubjectsBankService.selectById(paperSubjectsBankId);
    }
}
