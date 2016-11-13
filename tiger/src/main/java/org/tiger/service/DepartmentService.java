package org.tiger.service;

import org.tiger.entity.Department;
import support.service.Service;

import java.util.List;

/**
 * 部门的业务逻辑层的接口
 */
public interface DepartmentService extends Service<Department> {

	// 获取包含部门中文名称的列表
	List<Department> queryDepartmentCnList(List<Department> resultList);

}
