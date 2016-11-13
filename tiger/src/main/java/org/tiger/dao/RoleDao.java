package org.tiger.dao;

import org.tiger.entity.Role;
import support.dao.Dao;

/**
 * 角色的数据持久层的接口
 */
public interface RoleDao extends Dao<Role> {

	// 删除角色
	void deleteSysUserAndRoleByRoleId(Long roleId);

	// 根据菜单编码删除按钮权限
	void deleteRolePermissionByMenuCode(String menuCode);

	// 保存按钮权限
	void saveRolePermission(Long roleId, String permissions);

}
