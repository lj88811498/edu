package com.github.edu.modular.edu.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

import com.github.edu.core.base.controller.BaseController;
import com.github.edu.core.common.constant.factory.PageFactory;
import com.github.edu.modular.edu.model.SubjectsBank;
import com.github.edu.modular.edu.model.SubjectsBankType;
import com.github.edu.modular.edu.service.ISubjectsBankService;
import com.github.edu.modular.edu.service.ISubjectsBankTypeService;
import com.github.edu.modular.edu.service.IUserAnswerService;
import com.github.edu.modular.edu.util.ExceptionUtil;
import com.github.edu.modular.edu.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <li>文件名称: 题目名称</li>
 * <li>文件描述: 题库 前端控制器</li>
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
@RequestMapping("/subjectsBank")
@Api(value = "题库接口(完成）", description = "题库接口(完成）")
public class SubjectsBankController extends BaseController {

    @Autowired
    private ISubjectsBankService subjectsBankService;

    @Autowired
    private ISubjectsBankTypeService subjectsBankTypeService;

    @Autowired
    private IUserAnswerService userAnswerService;

//    @Autowired
//    private IQuestionService questionService;

    /**
     * 新增题库名称
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增题库名称（完成）",
            notes = "新增题库名称（完成）、\n\r\n" +
                    "subjectsBankName: 题库名称\n\r\n" +
                    "subjectsBankTypeId: 题库分类id\n\r\n" +
                    "subjectsBankCreateBy: 创建人id\n\r\n"
    )
    public Object add(@RequestBody SubjectsBank subjectsBank){

        R r = new R();
        try {
            subjectsBank.setSubjectsBankId(null);
            subjectsBank.insert();

        } catch (Exception e) {
            r = ExceptionUtil.getException(e);
        }

        return r;
    }


    /**
     * 新增题库分类
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改题库分类（完成）",
                  notes = "修改题库分类（完成）、\n\r\n" +
                    "subjectsBankId: 题库id\n\r\n" +
                    "subjectsBankName: 题库名称\n\r\n" +
                    "subjectsBankUpdateBy: 修改人id\n\r\n" +
                    "subjectsBankTypeId: 题库分类id\n\r\n"
    )
    public Object update(@RequestBody SubjectsBank subjectsBank){

        R r = new R();
        try {
            if (subjectsBank.getSubjectsBankId() != null) {
                subjectsBank.setSubjectsBankUpdateTime(new Date());
                subjectsBank.updateById();
            } else {
                r = new R(null, "主键不能为空！", R.FAIL);
            }

        } catch (Exception e) {
            r = ExceptionUtil.getException(e);
        }

        return r;
    }


    /**
     * 删除seat
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value = "删除题库名称（完成）", notes = "删除题库名称（完成）")
    public Object delete(@ApiParam(value = "题库分类id", required = true)
                         @RequestParam(value = "subjectsBankId") Integer subjectsBankId) {

        R r = new R();
        try {

            SubjectsBank sbt = new SubjectsBank();
            sbt.setSubjectsBankId(subjectsBankId);
            sbt.setSubjectsBankIsDelete(1);
            sbt.updateById();
        } catch (Exception e) {
            r = ExceptionUtil.getException(e);
        }

        return r;
    }

    /**
     * 获取题库名称列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取题库名称列表（完成）", notes = "获取题库名称列表（完成）")
    public Object list(@ApiParam(value = "每页条数")@RequestParam(value = "size", defaultValue = "10", required = false) int size,
                       @ApiParam(value = "当前页")@RequestParam(value = "curPage", defaultValue = "1", required = false) int curPage,
                       @ApiParam(value = "题库名称")@RequestParam(value = "subjectsBankName", defaultValue = "", required = false) String subjectsBankName,
                       @ApiParam(value = "题库分类id")@RequestParam(value = "subjectsBankTypeId", defaultValue = "", required = false) String subjectsBankTypeId) {

        R r = new R();
        try {
            EntityWrapper<SubjectsBank> ew = new EntityWrapper<>();
            ew.eq("subjects_bank_is_delete", 0);
            ew.setSqlSelect("subjects_bank_id subjectsBankId,subjects_bank_type_id subjectsBankTypeId," +
                    "subjects_bank_name subjectsBankName,subjects_bank_create_time subjectsBankCreateTime," +
                    "subjects_bank_update_time subjectsBankUpdateTime,subjects_bank_create_by subjectsBankCreateBy," +
                    "subjects_bank_update_by subjectsBankUpdateBy," +
                    "(select count(1) from subjects where subjects_bank_id = subjects_bank.subjects_bank_id) subjectsCount");
            if (StringUtils.isNotBlank(subjectsBankTypeId)) {
                ew.eq("subjects_bank_type_id", subjectsBankTypeId);
            }
            if (StringUtils.isNotBlank(subjectsBankName)) {
                ew.like("subjects_bank_name", subjectsBankName);
            }

            Page<SubjectsBank> page = new PageFactory<SubjectsBank>().defaultPage2(size, curPage);
            Page<Map<String, Object>> mapPage = subjectsBankService.selectMapsPage(page, ew);
            List<Map<String, Object>> records = mapPage.getRecords();
            records.forEach(map -> {
                Object subjectsBankTypeId2 = map.get("subjectsBankTypeId");
                SubjectsBankType subjectsBankType = subjectsBankTypeService.selectById((Serializable) subjectsBankTypeId2);
                if (subjectsBankType != null) {
                    map.put("subjectsBankTypeName", subjectsBankType.getSubjectsBankTypeName());
                }
                Object subjectsBankCreateBy = map.get("subjectsBankCreateBy");
                String userName = userAnswerService.selectUsers(subjectsBankCreateBy + "");
                map.put("subjectsBankCreateByName", userName);
            });

            r.setData(mapPage);
        } catch (Exception e) {
            r = ExceptionUtil.getException(e);
        }

        return r;

    }
}
