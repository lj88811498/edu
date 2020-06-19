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
import com.github.edu.modular.edu.model.SysRole;
import com.github.edu.modular.edu.service.ISysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * sys_role控制器
 *
 * @author Monkey
 * @Date 2020-05-28 09:36:33
 */
@Controller
@RequestMapping("/sysRole")
@Api(value = "SysRole-controller", description = "sys_role")
public class SysRoleController extends BaseController {

    private String PREFIX = "/edu/sysRole/";

    @Autowired
    private ISysRoleService sysRoleService;

    /**
     * 跳转到sys_role首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "sysRole.html";
    }

    /**
     * 跳转到添加sys_role
     */
    @RequestMapping("/sysRole_add")
    public String sysRoleAdd() {
        return PREFIX + "sysRole_add.html";
    }

    /**
     * 跳转到修改sys_role
     */
    @RequestMapping(value = "/sysRole_update/{sysRoleId}", method = RequestMethod.GET)
    @ApiOperation(value = "编辑sys_role", notes = "编辑sys_role")
    public String sysRoleUpdate(@PathVariable Integer sysRoleId, Model model) {
        SysRole sysRole = sysRoleService.selectById(sysRoleId);
        model.addAttribute("item",sysRole);
        LogObjectHolder.me().set(sysRole);
        return PREFIX + "sysRole_edit.html";
    }

    /**
     * 获取sys_role列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取sys_role列表", notes = "获取sys_role列表")
    public Object list(String condition) {
        return sysRoleService.selectList(null);
    }

    /**
     * 新增sys_role
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增sys_role", notes = "新增sys_role")
    public Object add(SysRole sysRole) {
        sysRoleService.insert(sysRole);
        return SUCCESS_TIP;
    }

    /**
     * 删除sys_role
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除sys_role", notes = "删除sys_role")
    public Object delete(@RequestParam Integer sysRoleId) {
        sysRoleService.deleteById(sysRoleId);
        return SUCCESS_TIP;
    }

    /**
     * 修改sys_role
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改sys_role", notes = "修改sys_role")
    public Object update(SysRole sysRole) {
        sysRoleService.updateById(sysRole);
        return SUCCESS_TIP;
    }

    /**
     * sys_role详情
     */
    @RequestMapping(value = "/detail/{sysRoleId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "sys_role详情", notes = "sys_role详情")
    public Object detail(@PathVariable("sysRoleId") Integer sysRoleId) {
        return sysRoleService.selectById(sysRoleId);
    }
}
