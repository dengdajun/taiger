package org.tiger.dao.impl;

import org.tiger.dao.DepartmentDao;
import org.tiger.entity.Department;
import org.springframework.stereotype.Repository;
import support.dao.BaseDao;

/**
 * 部门的数据持久层的实现类
 */
@Repository
public class DepartmentDaoImpl extends BaseDao<Department> implements DepartmentDao {

	public DepartmentDaoImpl() {
		super(Department.class);
	}

}
