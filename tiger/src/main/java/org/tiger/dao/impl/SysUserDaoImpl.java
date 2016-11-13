package org.tiger.dao.impl;

import org.tiger.dao.SysUserDao;
import org.tiger.entity.SysUser;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import support.dao.BaseDao;

/**
 * 用户的数据持久层的实现类
 */
@Repository
public class SysUserDaoImpl extends BaseDao<SysUser> implements SysUserDao {

	public SysUserDaoImpl() {
		super(SysUser.class);
	}



	@Override
	public String getRoleValueBySysUserId(Long sysUserId) {
		Query query = this.getSession().createSQLQuery("select role_value from sysuser_role,role where sysuser_role.role_id = role.id and sysuser_id = :sysUserId");
		query.setParameter("sysUserId", sysUserId);
		String roleValue = query.uniqueResult() == null ? "" : (String) query.uniqueResult();
		return roleValue;
	}

}
