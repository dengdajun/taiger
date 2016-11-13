package org.tiger.dao.impl;

import org.tiger.dao.AuthorityDao;
import org.tiger.entity.Authority;
import org.springframework.stereotype.Repository;
import support.dao.BaseDao;

/**
 * 菜单的数据持久层的实现类
 */
@Repository
public class AuthorityDaoImpl extends BaseDao<Authority> implements AuthorityDao {

	public AuthorityDaoImpl() {
		super(Authority.class);
	}

}
