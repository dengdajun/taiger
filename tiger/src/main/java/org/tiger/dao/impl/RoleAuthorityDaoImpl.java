package org.tiger.dao.impl;

import org.tiger.dao.RoleAuthorityDao;
import org.tiger.entity.RoleAuthority;
import org.springframework.stereotype.Repository;
import support.dao.BaseDao;

/**
 * 角色权限的数据持久层的实现类
 */
@Repository
public class RoleAuthorityDaoImpl extends BaseDao<RoleAuthority> implements RoleAuthorityDao {

	public RoleAuthorityDaoImpl() {
		super(RoleAuthority.class);
	}

}
