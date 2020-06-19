package com.github.edu.modular.edu.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.edu.core.base.controller.BaseController;
import com.github.edu.modular.edu.model.SubjectsBankType;
import com.github.edu.modular.edu.service.ISubjectsBankTypeService;
import com.github.edu.modular.edu.util.ExceptionUtil;
import com.github.edu.modular.edu.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <li>文件名称: 题目名称</li>
 * <li>文件描述: 题库分类 前端控制器</li>
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
@RequestMapping("/subjectsBankType")
@Api(value = "题库分类接口(完成）", description = "题库分类接口(完成）")
public class SubjectsBankTypeController extends BaseController {


    @Autowired
    private ISubjectsBankTypeService subjectsBankTypeService;

    /**
     * 新增题库分类
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增题库分类（完成）",
                  notes = "新增题库分类（完成）、\n\r\n" +
                          "subjectsBankTypeName: 题库分类名称\n\r\n" +
                          "subjectsBankTypeParentId: 父节点，顶级时为空\n\r\n"
    )
    public Object add(@RequestBody SubjectsBankType subjectsBankType){

        R r = new R();
        try {
            subjectsBankType.setSubjectsBankTypeId(null);
            subjectsBankType.insert();

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
                    "subjectsBankTypeName: 题库分类名称\n\r\n" +
                    "subjectsBankTypeParentId: 父节点，顶级时为空\n\r\n" +
                    "subjectsBankTypeId: 主键id\n\r\n"
    )
    public Object update(@RequestBody SubjectsBankType subjectsBankType){

        R r = new R();
        try {
            if (subjectsBankType.getSubjectsBankTypeId() != null) {
                subjectsBankType.setSubjectsBankTypeUpdateTime(new Date());
                subjectsBankType.updateById();
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
    @ApiOperation(value = "删除题库分类（完成）", notes = "删除题库分类（完成）")
    public Object delete(@ApiParam(value = "题库分类id", required = true)
                         @RequestParam(value = "subjectsBankTypeId") Integer subjectsBankTypeId) {

        R r = new R();
        try {

            SubjectsBankType sbt = new SubjectsBankType();
            sbt.setSubjectsBankTypeId(subjectsBankTypeId);
            sbt.setSubjectsBankTypeIsDelete(1);
            sbt.updateById();
        } catch (Exception e) {
            r = ExceptionUtil.getException(e);
        }

        return r;
    }


    /**
     * 获取题库分类
     */
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取题库分类（完成）", notes = "获取题库分类（完成）")
    public Object listAll() {

        R r = new R();
        try {
            List<SubjectsBankType> subjectsBankTypes = subjectsBankTypeService.selectList(new EntityWrapper<SubjectsBankType>()
                    .eq("subjects_bank_type_is_delete", 0)
//                    .setSqlSelect("subjects_bank_type_id subjectsBankTypeId, " +
//                            "subjects_bank_type_name subjectsBankTypeName, " +
//                            "subjects_bank_type_parent_id subjectsBankTypeParentId")
            );
            List<SubjectsBankType> subjectsBankTypes2 = subjectsBankTypes;
            List<SubjectsBankType> result = new ArrayList<>();
            subjectsBankTypes.forEach(s -> {
                int id = s.getSubjectsBankTypeId();
                Integer pid = s.getSubjectsBankTypeParentId();
                if (pid == null) {
                    List<SubjectsBankType> list = new ArrayList<>();
                    subjectsBankTypes2.forEach(s2 -> {
                        Integer pid2 = s2.getSubjectsBankTypeParentId();
                        if (pid2 != null && pid2 == id) {
                            list.add(s2);
                        }
                    });
                    s.setSubjectsBankTypes(list);
                    result.add(s);
                }

            });

            r.setData(result);
        } catch (Exception e) {
            r = ExceptionUtil.getException(e);
        }

        return r;

    }
}
