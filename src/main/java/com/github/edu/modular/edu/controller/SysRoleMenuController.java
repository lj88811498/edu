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
import com.github.edu.modular.edu.model.SysRoleMenu;
import com.github.edu.modular.edu.service.ISysRoleMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * sys_role_menu控制器
 *
 * @author Monkey
 * @Date 2020-05-28 09:36:33
 */
@Controller
@RequestMapping("/sysRoleMenu")
@Api(value = "SysRoleMenu-controller", description = "sys_role_menu")
public class SysRoleMenuController extends BaseController {

    private String PREFIX = "/edu/sysRoleMenu/";

    @Autowired
    private ISysRoleMenuService sysRoleMenuService;

    /**
     * 跳转到sys_role_menu首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "sysRoleMenu.html";
    }

    /**
     * 跳转到添加sys_role_menu
     */
    @RequestMapping("/sysRoleMenu_add")
    public String sysRoleMenuAdd() {
        return PREFIX + "sysRoleMenu_add.html";
    }

    /**
     * 跳转到修改sys_role_menu
     */
    @RequestMapping(value = "/sysRoleMenu_update/{sysRoleMenuId}", method = RequestMethod.GET)
    @ApiOperation(value = "编辑sys_role_menu", notes = "编辑sys_role_menu")
    public String sysRoleMenuUpdate(@PathVariable Integer sysRoleMenuId, Model model) {
        SysRoleMenu sysRoleMenu = sysRoleMenuService.selectById(sysRoleMenuId);
        model.addAttribute("item",sysRoleMenu);
        LogObjectHolder.me().set(sysRoleMenu);
        return PREFIX + "sysRoleMenu_edit.html";
    }

    /**
     * 获取sys_role_menu列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取sys_role_menu列表", notes = "获取sys_role_menu列表")
    public Object list(String condition) {
        return sysRoleMenuService.selectList(null);
    }

    /**
     * 新增sys_role_menu
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增sys_role_menu", notes = "新增sys_role_menu")
    public Object add(SysRoleMenu sysRoleMenu) {
        sysRoleMenuService.insert(sysRoleMenu);
        return SUCCESS_TIP;
    }

    /**
     * 删除sys_role_menu
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除sys_role_menu", notes = "删除sys_role_menu")
    public Object delete(@RequestParam Integer sysRoleMenuId) {
        sysRoleMenuService.deleteById(sysRoleMenuId);
        return SUCCESS_TIP;
    }

    /**
     * 修改sys_role_menu
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改sys_role_menu", notes = "修改sys_role_menu")
    public Object update(SysRoleMenu sysRoleMenu) {
        sysRoleMenuService.updateById(sysRoleMenu);
        return SUCCESS_TIP;
    }

    /**
     * sys_role_menu详情
     */
    @RequestMapping(value = "/detail/{sysRoleMenuId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "sys_role_menu详情", notes = "sys_role_menu详情")
    public Object detail(@PathVariable("sysRoleMenuId") Integer sysRoleMenuId) {
        return sysRoleMenuService.selectById(sysRoleMenuId);
    }
}
