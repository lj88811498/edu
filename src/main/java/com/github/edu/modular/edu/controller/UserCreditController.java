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
import com.github.edu.modular.edu.model.UserCredit;
import com.github.edu.modular.edu.service.IUserCreditService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * user_credit控制器
 *
 * @author monkey
 * @Date 2020-05-18 23:10:54
 */
@Controller
@RequestMapping("/userCredit")
@Api(value = "UserCredit-controller", description = "user_credit")
public class UserCreditController extends BaseController {

    private String PREFIX = "/edu/userCredit/";

    @Autowired
    private IUserCreditService userCreditService;

    /**
     * 跳转到user_credit首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "userCredit.html";
    }

    /**
     * 跳转到添加user_credit
     */
    @RequestMapping("/userCredit_add")
    public String userCreditAdd() {
        return PREFIX + "userCredit_add.html";
    }

    /**
     * 跳转到修改user_credit
     */
    @RequestMapping(value = "/userCredit_update/{userCreditId}", method = RequestMethod.GET)
    @ApiOperation(value = "编辑user_credit", notes = "编辑user_credit")
    public String userCreditUpdate(@PathVariable Integer userCreditId, Model model) {
        UserCredit userCredit = userCreditService.selectById(userCreditId);
        model.addAttribute("item",userCredit);
        LogObjectHolder.me().set(userCredit);
        return PREFIX + "userCredit_edit.html";
    }

    /**
     * 获取user_credit列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取user_credit列表", notes = "获取user_credit列表")
    public Object list(String condition) {
        return userCreditService.selectList(null);
    }

    /**
     * 新增user_credit
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增user_credit", notes = "新增user_credit")
    public Object add(UserCredit userCredit) {
        userCreditService.insert(userCredit);
        return SUCCESS_TIP;
    }

    /**
     * 删除user_credit
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除user_credit", notes = "删除user_credit")
    public Object delete(@RequestParam Integer userCreditId) {
        userCreditService.deleteById(userCreditId);
        return SUCCESS_TIP;
    }

    /**
     * 修改user_credit
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改user_credit", notes = "修改user_credit")
    public Object update(UserCredit userCredit) {
        userCreditService.updateById(userCredit);
        return SUCCESS_TIP;
    }

    /**
     * user_credit详情
     */
    @RequestMapping(value = "/detail/{userCreditId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "user_credit详情", notes = "user_credit详情")
    public Object detail(@PathVariable("userCreditId") Integer userCreditId) {
        return userCreditService.selectById(userCreditId);
    }
}
