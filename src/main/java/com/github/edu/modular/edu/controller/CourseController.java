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
import com.github.edu.modular.edu.model.Course;
import com.github.edu.modular.edu.service.ICourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * course控制器
 *
 * @author lzq
 * @Date 2020-05-27 22:13:42
 */
@Controller
@RequestMapping("/course")
@Api(value = "Course-controller", description = "course")
public class CourseController extends BaseController {

    private String PREFIX = "/edu/course/";

    @Autowired
    private ICourseService courseService;

    /**
     * 跳转到course首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "course.html";
    }

    /**
     * 跳转到添加course
     */
    @RequestMapping("/course_add")
    public String courseAdd() {
        return PREFIX + "course_add.html";
    }

    /**
     * 跳转到修改course
     */
    @RequestMapping(value = "/course_update/{courseId}", method = RequestMethod.GET)
    @ApiOperation(value = "编辑course", notes = "编辑course")
    public String courseUpdate(@PathVariable Integer courseId, Model model) {
        Course course = courseService.selectById(courseId);
        model.addAttribute("item",course);
        LogObjectHolder.me().set(course);
        return PREFIX + "course_edit.html";
    }

    /**
     * 获取course列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取course列表", notes = "获取course列表")
    public Object list(String condition) {
        return courseService.selectList(null);
    }

    /**
     * 新增course
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增course", notes = "新增course")
    public Object add(Course course) {
        courseService.insert(course);
        return SUCCESS_TIP;
    }

    /**
     * 删除course
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除course", notes = "删除course")
    public Object delete(@RequestParam Integer courseId) {
        courseService.deleteById(courseId);
        return SUCCESS_TIP;
    }

    /**
     * 修改course
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改course", notes = "修改course")
    public Object update(Course course) {
        courseService.updateById(course);
        return SUCCESS_TIP;
    }

    /**
     * course详情
     */
    @RequestMapping(value = "/detail/{courseId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "course详情", notes = "course详情")
    public Object detail(@PathVariable("courseId") Integer courseId) {
        return courseService.selectById(courseId);
    }
}
