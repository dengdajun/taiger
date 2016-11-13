package org.tiger.service;

import org.tiger.entity.Authority;
import support.service.Service;

import java.util.List;

/**
 * 菜单的业务逻辑层的接口
 */
public interface AuthorityService extends Service<Authority> {

	// 获取多级菜单
	List<Authority> queryAllMenuList(String globalRoleKey);

	// 获取按钮权限数据
	String getAuthorityButtonList(String menuCode);

	// 保存角色权限
	void saveAuthorityButtonList(String checkboxList, String menuCode);

}
