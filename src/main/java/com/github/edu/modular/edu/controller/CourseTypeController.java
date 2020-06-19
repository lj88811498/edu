package com.github.edu.modular.edu.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.edu.core.base.controller.BaseController;
import com.github.edu.modular.edu.util.ExceptionUtil;
import com.github.edu.modular.edu.util.R;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.edu.core.log.LogObjectHolder;
import com.github.edu.modular.edu.model.CourseType;
import com.github.edu.modular.edu.service.ICourseTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

/**
 * course_type控制器
 *
 * @author lzq
 * @Date 2020-05-20 21:42:08
 */
@Controller
@RequestMapping("/courseType")
@Api(value = "课程分类", description = "课程分类")
public class CourseTypeController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(CourseTypeController.class);
    @Autowired
    private ICourseTypeService courseTypeService;

    /**
     * 获取course_type列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取课程分类列表", notes = "获取课程分类列表")
    public R list() {
        R r = new R();
        try {
            EntityWrapper<CourseType> wrapper = new EntityWrapper<>();
            wrapper.eq("course_type_parent_id",0);
            List<CourseType> courseTypes = courseTypeService.selectList(wrapper);
            if(null != courseTypes && courseTypes.size()>0){
                for (CourseType courseType : courseTypes) {
                    courseTypeService.getCourseTypes(courseType);
                }
            }
            r.setData(courseTypes);
        }catch (Exception e){
            logger.error("获取课程分类列表失败",e);
            r = ExceptionUtil.getException(e);
        }
        return r;
    }

    /**
     * 新增course_type
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增课程分类", notes = "新增课程分类")
    public R add(@RequestBody CourseType courseType) {
        R r = new R();
        try {
            courseTypeService.insert(courseType);
        }catch (Exception e){
            logger.error("新增课程分类失败",e);
            r = ExceptionUtil.getException(e);
        }
        return r;
    }

    /**
     * 删除course_type
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除课程分类", notes = "删除课程分类")
    public R delete(@ApiParam(value = "删除的id集合")@RequestParam(value = "ids",required = false) List<Integer> ids) {
        R r = new R();
        try {
            if(null == ids || ids.isEmpty()){
                r.setCode(R.FAIL);
                r.setMsg("请选择需要删除的数据");
                return r;
            }
            courseTypeService.deleteBatchIds(ids);
        }catch (Exception e){
            logger.error("删除课程分类失败",e);
            r = ExceptionUtil.getException(e);
        }
        return r;
    }

    /**
     * 修改course_type
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改课程分类", notes = "修改课程分类")
    public R update(CourseType courseType) {
        R r = new R();
        try {
            courseTypeService.updateById(courseType);
        }catch (Exception e){
            logger.error("修改课程分类失败",e);
            r = ExceptionUtil.getException(e);
        }
        return r;
    }

    /**
     * course_type详情
     */
    @RequestMapping(value = "/detail/{courseTypeId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "course_type详情", notes = "course_type详情")
    public R detail(@PathVariable("courseTypeId") Integer courseTypeId) {
        R r = new R();
        try {
            CourseType courseType = courseTypeService.selectById(courseTypeId);
            r.setData(courseType);
        }catch (Exception e){
            logger.error("修改课程分类失败",e);
            r = ExceptionUtil.getException(e);
        }
        return r;
    }
}
