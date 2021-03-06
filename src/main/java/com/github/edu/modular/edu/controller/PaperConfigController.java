package com.github.edu.modular.edu.controller;

import com.github.edu.core.base.controller.BaseController;
import com.github.edu.modular.edu.service.IPaperConfigService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <li>文件名称: 题目名称</li>
 * <li>文件描述: 卷子-题库 前端控制器</li>
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
@RequestMapping("/paperConfig")
@Api(value = "卷子-题库接口", description = "用作卷子-题库演示")
public class PaperConfigController extends BaseController {


    @Autowired
    private IPaperConfigService paperConfigService;


}
