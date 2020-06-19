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
import com.github.edu.modular.edu.model.SysMenu;
import com.github.edu.modular.edu.service.ISysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * sys_menu控制器
 *
 * @author Monkey
 * @Date 2020-05-28 09:36:32
 */
@Controller
@RequestMapping("/sysMenu")
@Api(value = "SysMenu-controller", description = "sys_menu")
public class SysMenuController extends BaseController {

    private String PREFIX = "/edu/sysMenu/";

    @Autowired
    private ISysMenuService sysMenuService;

    /**
     * 跳转到sys_menu首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "sysMenu.html";
    }

    /**
     * 跳转到添加sys_menu
     */
    @RequestMapping("/sysMenu_add")
    public String sysMenuAdd() {
        return PREFIX + "sysMenu_add.html";
    }

    /**
     * 跳转到修改sys_menu
     */
    @RequestMapping(value = "/sysMenu_update/{sysMenuId}", method = RequestMethod.GET)
    @ApiOperation(value = "编辑sys_menu", notes = "编辑sys_menu")
    public String sysMenuUpdate(@PathVariable Integer sysMenuId, Model model) {
        SysMenu sysMenu = sysMenuService.selectById(sysMenuId);
        model.addAttribute("item",sysMenu);
        LogObjectHolder.me().set(sysMenu);
        return PREFIX + "sysMenu_edit.html";
    }

    /**
     * 获取sys_menu列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取sys_menu列表", notes = "获取sys_menu列表")
    public Object list(String condition) {
        return sysMenuService.selectList(null);
    }

    /**
     * 新增sys_menu
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增sys_menu", notes = "新增sys_menu")
    public Object add(SysMenu sysMenu) {
        sysMenuService.insert(sysMenu);
        return SUCCESS_TIP;
    }

    /**
     * 删除sys_menu
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除sys_menu", notes = "删除sys_menu")
    public Object delete(@RequestParam Integer sysMenuId) {
        sysMenuService.deleteById(sysMenuId);
        return SUCCESS_TIP;
    }

    /**
     * 修改sys_menu
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改sys_menu", notes = "修改sys_menu")
    public Object update(SysMenu sysMenu) {
        sysMenuService.updateById(sysMenu);
        return SUCCESS_TIP;
    }

    /**
     * sys_menu详情
     */
    @RequestMapping(value = "/detail/{sysMenuId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "sys_menu详情", notes = "sys_menu详情")
    public Object detail(@PathVariable("sysMenuId") Integer sysMenuId) {
        return sysMenuService.selectById(sysMenuId);
    }
}
