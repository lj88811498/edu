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
import com.github.edu.modular.edu.model.UserPractice;
import com.github.edu.modular.edu.service.IUserPracticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * user_practice控制器
 *
 * @author lzq
 * @Date 2020-05-16 19:01:29
 */
@Controller
@RequestMapping("/userPractice")
@Api(value = "UserPractice-controller", description = "user_practice")
public class UserPracticeController extends BaseController {

    private String PREFIX = "/edu/userPractice/";

    @Autowired
    private IUserPracticeService userPracticeService;

    /**
     * 跳转到user_practice首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "userPractice.html";
    }

    /**
     * 跳转到添加user_practice
     */
    @RequestMapping("/userPractice_add")
    public String userPracticeAdd() {
        return PREFIX + "userPractice_add.html";
    }

    /**
     * 跳转到修改user_practice
     */
    @RequestMapping(value = "/userPractice_update/{userPracticeId}", method = RequestMethod.GET)
    @ApiOperation(value = "编辑user_practice", notes = "编辑user_practice")
    public String userPracticeUpdate(@PathVariable Integer userPracticeId, Model model) {
        UserPractice userPractice = userPracticeService.selectById(userPracticeId);
        model.addAttribute("item",userPractice);
        LogObjectHolder.me().set(userPractice);
        return PREFIX + "userPractice_edit.html";
    }

    /**
     * 获取user_practice列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取user_practice列表", notes = "获取user_practice列表")
    public Object list(String condition) {
        return userPracticeService.selectList(null);
    }

    /**
     * 新增user_practice
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增user_practice", notes = "新增user_practice")
    public Object add(UserPractice userPractice) {
        userPracticeService.insert(userPractice);
        return SUCCESS_TIP;
    }

    /**
     * 删除user_practice
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除user_practice", notes = "删除user_practice")
    public Object delete(@RequestParam Integer userPracticeId) {
        userPracticeService.deleteById(userPracticeId);
        return SUCCESS_TIP;
    }

    /**
     * 修改user_practice
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改user_practice", notes = "修改user_practice")
    public Object update(UserPractice userPractice) {
        userPracticeService.updateById(userPractice);
        return SUCCESS_TIP;
    }

    /**
     * user_practice详情
     */
    @RequestMapping(value = "/detail/{userPracticeId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "user_practice详情", notes = "user_practice详情")
    public Object detail(@PathVariable("userPracticeId") Integer userPracticeId) {
        return userPracticeService.selectById(userPracticeId);
    }
}
