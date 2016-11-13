package org.tiger.service;

import org.tiger.entity.Role;
import support.service.Service;

/**
 * 角色的业务逻辑层的接口
 */
public interface RoleService extends Service<Role> {

	// 删除角色
	void deleteSysUserAndRoleByRoleId(Long roleId);

}
