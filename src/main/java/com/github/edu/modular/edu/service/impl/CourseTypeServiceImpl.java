package com.github.edu.modular.edu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.edu.modular.edu.dao.CourseTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.github.edu.modular.edu.model.CourseType;
import org.springframework.stereotype.Service;
import com.github.edu.modular.edu.service.ICourseTypeService;

import java.util.List;


/**
 * course_typeService
 *
 * @author lzq
 * @Date 2020-05-20 21:42:09
 */
@Service
public class CourseTypeServiceImpl extends ServiceImpl<BaseMapper<CourseType>,CourseType> implements ICourseTypeService {
    @Autowired
    private CourseTypeMapper courseTypeMapper;
    //获取所有课程分类
    @Override
    public void getCourseTypes(CourseType courseType) {
        EntityWrapper<CourseType> wrapper = new EntityWrapper<>();
        if(null != courseType.getCourseTypeId()){
            wrapper.eq("course_type_parent_id",courseType.getCourseTypeId());
            List<CourseType> courseTypes = courseTypeMapper.selectList(wrapper);
            if(null != courseTypes && courseTypes.size()>0){
                courseType.setCourseTypeList(courseTypes);
                for (CourseType course : courseTypes) {
                    getCourseTypes(course);
                }
            }
        }
//        return courseType;
    }
}
