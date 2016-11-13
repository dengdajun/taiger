package org.tiger.service;

import org.tiger.entity.SysUser;
import support.service.Service;

import java.util.List;

/**
 * 用户的业务逻辑层的接口
 */
public interface SysUserService extends Service<SysUser> {

	// 获取用户信息（将数据库查询出来的信息再处理，增加字段的中文意思）
	List<SysUser> querySysUserCnList(List<SysUser> resultList);

	// 获取个人资料信息（将数据库查询出来的信息再处理，增加头像）
	SysUser getSysUserWithAvatar(SysUser sysuser);


}
