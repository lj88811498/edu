package com.github.edu.modular.edu.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.github.edu.EduApplication;
import com.github.edu.core.base.controller.BaseController;
import com.github.edu.core.common.constant.factory.PageFactory;
import com.github.edu.core.exception.BussinessException;
import com.github.edu.modular.edu.model.Practice;
import com.github.edu.modular.edu.model.PracticeStatistics;
import com.github.edu.modular.edu.model.Subjects;
import com.github.edu.modular.edu.model.UserPractice;
import com.github.edu.modular.edu.service.IPracticeService;
import com.github.edu.modular.edu.service.IUserPracticeService;
import com.github.edu.modular.edu.util.ExceptionUtil;
import com.github.edu.modular.edu.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * <li>文件名称: 题目名称</li>
 * <li>文件描述: 练习库 前端控制器</li>
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
@RequestMapping("/practice")
@Api(value = "练习库接口", description = "用作练习库演示")
public class PracticeController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(PracticeController.class);
    @Autowired
    private IPracticeService practiceService;
    @Autowired
    private IUserPracticeService userPracticeService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "增加练习", notes = "增加练习")
    public R add(@RequestBody Practice practice){
        R r = new R();
        try {
            practiceService.insert(practice);
            if(null != practice.getPracticeUsers() && practice.getPracticeUsers().size() >0 ){
                List<UserPractice> userPractices = new ArrayList<>();
                for (Integer userId : practice.getPracticeUsers()) {
                    UserPractice userPractice = new UserPractice();
                    userPractice.setPracticeId(practice.getPracticeId());
                    userPractice.setUserId(userId);
                    userPractices.add(userPractice);
                }
                userPracticeService.insertBatch(userPractices);
            }
        }catch (Exception e){
            logger.error("增加练习失败",e);
            r = ExceptionUtil.getException(e);
        }
        return r;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改练习", notes = "修改练习")
    public R update(@RequestBody Practice practice){
        R r = new R();
        try {
            Practice queryPractice = practiceService.selectById(practice.getPracticeId());
            if(null == queryPractice){
                r.setCode(R.FAIL);
                r.setMsg("练习不存在");
                return r;
            }
            if(StringUtils.isNotBlank(practice.getPracticeStatus())){
                queryPractice.setPracticeStatus(practice.getPracticeStatus());
            }
            practiceService.updateById(queryPractice);
        }catch (Exception e){
            logger.error("修改练习失败:",e);
            r = ExceptionUtil.getException(e);
        }
        return r;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value = "删除练习", notes = "删除练习")
    public R delete(@ApiParam(value = "删除的id集合")@RequestParam(value = "ids",required = false) List<Integer> ids){
        R r = new R();
        try {
            if(null == ids || ids.isEmpty()){
                r.setCode(R.FAIL);
                r.setMsg("请选择需要删除的数据");
                return r;
            }
            practiceService.deleteBatchIds(ids);
        }catch (Exception e){
            logger.error("删除练习失败:",e);
            r = ExceptionUtil.getException(e);
        }
        return r;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询练习列表", notes = "查询练习列表")
    public R<Page<Practice>> queryPracticeByPage(@ApiParam(value = "每页条数")@RequestParam(value = "size", defaultValue = "10", required = false) Integer size,
                                       @ApiParam(value = "当前页")@RequestParam(value = "curPage", defaultValue = "1", required = false) Integer curPage,
                                       @ApiParam(value = "练习名称")@RequestParam(value = "practiceName",required = false) String practiceName,
                                       @ApiParam(value = "启用状态")@RequestParam(value = "practiceStatus",required = false) String practiceStatus){
        R r = new R();
        try {
            EntityWrapper<Practice> wrapper = new EntityWrapper();
            if (StringUtils.isNotBlank(practiceName)) {
                wrapper.like("practice_name", practiceName);
            }
            if (StringUtils.isNotBlank(practiceStatus)) {
                wrapper.eq("practice_status", practiceStatus);
            }
            Page<Practice> page = new PageFactory<Practice>().defaultPage2(size, curPage);
            Page<Practice> practicePage = practiceService.selectPage(page, wrapper);
            r.setData(practicePage);
        }catch (Exception e){
            r = ExceptionUtil.getException(e);
        }
        return r;
    }

    @RequestMapping(value = "/userPractice/{id}",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "用户练习情况",notes = "用户练习情况")
    public R<Page<Practice>> practiceForUserByPage(@ApiParam(value = "练习id")@PathVariable("id") Integer practiceId,
                                   @ApiParam(value = "用户名称")@RequestParam(value = "userName",required = false) String userName,
                                   @ApiParam(value = "部门id")@RequestParam(value = "deptId",required = false) Integer deptId,
                                   @ApiParam(value = "每页条数")@RequestParam(value = "size",defaultValue = "10",required = false) Integer size,
                                   @ApiParam(value = "当前页")@RequestParam(value = "curPage",defaultValue = "1",required = false) Integer curPage){
        R r = new R();
        try{
            DecimalFormat df=new DecimalFormat("0.0000");
            Page<Practice> page = new PageFactory<Practice>().defaultPage2(size, curPage);
            List<Practice> practices = practiceService.queryPracticeByUser(page, practiceId,userName,deptId);
            if(null != practices && practices.size() > 0){
                for (Practice practice : practices) {
                    if(practice.getAnswerNum() != 0 && practice.getCorrectNum() != 0){
                        practice.setAccuracy(df.format((float)practice.getCorrectNum()/(float)practice.getAnswerNum()));
                    }else{
                        practice.setAccuracy("0");
                    }
                }
            }
            page.setRecords(practices);
            r.setData(page);
        }catch (Exception e){
            r = ExceptionUtil.getException(e);
        }
        return r;
    }

    @RequestMapping(value = "/practiceStatistics/{id}",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "练习统计情况",notes = "练习统计情况")
    public R<PracticeStatistics> practiceStatistics(@ApiParam(value = "练习id")@PathVariable("id") Integer practiceId,
                                @ApiParam(value = "题库id")@RequestParam(value = "subjectsBankId",required = false) Integer subjectsBankId,
                                @ApiParam(value = "题型")@RequestParam(value = "subjectsType",required = false) String subjectsType){
        R r = new R();
        try {
            List<PracticeStatistics> practices = practiceService.queryPracticeStatistics(practiceId, subjectsBankId, subjectsType);
            r.setData(practices);
        }catch (Exception e){
            r = ExceptionUtil.getException(e);
        }
        return r;
    }
}
