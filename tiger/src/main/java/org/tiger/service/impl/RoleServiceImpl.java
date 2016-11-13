package org.tiger.service.impl;

import org.tiger.dao.RoleDao;
import org.tiger.entity.Role;
import org.tiger.service.RoleService;
import org.springframework.stereotype.Service;
import support.service.BaseService;

import javax.annotation.Resource;

/**
 * 角色的业务逻辑层的实现
 */
@Service
public class RoleServiceImpl extends BaseService<Role> implements RoleService {

	private RoleDao roleDao;

	@Resource
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
		this.dao = roleDao;
	}

	public void deleteSysUserAndRoleByRoleId(Long roleId) {
		roleDao.deleteSysUserAndRoleByRoleId(roleId);
	}

}
