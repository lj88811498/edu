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
import com.github.edu.modular.edu.model.SysUser;
import com.github.edu.modular.edu.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * sys_user控制器
 *
 * @author Monkey
 * @Date 2020-05-28 09:36:33
 */
@Controller
@RequestMapping("/sysUser")
@Api(value = "SysUser-controller", description = "sys_user")
public class SysUserController extends BaseController {

    private String PREFIX = "/edu/sysUser/";

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 跳转到sys_user首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "sysUser.html";
    }

    /**
     * 跳转到添加sys_user
     */
    @RequestMapping("/sysUser_add")
    public String sysUserAdd() {
        return PREFIX + "sysUser_add.html";
    }

    /**
     * 跳转到修改sys_user
     */
    @RequestMapping(value = "/sysUser_update/{sysUserId}", method = RequestMethod.GET)
    @ApiOperation(value = "编辑sys_user", notes = "编辑sys_user")
    public String sysUserUpdate(@PathVariable Integer sysUserId, Model model) {
        SysUser sysUser = sysUserService.selectById(sysUserId);
        model.addAttribute("item",sysUser);
        LogObjectHolder.me().set(sysUser);
        return PREFIX + "sysUser_edit.html";
    }

    /**
     * 获取sys_user列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取sys_user列表", notes = "获取sys_user列表")
    public Object list(String condition) {
        return sysUserService.selectList(null);
    }

    /**
     * 新增sys_user
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增sys_user", notes = "新增sys_user")
    public Object add(SysUser sysUser) {
        sysUserService.insert(sysUser);
        return SUCCESS_TIP;
    }

    /**
     * 删除sys_user
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除sys_user", notes = "删除sys_user")
    public Object delete(@RequestParam Integer sysUserId) {
        sysUserService.deleteById(sysUserId);
        return SUCCESS_TIP;
    }

    /**
     * 修改sys_user
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改sys_user", notes = "修改sys_user")
    public Object update(SysUser sysUser) {
        sysUserService.updateById(sysUser);
        return SUCCESS_TIP;
    }

    /**
     * sys_user详情
     */
    @RequestMapping(value = "/detail/{sysUserId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "sys_user详情", notes = "sys_user详情")
    public Object detail(@PathVariable("sysUserId") Integer sysUserId) {
        return sysUserService.selectById(sysUserId);
    }
}
