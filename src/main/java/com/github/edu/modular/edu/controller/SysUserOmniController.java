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
import com.github.edu.modular.edu.model.SysUserOmni;
import com.github.edu.modular.edu.service.ISysUserOmniService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * sys_user_omni控制器
 *
 * @author Monkey
 * @Date 2020-05-28 09:36:34
 */
@Controller
@RequestMapping("/sysUserOmni")
@Api(value = "SysUserOmni-controller", description = "sys_user_omni")
public class SysUserOmniController extends BaseController {

    private String PREFIX = "/edu/sysUserOmni/";

    @Autowired
    private ISysUserOmniService sysUserOmniService;

    /**
     * 跳转到sys_user_omni首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "sysUserOmni.html";
    }

    /**
     * 跳转到添加sys_user_omni
     */
    @RequestMapping("/sysUserOmni_add")
    public String sysUserOmniAdd() {
        return PREFIX + "sysUserOmni_add.html";
    }

    /**
     * 跳转到修改sys_user_omni
     */
    @RequestMapping(value = "/sysUserOmni_update/{sysUserOmniId}", method = RequestMethod.GET)
    @ApiOperation(value = "编辑sys_user_omni", notes = "编辑sys_user_omni")
    public String sysUserOmniUpdate(@PathVariable Integer sysUserOmniId, Model model) {
        SysUserOmni sysUserOmni = sysUserOmniService.selectById(sysUserOmniId);
        model.addAttribute("item",sysUserOmni);
        LogObjectHolder.me().set(sysUserOmni);
        return PREFIX + "sysUserOmni_edit.html";
    }

    /**
     * 获取sys_user_omni列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取sys_user_omni列表", notes = "获取sys_user_omni列表")
    public Object list(String condition) {
        return sysUserOmniService.selectList(null);
    }

    /**
     * 新增sys_user_omni
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增sys_user_omni", notes = "新增sys_user_omni")
    public Object add(SysUserOmni sysUserOmni) {
        sysUserOmniService.insert(sysUserOmni);
        return SUCCESS_TIP;
    }

    /**
     * 删除sys_user_omni
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除sys_user_omni", notes = "删除sys_user_omni")
    public Object delete(@RequestParam Integer sysUserOmniId) {
        sysUserOmniService.deleteById(sysUserOmniId);
        return SUCCESS_TIP;
    }

    /**
     * 修改sys_user_omni
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改sys_user_omni", notes = "修改sys_user_omni")
    public Object update(SysUserOmni sysUserOmni) {
        sysUserOmniService.updateById(sysUserOmni);
        return SUCCESS_TIP;
    }

    /**
     * sys_user_omni详情
     */
    @RequestMapping(value = "/detail/{sysUserOmniId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "sys_user_omni详情", notes = "sys_user_omni详情")
    public Object detail(@PathVariable("sysUserOmniId") Integer sysUserOmniId) {
        return sysUserOmniService.selectById(sysUserOmniId);
    }
}
