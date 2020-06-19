package com.github.edu.modular.edu.service;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.IService;
import com.github.edu.modular.edu.model.CourseType;

import java.util.List;

/**
 * course_typeService
 *
 * @author lzq
 * @Date 2020-05-20 21:42:09
 */
public interface ICourseTypeService extends IService<CourseType>{
    //获取所有课程分类
    void getCourseTypes(CourseType courseType);
}
