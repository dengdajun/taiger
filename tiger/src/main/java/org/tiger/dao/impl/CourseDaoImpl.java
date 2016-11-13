package org.tiger.dao.impl;

import org.tiger.dao.CourseDao;
import org.tiger.entity.Course;
import org.springframework.stereotype.Repository;
import support.dao.BaseDao;

/**
 * 角色的数据持久层的实现类
 */
@Repository
public class CourseDaoImpl extends BaseDao<Course> implements CourseDao {

	public CourseDaoImpl() {
		super(Course.class);
	}


}
