package org.tiger.dao.impl;

import org.tiger.dao.OpenClassDao;
import org.tiger.entity.OpenClass;
import org.springframework.stereotype.Repository;
import support.dao.BaseDao;

/**
 * 角色的数据持久层的实现类
 */
@Repository
public class OpenClassDaoImpl extends BaseDao<OpenClass> implements OpenClassDao {

	public OpenClassDaoImpl() {
		super(OpenClass.class);
	}


}
