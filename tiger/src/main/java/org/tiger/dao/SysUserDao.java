package org.tiger.dao;

import org.tiger.entity.SysUser;
import support.dao.Dao;

/**
 * 用户的数据持久层的接口
 */
public interface SysUserDao extends Dao<SysUser> {

	String getRoleValueBySysUserId(Long sysUserId);

}
