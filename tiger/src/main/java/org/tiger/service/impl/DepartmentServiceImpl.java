package org.tiger.service.impl;

import org.tiger.service.DepartmentService;
import org.tiger.dao.DepartmentDao;
import org.tiger.entity.Department;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import support.service.BaseService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 部门的业务逻辑层的实现
 */
@Service
public class DepartmentServiceImpl extends BaseService<Department> implements DepartmentService {

	private DepartmentDao departmentDao;

	@Resource
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
		this.dao = departmentDao;
	}

	// 获取包含部门中文名称的列表
	public List<Department> queryDepartmentCnList(List<Department> resultList) {
		List<Department> departmentList = new ArrayList<Department>();
		for (Department entity : resultList) {
			Department department = new Department();
			department.setId(entity.getId());
			department.setDepartmentKey(entity.getDepartmentKey());
			department.setDepartmentValue(entity.getDepartmentValue());
			department.setParentDepartmentkey(entity.getParentDepartmentkey());
			if (StringUtils.isNotBlank(department.getParentDepartmentkey())) {
				Department d = departmentDao.getByProerties("departmentKey", department.getParentDepartmentkey());
				if (d != null) {
					department.setParentDepartmentValue(d.getDepartmentValue());
				}
			}
			department.setDescription(entity.getDescription());
			departmentList.add(department);
		}
		return departmentList;
	}

}
