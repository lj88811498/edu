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
import com.github.edu.modular.edu.model.SysDept;
import com.github.edu.modular.edu.service.ISysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * sys_dept控制器
 *
 * @author Monkey
 * @Date 2020-05-28 09:36:32
 */
@Controller
@RequestMapping("/sysDept")
@Api(value = "SysDept-controller", description = "sys_dept")
public class SysDeptController extends BaseController {

    private String PREFIX = "/edu/sysDept/";

    @Autowired
    private ISysDeptService sysDeptService;

    /**
     * 跳转到sys_dept首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "sysDept.html";
    }

    /**
     * 跳转到添加sys_dept
     */
    @RequestMapping("/sysDept_add")
    public String sysDeptAdd() {
        return PREFIX + "sysDept_add.html";
    }

    /**
     * 跳转到修改sys_dept
     */
    @RequestMapping(value = "/sysDept_update/{sysDeptId}", method = RequestMethod.GET)
    @ApiOperation(value = "编辑sys_dept", notes = "编辑sys_dept")
    public String sysDeptUpdate(@PathVariable Integer sysDeptId, Model model) {
        SysDept sysDept = sysDeptService.selectById(sysDeptId);
        model.addAttribute("item",sysDept);
        LogObjectHolder.me().set(sysDept);
        return PREFIX + "sysDept_edit.html";
    }

    /**
     * 获取sys_dept列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取sys_dept列表", notes = "获取sys_dept列表")
    public Object list(String condition) {
        return sysDeptService.selectList(null);
    }

    /**
     * 新增sys_dept
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增sys_dept", notes = "新增sys_dept")
    public Object add(SysDept sysDept) {
        sysDeptService.insert(sysDept);
        return SUCCESS_TIP;
    }

    /**
     * 删除sys_dept
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除sys_dept", notes = "删除sys_dept")
    public Object delete(@RequestParam Integer sysDeptId) {
        sysDeptService.deleteById(sysDeptId);
        return SUCCESS_TIP;
    }

    /**
     * 修改sys_dept
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改sys_dept", notes = "修改sys_dept")
    public Object update(SysDept sysDept) {
        sysDeptService.updateById(sysDept);
        return SUCCESS_TIP;
    }

    /**
     * sys_dept详情
     */
    @RequestMapping(value = "/detail/{sysDeptId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "sys_dept详情", notes = "sys_dept详情")
    public Object detail(@PathVariable("sysDeptId") Integer sysDeptId) {
        return sysDeptService.selectById(sysDeptId);
    }
}
