package org.tiger.service.impl;

import org.tiger.dao.CourseDao;
import org.tiger.entity.Course;
import org.tiger.service.CourseService;
import org.springframework.stereotype.Service;
import support.service.BaseService;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@Service
public class CourseServiceImpl extends BaseService<Course> implements CourseService {
    private CourseDao courseDao;
    @Resource

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
        this.dao=courseDao;
    }
}
