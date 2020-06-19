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
import com.github.edu.modular.edu.model.SysUserRole;
import com.github.edu.modular.edu.service.ISysUserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * sys_user_role控制器
 *
 * @author Monkey
 * @Date 2020-05-28 09:36:34
 */
@Controller
@RequestMapping("/sysUserRole")
@Api(value = "SysUserRole-controller", description = "sys_user_role")
public class SysUserRoleController extends BaseController {

    private String PREFIX = "/edu/sysUserRole/";

    @Autowired
    private ISysUserRoleService sysUserRoleService;

    /**
     * 跳转到sys_user_role首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "sysUserRole.html";
    }

    /**
     * 跳转到添加sys_user_role
     */
    @RequestMapping("/sysUserRole_add")
    public String sysUserRoleAdd() {
        return PREFIX + "sysUserRole_add.html";
    }

    /**
     * 跳转到修改sys_user_role
     */
    @RequestMapping(value = "/sysUserRole_update/{sysUserRoleId}", method = RequestMethod.GET)
    @ApiOperation(value = "编辑sys_user_role", notes = "编辑sys_user_role")
    public String sysUserRoleUpdate(@PathVariable Integer sysUserRoleId, Model model) {
        SysUserRole sysUserRole = sysUserRoleService.selectById(sysUserRoleId);
        model.addAttribute("item",sysUserRole);
        LogObjectHolder.me().set(sysUserRole);
        return PREFIX + "sysUserRole_edit.html";
    }

    /**
     * 获取sys_user_role列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取sys_user_role列表", notes = "获取sys_user_role列表")
    public Object list(String condition) {
        return sysUserRoleService.selectList(null);
    }

    /**
     * 新增sys_user_role
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增sys_user_role", notes = "新增sys_user_role")
    public Object add(SysUserRole sysUserRole) {
        sysUserRoleService.insert(sysUserRole);
        return SUCCESS_TIP;
    }

    /**
     * 删除sys_user_role
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除sys_user_role", notes = "删除sys_user_role")
    public Object delete(@RequestParam Integer sysUserRoleId) {
        sysUserRoleService.deleteById(sysUserRoleId);
        return SUCCESS_TIP;
    }

    /**
     * 修改sys_user_role
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改sys_user_role", notes = "修改sys_user_role")
    public Object update(SysUserRole sysUserRole) {
        sysUserRoleService.updateById(sysUserRole);
        return SUCCESS_TIP;
    }

    /**
     * sys_user_role详情
     */
    @RequestMapping(value = "/detail/{sysUserRoleId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "sys_user_role详情", notes = "sys_user_role详情")
    public Object detail(@PathVariable("sysUserRoleId") Integer sysUserRoleId) {
        return sysUserRoleService.selectById(sysUserRoleId);
    }
}
