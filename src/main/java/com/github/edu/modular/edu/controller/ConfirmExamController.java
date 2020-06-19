package com.github.edu.modular.edu.controller;

import com.github.edu.core.base.controller.BaseController;
import com.github.edu.modular.edu.service.IConfirmExamService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <li>文件名称: 题目名称</li>
 * <li>文件描述: 确认考试 前端控制器</li>
 * <li>版权所有: 版权所有© 2005-2017</li>
 * <li>公 司: 贝奇达</li>
 * <li>内容摘要: 无</li>
 * <li>其他说明:无</li>
 * <li>完成日期： 2020-05-10</li>
 * <li>修改记录: 无</li>
 *
 * @author monkey
 * @version 版本号
 */
@RestController
@RequestMapping("/confirmExam")
@Api(value = "确认考试接口", description = "用作确认考试演示")
public class ConfirmExamController extends BaseController {


    @Autowired
    private IConfirmExamService confirmExamService;


}
