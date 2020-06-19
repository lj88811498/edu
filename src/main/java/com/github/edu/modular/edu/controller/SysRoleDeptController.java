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
import com.github.edu.modular.edu.model.SysRoleDept;
import com.github.edu.modular.edu.service.ISysRoleDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * sys_role_dept控制器
 *
 * @author Monkey
 * @Date 2020-05-28 09:36:33
 */
@Controller
@RequestMapping("/sysRoleDept")
@Api(value = "SysRoleDept-controller", description = "sys_role_dept")
public class SysRoleDeptController extends BaseController {

    private String PREFIX = "/edu/sysRoleDept/";

    @Autowired
    private ISysRoleDeptService sysRoleDeptService;

    /**
     * 跳转到sys_role_dept首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "sysRoleDept.html";
    }

    /**
     * 跳转到添加sys_role_dept
     */
    @RequestMapping("/sysRoleDept_add")
    public String sysRoleDeptAdd() {
        return PREFIX + "sysRoleDept_add.html";
    }

    /**
     * 跳转到修改sys_role_dept
     */
    @RequestMapping(value = "/sysRoleDept_update/{sysRoleDeptId}", method = RequestMethod.GET)
    @ApiOperation(value = "编辑sys_role_dept", notes = "编辑sys_role_dept")
    public String sysRoleDeptUpdate(@PathVariable Integer sysRoleDeptId, Model model) {
        SysRoleDept sysRoleDept = sysRoleDeptService.selectById(sysRoleDeptId);
        model.addAttribute("item",sysRoleDept);
        LogObjectHolder.me().set(sysRoleDept);
        return PREFIX + "sysRoleDept_edit.html";
    }

    /**
     * 获取sys_role_dept列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取sys_role_dept列表", notes = "获取sys_role_dept列表")
    public Object list(String condition) {
        return sysRoleDeptService.selectList(null);
    }

    /**
     * 新增sys_role_dept
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增sys_role_dept", notes = "新增sys_role_dept")
    public Object add(SysRoleDept sysRoleDept) {
        sysRoleDeptService.insert(sysRoleDept);
        return SUCCESS_TIP;
    }

    /**
     * 删除sys_role_dept
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除sys_role_dept", notes = "删除sys_role_dept")
    public Object delete(@RequestParam Integer sysRoleDeptId) {
        sysRoleDeptService.deleteById(sysRoleDeptId);
        return SUCCESS_TIP;
    }

    /**
     * 修改sys_role_dept
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改sys_role_dept", notes = "修改sys_role_dept")
    public Object update(SysRoleDept sysRoleDept) {
        sysRoleDeptService.updateById(sysRoleDept);
        return SUCCESS_TIP;
    }

    /**
     * sys_role_dept详情
     */
    @RequestMapping(value = "/detail/{sysRoleDeptId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "sys_role_dept详情", notes = "sys_role_dept详情")
    public Object detail(@PathVariable("sysRoleDeptId") Integer sysRoleDeptId) {
        return sysRoleDeptService.selectById(sysRoleDeptId);
    }
}
