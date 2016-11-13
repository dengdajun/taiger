package org.tiger.service.impl;

import org.tiger.dao.RoleAuthorityDao;
import org.tiger.entity.RoleAuthority;
import org.tiger.service.RoleAuthorityService;
import org.springframework.stereotype.Service;
import support.service.BaseService;

import javax.annotation.Resource;

/**
 * 角色权限的业务逻辑层的实现
 */
@Service
public class RoleAuthorityServiceImpl extends BaseService<RoleAuthority> implements RoleAuthorityService {

	private RoleAuthorityDao roleAuthorityDao;

	@Resource
	public void setRoleAuthorityDao(RoleAuthorityDao roleAuthorityDao) {
		this.roleAuthorityDao = roleAuthorityDao;
		this.dao = roleAuthorityDao;
	}

}
